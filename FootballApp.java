package assingnment2;

import java.util.Scanner;

public class FootballApp {
    static String[] registeredEmails = new String[10];
    static String[] registeredNames = new String[10];
    static int userCount = 0;

    static String currentUserName = "";
    static String currentUserEmail = "";
    static String favoriteTeam = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Login or Sign Up
        System.out.println("Welcome to FootballApp");
        System.out.println("1. Sign Up");
        System.out.println("2. Login");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            signUp(scanner);
        } else if (choice == 2) {
            login(scanner);
        } else {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        // 2. Choose Favorite Team
        chooseFavoriteTeam(scanner);

        // 3. View team data
        viewTeamOptions(scanner);

        scanner.close();
    }

    static void signUp(Scanner scanner) {
        System.out.print("Enter your name: ");
        currentUserName = scanner.nextLine();
        System.out.print("Enter your email: ");
        currentUserEmail = scanner.nextLine();

        registeredNames[userCount] = currentUserName;
        registeredEmails[userCount] = currentUserEmail;
        userCount++;

        System.out.println("Sign up successful. Welcome, " + currentUserName + "!");
    }

    static void login(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < userCount; i++) {
            if (registeredEmails[i].equalsIgnoreCase(email)) {
                currentUserEmail = email;
                currentUserName = registeredNames[i];
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Login successful. Welcome back, " + currentUserName + "!");
        } else {
            System.out.println("User not found. Please sign up first.");
            System.exit(0);
        }
    }

    static void chooseFavoriteTeam(Scanner scanner) {
        System.out.println("Choose your favorite team:");
        System.out.println("1. Real Madrid");
        System.out.println("2. Barcelona");
        System.out.println("3. Manchester City");
        System.out.println("4. Inter Milan");
        System.out.println("5. Bayern Munich");
        System.out.print("Enter choice: ");
        int teamChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (teamChoice) {
            case 1 -> favoriteTeam = "Real Madrid";
            case 2 -> favoriteTeam = "Barcelona";
            case 3 -> favoriteTeam = "Manchester City";
            case 4 -> favoriteTeam = "Inter Milan";
            case 5 -> favoriteTeam = "Bayern Munich";
            default -> {
                System.out.println("Invalid choice. Defaulting to Real Madrid.");
                favoriteTeam = "Real Madrid";
            }
        }

        System.out.println("You selected: " + favoriteTeam);
    }

    static void viewTeamOptions(Scanner scanner) {
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View Latest News");
            System.out.println("2. View Upcoming Matches");
            System.out.println("3. View League Standings");
            System.out.println("4. View My Profile");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> displayNews();
                case 2 -> displayMatches();
                case 3 -> displayStandings();
                case 4 -> showProfile();
                case 5 -> {
                    System.out.println("Thanks for using FootballApp. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void displayNews() {
        System.out.println("Latest News for " + favoriteTeam + ":");
        System.out.println("- Star player shines in training.");
        System.out.println("- Manager talks about strategy for next match.");
    }

    static void displayMatches() {
        System.out.println("Upcoming Matches for " + favoriteTeam + ":");
        System.out.println("- Match vs Rivals FC on Saturday");
        System.out.println("- Champions League fixture next week");
    }

    static void displayStandings() {
        System.out.println("Current Standings for " + favoriteTeam + ":");
        System.out.println("- Position: 2nd");
        System.out.println("- Points: 45");
        System.out.println("- Wins: 14, Draws: 3, Losses: 2");
    }

    static void showProfile() {
        System.out.println("User Profile:");
        System.out.println("- Name: " + currentUserName);
        System.out.println("- Email: " + currentUserEmail);
        System.out.println("- Favorite Team: " + favoriteTeam);
    }
}
