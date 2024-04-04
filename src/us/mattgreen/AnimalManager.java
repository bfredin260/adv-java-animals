package us.mattgreen;

import java.util.Scanner;

public class AnimalManager {
    // minimum length of animal names
    public static int MIN_NAME_LEN = 2;

    public Scanner sc = new Scanner(System.in);

    // parent method
    // helper methods

    public Talkable createAnimalWithInput(){
        Talkable animal = null;

        String input;

        do {
            input = getInput("\n\nWhat type of animal would you like to create?\n\n1) Pet\n2) Human (Teacher)\n\n> ");

            // pet
            if(input.equals("1")) {
                animal = (Talkable) createPet();

            // human
            } else if(input.equals("2")) {
                animal = (Talkable) createTeacher();

            // invalid, repeat loop
            } else {
                System.out.println("Please select a valid option");
            }

        } while (!input.equals("1") && !input.equals("2"));

        return animal;
    }

    private Pet createPet() {
        Pet pet = null;

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

        return pet;
    }

    private Cat createCat() {
        String name = getValidAnimalName("cat");

        return new Cat(getPositiveNum(String.format("How many mice has %s killed?", name)), name);
    }

    private Dog createDog() {
        String name = getValidAnimalName("dog");

        return new Dog(getValidBoolean(String.format("Is %s friendly?", name)), name);
    }

    private Teacher createTeacher() {
        String name = getValidAnimalName("teacher");

        return new Teacher(getPositiveNum(String.format("How old is %s?", name)), name);
    }

    private String getInput(String prompt) {
        System.out.print(prompt);

        // no validation needed, this will be used in other methods
        // and each method will have different validation.
        return sc.nextLine();
    }

    private String getValidAnimalName(String animal) {
        String name;

        do {
            name = getInput(String.format("\n\nWhat is the name of this %s?\n\n> ", animal));

            // continue
            if(!name.isBlank()) {

                // invalid, repeat loop
                if(name.length() < MIN_NAME_LEN) {
                    System.out.println(String.format("Name must be AT LEAST %d characters long!", MIN_NAME_LEN));
                }

            // invalid, repeat loop
            } else {
                System.out.println("Please enter a valid name!");
            }

        } while(name.isBlank() || name.length() < MIN_NAME_LEN);

        return name;
    }

    private int getPositiveNum(String prompt) {
        String input;

        int num;

        do {
            input = getInput(String.format("\n\n%s\n> ",prompt));

            try {
                num = Integer.parseInt(input.strip());

                // invalid, repeat loop
                if(num < 0) {
                    System.out.println("Please enter a positive value!");
                }

                // invalid, repeat loop
            } catch(Exception e) {
                num = -1;

                System.out.println("Please enter a valid number!");
            }

        } while (num < 0);

        return num;
    }

    private boolean getValidBoolean(String prompt) {
        String input;

        boolean bool = false;

        do {
            input = getInput(String.format("\n\n%s\n\ny) Yes\nn) No\n\n> ", prompt));

            // yes
            if(input.equals("y")) {
                bool = true;

            // no
            } else if(input.equals("n")) {
                bool = false;

            // invalid, repeat loop
            } else {
                System.out.println("Please enter a valid option!");
            }

        } while(!input.equals("y") && !input.equals("n"));

        return bool;
    }
}
