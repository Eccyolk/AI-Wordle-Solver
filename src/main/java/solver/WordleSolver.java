// ============================================================================
// WordleSolver.java
// AI Wordle Solver Project
// Author: Eccyolk
// Date: 08/11/2025
//
// Description:
// This class runs the AI's Wordle-solving process.
// It simulates the AI making up to 6 guesses, receives feedback
// for each one, and updates its list of possible words until it
// either guesses the target word or runs out of attempts.
// ============================================================================

package main.java.solver;

public class WordleSolver {

    // Method to start the AI solver and run through all guessing attempts
    public static int start(String targetWordAI, boolean showBanner) {
        
        // Display welcome message
        if (showBanner) {
        Utils.printBanner();
        System.out.println("=======================================");
        System.out.println("                AI MODE");
        System.out.println("=======================================\n");
        System.out.println("The AI will try to solve a 5-letter Wordle!");
        }

        // System.out.println("Selected target word (for testing): " + targetWordAI);

        // Create an AI Player instance
        AIPlayer ai = new AIPlayer();

        // Initialise constant for official number of Wordle attempts
        final int maxGuesses = 6;

        // Loop through each guessing attempt
        for (int i = 1; i <= maxGuesses; i++) {

            // AI makes a guess
            Utils.delay(800);
            String guess = ai.makeGuess();
            Utils.delay(800);
            System.out.println("\nAttempt " + i + ": AI guesses " + guess);

            // Evaluate the guess and display colour-coded feedback
            String feedback = GuessEvaluator.evaluateGuess(guess, targetWordAI);
            GuessEvaluator.printColouredFeedback(guess, feedback);

            // Check if AI guessed the target word correctly
            if (guess.equals(targetWordAI)) {
                Utils.delay(500);
                System.out.println("\nAI guessed the word in " + i + " attempts!");
                return i;
            }

            // Update AI's possible word list based on feedback
            ai.updatePossibleWords(guess, feedback);

            // Display message if AI fails to guess after final attempt
            if (i == maxGuesses) {
                Utils.delay(500);
                System.out.println("\nAI failed to guess the word!");
                System.out.println("The word was: " + targetWordAI + ".\n");
            }
        }

        // Indicate that AI failed
        return -1;
    }
}