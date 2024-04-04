package us.mattgreen;

import java.util.Scanner;

public class AnimalManager {

    // gets user input
    public Scanner sc = new Scanner(System.in);

    public void createAnimal() {
        String input = getInput("\n\nWhat type of animal would you like to create?\n\n1) Pet\n2) Human");
    }

    private String getInput(String prompt) {
        String input;

        System.out.print(prompt);

        input = sc.nextLine();

        return input;
    }
}
