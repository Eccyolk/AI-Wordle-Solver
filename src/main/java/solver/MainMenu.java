// ============================================================================
// MainMenu.java
// AI Wordle Solver Project
// Author: Eccyolk
// Date: 08/11/2025
//
// Description:
// Entry point and main menu for the AI Wordle Solver Project.
// Handles user interaction to choose between Human mode, AI Solver mode,
// Human vs AI mode, and quitting. Includes play again / return to menu options.
// ============================================================================

package main.java.solver;

// Import all Java utilities
import java.util.*;

public class MainMenu {

    // Main method to display main menu and process user input
    public static void main(String[] args) {

        // Load word lists (answers and valid guesses)
        WordList.loadWordLists("src/main/resources/answerwords.txt", "src/main/resources/validwords.txt");

        // Declare scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Initialise control variable for menu loop
        boolean running = true;

        // Main menu loop
        while (running) {
            Utils.clearScreen();
            Utils.printBanner();
            Utils.printMenu();

            // Receive choice from user
            String choice = scanner.nextLine().trim();

            // Different outcomes based on user's choice
            switch (choice) {
                case "1":
                    // Run User gamemode
                    runGame("User", scanner);
                    break;
                case "2":
                    // Run AI Solver gamemode
                    runGame("AI", scanner);
                    break;
                case "3":
                    // Run User vs AI gamemode
                    runGame("UserVsAI", scanner);
                    break;
                case "4":
                    // Quit program
                    System.out.println("\nFarewell!");
                    running = false;
                    break;
                default:
                    // Invalid input handling
                    System.out.println("\nInvalid input. Please enter a number between 1 and 4.");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    break;
            }
        }

        // Close scanner
        scanner.close();
    }

    // Method to run game loop
    private static void runGame(String gamemode, Scanner scanner) {

        // Initialise control variable for replay loop
        boolean replay = true;

        while (replay) {
            Utils.clearScreen();
            // Run selected gamemode
            switch (gamemode) {
                case "User":
                    // Generate a random 5-letter target word from the answers list
                    String targetWordHuman = WordList.getRandomWord(WordList.answerList);
                    // Start the user play mode
                    UserPlay.start(targetWordHuman, scanner, true);
                    break;
                case "AI":
                    // Generate a random 5-letter target word from the answers list
                    String targetWordAI = WordList.getRandomWord(WordList.answerList);
                    // Start the AI solver mode
                    WordleSolver.start(targetWordAI, true);
                    break;
                case "UserVsAI":
                    String targetWordMisc = WordList.getRandomWord(WordList.answerList);
                    // Start the user vs AI mode
                    UserVsAI.start(targetWordMisc, scanner);
                    break;
            }

            // Display post-game options
            Utils.printOptions();

            // Receive response from user
            String next = scanner.nextLine().trim();

            switch (next) {
                case "1":
                    // Replay same mode
                    continue; 
                case "2":
                    // Return to main menu
                    replay = false;
                    break;
                case "3":
                    // Quit program
                    System.out.println("\nFarewell!");
                    System.exit(0);
                    break;
                default:
                    // Invalid input handling
                    System.out.println("\nInvalid input. Returning to main menu.");
                    System.out.println("Press Enter to continue...");
                    scanner.nextLine();
                    replay = false;
                    break;
            }
        }
    }
}