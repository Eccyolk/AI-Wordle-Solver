// ============================================================================
// UserVsAI.java
// AI Wordle Solver Project
// Author: Eccyolk
// Date: 10/11/2025
//
// Description:
// This class runs the "User vs AI" gamemode.
// The user and AI both attempt to solve the same target word,
// and their performance (number of attempts) is compared to determine a winner.
// ============================================================================

package main.java.solver;

// Import all Java utilities
import java.util.*;

public class UserVsAI {
    
    // Method to start the User vs AI competition
    public static void start(String targetWordMisc, Scanner scanner) {
        
        // Display welcome message
        Utils.printBanner();
        System.out.println("=======================================");
        System.out.println("              USER VS AI");
        System.out.println("=======================================\n");
        System.out.println("Both you and the AI will try to solve the SAME Wordle!\n");

        // Notify user of their turn
        System.out.println("---------- Your turn first! ----------\n");

        // User plays using the existing UserPlay class
        int userAttempts = UserPlay.start(targetWordMisc, scanner, false);

        // Notify user of AI's turn
        System.out.println("\n\n------- Now it's the AI's turn! -------");
        System.out.println("\nThe AI will now attempt to solve the SAME word...");

        // AI plays using the existing WordleSolver class
        int aiAttempts = WordleSolver.start(targetWordMisc, false);
        
        // Display comparison
        Utils.delay(800);
        System.out.println("\n\n=======================================");
        System.out.println("                RESULTS");
        System.out.println("=======================================\n");
        System.out.println("Your result: " + (userAttempts == -1 ? "Failed" : userAttempts + " attempts"));
        System.out.println("AI's result: " + (aiAttempts == -1 ? "Failed" : aiAttempts + " attempts"));

        // Compare results
        Utils.delay(500);
        if (userAttempts == -1 && aiAttempts == -1) {
            System.out.println("No one guessed it!");
        } else if (aiAttempts == -1 || (userAttempts != -1 && userAttempts < aiAttempts)) {
            System.out.println("You win!");
        } else if (userAttempts == -1 || aiAttempts < userAttempts) {
            System.out.println("AI wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}