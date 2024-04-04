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
                //TODO: createDog()
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

    private void createTeacher() {

    }
}
