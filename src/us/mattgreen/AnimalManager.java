package us.mattgreen;

import java.util.Objects;
import java.util.Scanner;

public class AnimalManager {
    public Scanner sc = new Scanner(System.in);

    // parent method
    public void createAnimalWithInput(){
        String input;

        do {

            input = getInput("\n\nWhat type of animal would you like to create?\n\n1) Pet\n2) Human (Teacher)\n\n> ");

            // pet
            if(input.equals("1")) {
                 createPet();

            // human
            } else if(input.equals("2")) {

                createTeacher();

            // invalid, repeat loop
            } else {
                System.out.println("Please select a valid option");
            }

        } while (!input.equals("1") && !input.equals("2"));
    }

    // helper methods
    private String getInput(String prompt) {
        System.out.print(prompt);

        // no validation needed, this will be used in other methods
        // and each method will have different validation.
        return sc.nextLine();
    }

    private void createPet() {
        Pet pet;

        String input;

        do {

            input = getInput("\n\nWhich type of Pet would you like to create?\n\n1) Dog\n2) Cat\n\n> ");

            // dog
            if(input.equals("1")) {
                pet = createDog();

            // cat
            } else if(input.equals("2")) {
                pet = createCat();

            // invalid, repeat loop
            } else {
                System.out.println("Please select a valid option");
            }

        } while (!input.equals("1") && !input.equals("2"));
    }

    private Cat createCat() {
        Cat cat = null;

        String name;

        do {
            name = getInput("\n\nWhat is the name of this cat?\n\n> ");

            // continue
            if(!name.isBlank()) {

                // continue
                if(name.length() > 1) {

                    // get mousesKilled field
                    String mice;
                    int numMice = -1;

                    do {
                        mice = getInput(String.format("\n\nHow many mice has %s killed?\n\n> ", name));

                        try {
                            numMice = Integer.parseInt(mice.strip());

                            // invalid, repeat loop
                            if(numMice < 0) {
                                System.out.println("Please enter a positive value!");
                            }

                        // invalid, repeat loop
                        } catch(Exception e) {
                            numMice = -1;

                            System.out.println("Please enter a valid number!");
                        }

                    } while (numMice < 0);

                    cat = new Cat(numMice, name);

                // invalid, repeat loop
                } else {
                    System.out.println("Name must be AT LEAST 2 characters long!");
                }

            // invalid, repeat loop
            } else {
                System.out.println("Please enter a valid name!");
            }

        } while(name.isBlank());

        return cat;
    }

    private Dog createDog() {
        Dog dog = null;

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
                        friendly = getInput(String.format("\n\nIs %s friendly?\n\ny) Yes\nn) No\n\n> ", name));

                        // yes
                        if(friendly.equals("y")) {
                            isFriendly = true;

                        // no
                        } else if(friendly.equals("n")) {
                            isFriendly = false;

                        // invalid, repeat loop
                        } else {
                            System.out.println("Please enter a valid option!");
                        }

                    } while(!friendly.equals("y") && !friendly.equals("n"));

                    // create object
                    dog = new Dog(isFriendly, name);

                // invalid, repeat loop
                } else {
                    System.out.println("Name must be AT LEAST 2 characters long!");
                }

            // invalid, repeat loop
            } else {
                System.out.println("Please enter a valid name!");
            }

        } while(name.isBlank());

        return dog;
    }

    private void createTeacher() {

    }
}
