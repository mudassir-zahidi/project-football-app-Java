/*
 * User.java
 * 
 * A simple model class to represent a user.
 * Stores name, email, and favorite football team.
 * 
 * © 2025 FootballApp Project. All rights reserved.
 */

package assingnment2;

/**
 * A class that models a User with name, email, and favorite team.
 */
public class User {
    private String name;
    private String email;
    private String favoriteTeam;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.favoriteTeam = "";
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getFavoriteTeam() { return favoriteTeam; }

    public void setFavoriteTeam(String team) {
        this.favoriteTeam = team;
    }
}
