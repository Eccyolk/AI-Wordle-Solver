// ============================================================================
// Utils.java
// AI Wordle Solver Project
// Author: Eccyolk
// Date: 11/11/2025
//
// Description:
// This class provides general-purpose utility methods for the project.
// It includes methods for delays, printing, and other small operations.
// This keeps code organised and avoids duplication across classes.
// ============================================================================

package main.java.solver;

public class Utils {

    // Method to print the ASCII title banner
    public static void printBanner() {
        System.out.println("     _    ___  __        __            _ _        ____        _                \r\n" + //
                                "    / \\  |_ _| \\ \\      / /__  _ __ __| | | ___  / ___|  ___ | |_   _____ _ __ \r\n" + //
                                "   / _ \\  | |   \\ \\ /\\ / / _ \\| '__/ _` | |/ _ \\ \\___ \\ / _ \\| \\ \\ / / _ \\ '__|\r\n" + //
                                "  / ___ \\ | |    \\ V  V / (_) | | | (_| | |  __/  ___) | (_) | |\\ V /  __/ |   \r\n" + //
                                " /_/   \\_\\___|    \\_/\\_/ \\___/|_|  \\__,_|_|\\___| |____/ \\___/|_| \\_/ \\___|_|   \r\n" + //
                                "                                                                               \n");

    }

    // Method to display the menu options
    public static void printMenu() {
        // Display Menu
        System.out.println("=======================================");
        System.out.println("      WELCOME TO AI WORDLE SOLVER");
        System.out.println("=======================================\n");
        System.out.println("1. Play a classic game of Wordle");
        System.out.println("2. Let AI guess");
        System.out.println("3. Play against AI");
        System.out.println("4. Quit\n");
        System.out.println("Enter your choice: ");
    }

    // Method to display post-game options
    public static void printOptions() {
        Utils.delay(1000);
        System.out.println("\n\nWhat would you like to do next?");
        System.out.println("1. Play again (same mode)");
        System.out.println("2. Return to main menu");
        System.out.println("3. Quit");
    }

    // Method to clear the terminal (aesthetic)
    public static void clearScreen() {
        try {
            // Check if the operating system is Windows
            if (System.getProperty("os.name").contains("Windows")) {

                // Use Windows' built-in 'cls' command to clear the terminal
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Linux, macOS, and other ANSI-compatible terminals:
                System.out.print("\033[H\033[2J");

                // Ensure the escape codes are sent immediately
                System.out.flush();
            }
        } catch (Exception e) {
            // Display error message if process fails
            System.out.println("Unable to clear screen");
        }
    }

    // Method to add a delay for dramatic effect
    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
