// ============================================================================
// WordList.java
// AI Wordle Solver Project
// Author: Eccyolk
// Date: 08/11/2025
//
// Description:
// This class manages all Wordle words used in the game.
// It loads 5-letter words from external text files
// and stores them in two lists:
//    - answerList: words that can be the correct answer
//    - validList: all allowed guesses (including answer words)
//
// It also provides a method to randomly select a word from a list.
// ============================================================================

package main.java.solver;

// Import input/output API and all Java utilities
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordList {

    // Declare list of possible target (answer) words
    public static List<String> answerList = new ArrayList<>();

    // Declare list of all valid 5-letter guesses (including answers)
    public static List<String> validList = new ArrayList<>();

    // Method to load 5-letter words from a text file into the specified list
    public static void loadWordsFromFile(String filePath, List<String> list) {
        try {
            // Declare a file and a scanner to read from it
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            // Read and process each line of the file
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().trim().toUpperCase();

                // Only include 5-letter words
                if (word.length() == 5) {
                    list.add(word);
                }
            }

            // Close scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            // Display error message if file can't be found
            System.out.println("Error: file not found -> " + filePath);
        }
    }

    // Method to clear existing data then load both the answer and valid word lists
    public static void loadWordLists(String answerFilePath, String validFilePath) {
        answerList.clear();
        validList.clear();

        loadWordsFromFile(answerFilePath, answerList);
        loadWordsFromFile(validFilePath, validList);

        System.out.println("Word lists loaded successfully!");
    }

    // Method to return a random word from the given list
    public static String getRandomWord(List<String> list) {

        // Return error if list is empty
        if (list.isEmpty()) return "error";

        // Create a random number generator
        Random random = new Random();

        // Return a random word from the given list
        return list.get(random.nextInt(list.size()));
    }
}