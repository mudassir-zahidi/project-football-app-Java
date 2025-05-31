/*
 * Main.java
 * 
 * This is the entry point of the FootballApp. It allows users to sign up or log in,
 * choose a favorite football team, and view news, matches, standings, or profile info.
 * 
 * © 2025 FootballApp Project. All rights reserved.
 */

package assingnment2;

import java.util.Scanner;

/**
 * Main class to run the FootballApp console application.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        TeamService teamService = new TeamService(authService);

        System.out.println("Welcome to FootballApp");
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.print("Choose option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline

        User currentUser;
        if (option == 1) {
            currentUser = authService.signUp(scanner); // New user registration
        } else {
            currentUser = authService.login(scanner); // Existing user login
            if (currentUser == null) return;
        }

        // User selects a favorite team (stored in users.txt)
        teamService.selectFavoriteTeam(scanner, currentUser);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View News");
            System.out.println("2. View Matches");
            System.out.println("3. View Standings");
            System.out.println("4. View My Profile");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (ch) {
                case 1 -> teamService.displayNews(currentUser.getFavoriteTeam());
                case 2 -> teamService.displayMatches(currentUser.getFavoriteTeam());
                case 3 -> teamService.displayStandings();
                case 4 -> authService.showProfile(currentUser);
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
