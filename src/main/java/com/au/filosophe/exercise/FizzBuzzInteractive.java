package com.au.filosophe.exercise;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

/**
 * This class demonstrates the use of FizzBuzz transformer.
 *
 * @author Anita Kesavan
 * @version 1.0
 * @since 22/02/2020
 */
public class FizzBuzzInteractive {

    final FizzBuzzTransformer transformer = new FizzBuzzTransformer();

    /**
     * Main method to start the interactive demo. The demo allows you to choose between
     * playing a game of fizz buzz with the computer and displaying range of numbers
     * with fizz buzz replaced based on the rules.
     *
     * @param args
     */

    public static void main(final String args[]) {
        final FizzBuzzInteractive interactive = new FizzBuzzInteractive();

        interactive.displayMenu();
        final Scanner scanner = new Scanner(System.in);
        String input;

        while ((input = scanner.nextLine()) != null) {
            switch (input) {
                case "1":
                    interactive.startGame(scanner);
                    break;
                case "2":
                    interactive.displayRange(scanner);
                    break;
                case "3":
                    return;
            }
            interactive.displayMenu();
        }
    }

    private void displayMenu() {
        System.out.println("Please choose one of the following options :");
        System.out.println("1. Play Fizz Buzz");
        System.out.println("2. Display Fizz Buzz sequence for range");
        System.out.println("3. Quit");
        System.out.print("Enter your choice : ");
    }

    private void startGame(final Scanner scanner) {
        String playerInput;
        int counter = 1;
        System.out.println("Game rules : Enter number in ascending order. \nIf number is divisible by 3, enter 'Fizz'. \nIf number is divisible by 5, enter 'Buzz'. \nIf divisible by both, enter 'FizzBuzz'. \nThe game will go on till 100.\n");

        while (true) {
            System.out.println("My turn : " + transformer.transform(counter++));
            System.out.print("Your turn : ");
            playerInput = scanner.nextLine();
            String expectedInput = transformer.transform(counter++);
            if (!expectedInput.equalsIgnoreCase(playerInput)) {
                System.out.println(" ************ You lost ! ************\n");
                break;
            } else if (counter >= 100) {
                System.out.println(" ************ You won ! ************\n");
                break;
            }
        }
    }

    private void displayRange(final Scanner scanner) {
        int start = getValidInput(scanner, 1, "Please enter the beginning number :");
        int end = getValidInput(scanner, start + 1, "Please enter the ending number :");

        final List<String> result = transformer.transformRange(start, end);

        System.out.println(format("Fizz Buzz substitution for numbers ranging from %d to %d\n%s\n", start, end, result.toString()));
    }

    private int getValidInput(final Scanner scanner, final int minValue, final String prompt) {
        String inputValue;
        int validValue = -1, value;
        while (validValue < 0) {
            System.out.print(prompt);
            inputValue = scanner.nextLine();
            try {
                value = parseInt(inputValue);
                if (value < minValue) {
                    System.out.println("Please enter a value greater than or equal to " + minValue);
                } else {
                    validValue = value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Only numeric inputs are accepted.");
            }
        }
        return validValue;
    }
}