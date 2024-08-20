import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        // Create a Random object to generate a random number
        Random random = new Random();
        // Generate a random number between 1 and 100
        int targetNumber = random.nextInt(100) + 1;

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Set the maximum number of attempts
        int maxAttempts = 5;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        // Start the game
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

        // Loop until the user guesses correctly or runs out of attempts
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            // Compare the user's guess with the generated number
            if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number correctly.");
                hasGuessedCorrectly = true;
                break;
            }

            // Provide feedback on remaining attempts
            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
        }

        // If the user did not guess the number correctly, reveal the number
        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
        }

        // Close the scanner
        scanner.close();
    }
}
