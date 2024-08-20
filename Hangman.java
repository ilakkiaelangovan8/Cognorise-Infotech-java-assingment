import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        // List of words for the game
        List<String> words = Arrays.asList("java", "hangman", "programming", "development", "computer");

        // Select a random word from the list
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        char[] guessedWord = new char[word.length()];
        Arrays.fill(guessedWord, '_');

        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 6;
        int incorrectGuesses = 0;
        List<Character> wrongGuesses = new ArrayList<>();

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");

        while (incorrectGuesses < maxAttempts && new String(guessedWord).contains("_")) {
            // Display the current state of the guessed word
            System.out.println("\nWord: " + new String(guessedWord));
            System.out.println("Wrong guesses: " + wrongGuesses);
            System.out.println("Attempts left: " + (maxAttempts - incorrectGuesses));
            System.out.println("Enter a letter: ");

            // Get the user's guess
            char guess = scanner.next().toLowerCase().charAt(0);

            // Check if the letter is in the word
            if (word.indexOf(guess) >= 0) {
                // Update the guessedWord array
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        guessedWord[i] = guess;
                    }
                }
            } else {
                // Add the wrong guess and increment incorrectGuesses
                if (!wrongGuesses.contains(guess)) {
                    wrongGuesses.add(guess);
                    incorrectGuesses++;
                }
            }

            // Display hangman figure
            displayHangman(incorrectGuesses);

            if (new String(guessedWord).equals(word)) {
                System.out.println("Congratulations! You've guessed the word: " + word);
                break;
            }
        }

        if (incorrectGuesses == maxAttempts) {
            System.out.println("Game Over! The word was: " + word);
        }

        scanner.close();
    }

    private static void displayHangman(int incorrectGuesses) {
        System.out.println("\nHangman Figure:");
        switch (incorrectGuesses) {
            case 0:
                System.out.println("   +---+");
                System.out.println("   |   ");
                System.out.println("       ");
                System.out.println("       ");
                System.out.println("       ");
                break;
            case 1:
                System.out.println("   +---+");
                System.out.println("   |   O");
                System.out.println("       ");
                System.out.println("       ");
                System.out.println("       ");
                break;
            case 2:
                System.out.println("   +---+");
                System.out.println("   |   O");
                System.out.println("   |   |");
                System.out.println("       ");
                System.out.println("       ");
                break;
            case 3:
                System.out.println("   +---+");
                System.out.println("   |   O");
                System.out.println("   |  /|\\");
                System.out.println("       ");
                System.out.println("       ");
                break;
            case 4:
                System.out.println("   +---+");
                System.out.println("   |   O");
                System.out.println("   |  /|\\");
                System.out.println("   |   /");
                System.out.println("       ");
                break;
            case 5:
                System.out.println("   +---+");
                System.out.println("   |   O");
                System.out.println("   |  /|\\");
                System.out.println("   |  / \\");
                System.out.println("       ");
                break;
            case 6:
                System.out.println("   +---+");
                System.out.println("   |   O");
                System.out.println("   |  /|\\");
                System.out.println("   |  / \\");
                System.out.println("   |   ");
                System.out.println("  / \\");
                break;
        }
    }
}
