// ============================================================================
// GuessEvaluator.java
// AI Wordle Solver Project
// Author: Eccyolk
// Date: 08/11/2025
//
// Description:
// This class evaluates a Wordle guess against the target word.
// It provides feedback using the format "GBYBB", where each character means:
// G = correct letter in the correct position (green)
// Y = correct letter but in the wrong position (yellow)
// B = letter not in the target word (black)
//
// It also includes a method to print the feedback with terminal colours.
// ============================================================================

package main.java.solver;

public class GuessEvaluator {

    // Method to compare the player's guess to the target word and generate feedback
    public static String evaluateGuess(String guess, String targetWord) {

        // Initialise arrays
        char[] feedback = new char[guess.length()];
        boolean[] used = new boolean[targetWord.length()];

        // Pass 1: Mark green letters (correct position)
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == targetWord.charAt(i)) {
                feedback[i] = 'G';
                // Mark target position as used
                used[i] = true;
            }
        }

        // Pass 2: Mark yellow or black letters
        for (int i = 0; i < guess.length(); i++) {

            // Skip letters already marked as green
            if (feedback[i] == 'G') continue; 

            boolean found = false;

            // Check if guessed letter exists elsewhere in the target
            for (int j = 0; j < targetWord.length(); j++) {
                // If target letter is unused and matches guess letter
                if (!used[j] && guess.charAt(i) == targetWord.charAt(j)) {
                    // Mark as found and set target position to used
                    found = true;
                    used[j] = true;
                    break;
                }
            }

            // Assign final feedback for this position
            feedback[i] = found ? 'Y' : 'B';
        }

        // Return completed feedback string
        return new String(feedback);
    }

    // Method to print the guess with colour-coded feedback in the terminal
    public static void printColouredFeedback(String guess, String feedback) {

        // Colour codes for output
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String GREY = "\u001B[90m";
        final String RESET = "\u001B[0m";

        for (int i = 0; i < guess.length(); i++) {
            char letter = guess.charAt(i);
            char result = feedback.charAt(i);

            switch (result) {
                case 'G': System.out.print(GREEN + letter + RESET); break;
                case 'Y': System.out.print(YELLOW + letter + RESET); break;
                case 'B': System.out.print(GREY + letter + RESET); break;
            }
        }

        // Move to next line after feedback is printed
        System.out.println();
    }
}