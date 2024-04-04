package us.mattgreen;

import java.util.Scanner;

public class AnimalManager {
    public Scanner sc = new Scanner(System.in);

    // parent method
    public void createAnimalWithInput(){
        String input;

        do {

            input = getInput("\n\nWhat type of animal would you like to create?\n\n1) Pet\n2) Human (Teacher)\n\n> ");

            // pet
            if(input == "1") {
                 createPet();

            // human
            } else if(input == "2") {

                createTeacher();

            // invalid, repeat loop
            } else {
                System.out.println("Please select a valid option");
            }

        } while (input != "1" && input != "2");
    }

    // helper methods
    private String getInput(String prompt) {
        System.out.print(prompt);

        // no validation needed, this will be used in other methods
        // and each method will have different validation.
        return sc.nextLine();
    }

    private void createPet() {
        String input;

        do {

            input = getInput("\n\nWhich type of Pet would you like to create?\n\n1) Dog\n2) Cat\n\n> ");

            // dog
            if(input == "1") {
                createDog();

            // cat
            } else if(input == "2") {
                //TODO: createCat()
                createCat();

            // invalid, repeat loop
            } else {
                System.out.println("Please select a valid option");
            }

        } while (input != "1" && input != "2");
    }

    private void createCat() {

    }

    private void createDog() {
        String name;

        do {
            name = getInput("\n\nWhat is the name of this dog?\n\n> ");

            // continue
            if(!name.isBlank()) {

                // continue
                if(name.length() > 1) {

                    // get boolean for friendly field
                    String friendly;
                    boolean isFriendly = false;

                    do {
                        friendly = getInput(String.format("\n\nIs %s friendly?\n\n> ", name));

                        // yes
                        if(friendly == "y") {
                            isFriendly = true;

                        // no
                        } else if(friendly == "n") {
                            isFriendly = false;

                        // invalid, repeat loop
                        } else {
                            System.out.println("Please enter a valid option!");
                        }

                    } while(friendly != "y" && friendly != "n");

                    // create object
                    Dog dog = new Dog(isFriendly, name);

                // invalid, repeat loop
                } else {
                    System.out.println("Name must be AT LEAST 2 characters long!");
                }

            // invalid, repeat loop
            } else {
                System.out.println("Please enter a valid name!");
            }

        } while(!name.isBlank());
    }

    private void createTeacher() {

    }
}
