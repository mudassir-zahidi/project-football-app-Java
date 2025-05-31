/*
 * AuthService.java
 * 
 * Handles user sign-up, login, and profile/favorite team storage via users.txt.
 * 
 * © 2025 FootballApp Project. All rights reserved.
 */

package assingnment2;

import java.io.*;
import java.util.Scanner;

/**
 * Service class that manages user authentication and data persistence.
 */
public class AuthService {
    private final String FILE_NAME = "users.txt";

    /**
     * Registers a new user if the email isn't already taken.
     */
    public User signUp(Scanner sc) {
        String name = "";
        String email = "";

        // Name input validation
        while (name.isBlank()) {
            System.out.print("Enter name: ");
            name = sc.nextLine().trim();
        }

        // Email input validation
        while (email.isBlank()) {
            System.out.print("Enter email: ");
            email = sc.nextLine().trim();
        }

        if (isEmailRegistered(email)) {
            System.out.println("An account with this email already exists.");
            return login(sc); // Redirect to login if email is already used
        }

        User user = new User(name, email);

        // Save new user to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(name + "," + email + "," + user.getFavoriteTeam());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user.");
        }

        System.out.println("Sign up successful. Welcome, " + name + "!");
        return user;
    }

    /**
     * Checks if the given email is already registered.
     */
    public boolean isEmailRegistered(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[1].equalsIgnoreCase(email)) {
                    return true;
                }
            }
        } catch (IOException ignored) {}
        return false;
    }

    /**
     * Logs in the user if their email is found in the file.
     */
    public User login(Scanner sc) {
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[1].equalsIgnoreCase(email)) {
                    User user = new User(parts[0], parts[1]);
                    if (parts.length == 3) {
                        user.setFavoriteTeam(parts[2]);
                    }
                    System.out.println("Welcome back, " + user.getName() + "!");
                    return user;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user file.");
        }

        System.out.println("User not found. Please sign up.");
        return null;
    }

    /**
     * Updates the user's favorite team in the users.txt file.
     */
    public void updateFavoriteTeam(User user) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp_users.txt");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2 && parts[1].equalsIgnoreCase(user.getEmail())) {
                    writer.write(user.getName() + "," + user.getEmail() + "," + user.getFavoriteTeam());
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error updating favorite team.");
        }

        // Replace old file with updated one
        if (inputFile.delete() && tempFile.renameTo(inputFile)) {
            System.out.println("Favorite team updated.");
        }
    }

    /**
     * Displays user's profile details in the console.
     */
    public void showProfile(User user) {
        System.out.println("User Profile:");
        System.out.println("- Name: " + user.getName());
        System.out.println("- Email: " + user.getEmail());
        System.out.println("- Favorite Team: " + user.getFavoriteTeam());
    }
}
