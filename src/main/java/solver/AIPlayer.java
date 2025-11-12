// ============================================================================
// AIPlayer.java
// AI Wordle Solver Project
// Author: Eccyolk
// Date: 08/11/2025
//
// Description:
// This class represents the AI player that attempts to solve Wordle.
// It keeps track of all possible valid words, makes guesses, amd filters
// out impossible options after each round of feedback.
// ============================================================================

package main.java.solver;

// Import all Java utilities
import java.util.*;

public class AIPlayer {
    
    // Declare variable to store all possible remaining words that could still be the answer
    private List<String> possibleWords;

    // Declare an array to store tactical first-guess words for the AI to choose from
    private static final String[] startingWords = {"ADIEU", "AROSE", "AESIR", "ARLES", "SLATE"};

    // Initialise variable to track number of guesses made so far
    int attempts = 0;

    // Constructor: initalise the AI player with the full list of valid answer words
    public AIPlayer()
    {
        possibleWords = new ArrayList<String>(WordList.answerList);
    }

    // Method to make the next guess based on remaining possible words
    public String makeGuess()
    {
        attempts++;
        Random random = new Random();

        // First guess: randomly pick a tactical starting word
        if (attempts == 1){
            return startingWords[random.nextInt(startingWords.length)];
        }

        // Otherwise, pick a random word from remaining possibilities
        if (!possibleWords.isEmpty()) {
            return possibleWords.get(random.nextInt(possibleWords.size()));
        }

        // Fallback if list is somehow empty (shouldn't occur)
        return "";
    }

    // Method to update the list of possible words based on the latest feedback
    public void updatePossibleWords(String guess, String feedback)
    {
        List<String> updatedList = new ArrayList<String>();

        for (String word : possibleWords) {
            // Keep only words that would produce the same feedback pattern
            if (matchesFeedback(word, guess, feedback)) {
                updatedList.add(word);
            }
        }

        // Replace old list with filtered version
        possibleWords = updatedList;
    }

    // Method to check if a word could still be the target given the latest feedback
    private boolean matchesFeedback(String word, String guess, String feedback) {
        String simulatedFeedback = GuessEvaluator.evaluateGuess(guess, word);
        return simulatedFeedback.equals(feedback);
    }
}