// ============================================================================
// UserPlay.java
// AI Wordle Solver Project
// Author: Eccyolk
// Date: 08/11/2025
//
// Description:
// This class handles the human player's interaction with the Wordle game.
// It manages user input, validates guesses, provides feedback, and
// displays results after each attempt.
// ============================================================================

package main.java.solver;

// Import all Java utilities;
import java.util.*;

public class UserPlay {

    // Method to start the human player's Wordle session
    public static int start(String targetWordHuman, Scanner scanner, boolean showBanner) {

        // Initialise constant for official number of Wordle attempts
        final int maxAttempts = 6;

        // Display welcome message
        if (showBanner) {
            Utils.printBanner();
            System.out.println("=======================================");
            System.out.println("               USER MODE");
            System.out.println("=======================================\n");
        }
        System.out.println("Welcome to Wordle! Guess the 5-letter word.");

        // Loop through each attempt
        for (int i = 1; i <= maxAttempts; i++) {

            // Receive guess from user
            System.out.println("\nAttempt " + i + ": ");
            String guess = scanner.nextLine().trim().toUpperCase();

            // Check input is 5 letters long (input validation)
            if (guess.length() != 5) {
                System.out.println("Please enter a 5 letter word\n");
                // Invalid input doesn't count as an attempt
                i--;
                continue;
            }
            // Check input is on the list of valid guesses (input validation)
            else if (!WordList.validList.contains(guess)){
                System.out.println("Invalid word! Guess a real word from the allowed list.");
                i--;
                continue;
            }

            // Evaluate the guess and display colour-coded feedback
            String feedback = GuessEvaluator.evaluateGuess(guess, targetWordHuman);
            GuessEvaluator.printColouredFeedback(guess, feedback);

            // Check if user guessed the target word correctly
            if (guess.equals(targetWordHuman)) {
                Utils.delay(500);
                System.out.println("\nCongratulations! You guessed the word in " + i + " attempts!");
                return i;
            }

            // Reveal target word if this was the last attempt
            if (i == maxAttempts) {
                Utils.delay(500);
                System.out.println("\nSorry! You've used all attempts. The word was: " + targetWordHuman + "!");
            }
        }

        // Indicate that user failed
        return -1;
    }
}