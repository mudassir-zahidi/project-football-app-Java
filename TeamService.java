/*
 * TeamService.java
 * 
 * Provides methods for selecting favorite teams, and displaying football-related data
 * like news, matches, and standings.
 * 
 * © 2025 FootballApp Project. All rights reserved.
 */

package assingnment2;

import java.util.Scanner;

/**
 * Service class that manages team selection, news, matches, and standings.
 */
public class TeamService {
    private final AuthService authService;

    // Predefined list of popular football teams
    private final String[] teams = {
        "Real Madrid", "Barcelona", "Manchester City", "Inter Milan", "Bayern Munich"
    };

    public TeamService(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Allows user to select their favorite football team from a list.
     */
    public void selectFavoriteTeam(Scanner sc, User user) {
        System.out.println("Choose your favorite team:");
        for (int i = 0; i < teams.length; i++) {
            System.out.println((i + 1) + ". " + teams[i]);
        }

        System.out.print("Enter choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        // Validate choice and assign team
        if (ch >= 1 && ch <= teams.length) {
            user.setFavoriteTeam(teams[ch - 1]);
        } else {
            user.setFavoriteTeam("Real Madrid"); // Default team
        }

        System.out.println("You selected: " + user.getFavoriteTeam());
        authService.updateFavoriteTeam(user); // Save choice
    }

    /**
     * Displays mock news for the selected favorite team.
     */
    public void displayNews(String team) {
        System.out.println("\nLatest News for " + team + ":");
        switch (team) {
            case "Real Madrid" -> {
                System.out.println("- Bellingham wins La Liga Player of the Month.");
                System.out.println("- Ancelotti: “We’re ready for Champions League.”");
                System.out.println("- Toni Kroos announces retirement after EURO 2024.");
                System.out.println("- Real Madrid signs Brazilian wonderkid for €60M.");
            }
            case "Barcelona" -> {
                System.out.println("- Xavi extends contract until 2026.");
                System.out.println("- Youngsters shine in 3-0 win over Getafe.");
                System.out.println("- Laporta says club is financially stable.");
                System.out.println("- Lewandowski eyes Golden Boot.");
            }
            case "Manchester City" -> {
                System.out.println("- Pep: “Haaland can be even better.”");
                System.out.println("- De Bruyne back in training.");
                System.out.println("- Jack Grealish out for two weeks.");
                System.out.println("- Guardiola praises academy talent.");
            }
            case "Inter Milan" -> {
                System.out.println("- Inter close to Serie A title.");
                System.out.println("- Lautaro scores in 5th straight game.");
                System.out.println("- Coach Inzaghi signs new 3-year contract.");
                System.out.println("- Inter linked with Bundesliga midfielder.");
            }
            case "Bayern Munich" -> {
                System.out.println("- Tuchel confirms departure at end of season.");
                System.out.println("- Kane sets new scoring record.");
                System.out.println("- Neuer makes return from injury.");
                System.out.println("- Bayern planning €100M summer rebuild.");
            }
        }
    }

    /**
     * Shows recent and upcoming matches for a specific team.
     */
    public void displayMatches(String team) {
        System.out.println("\nRecent & Upcoming Matches for " + team + ":");
        switch (team) {
            case "Real Madrid" -> {
                System.out.println("Real Madrid vs Barcelona: 2-1 (Bellingham, Vinicius) - MOTM: Bellingham");
                System.out.println("Real Madrid vs Sevilla: 3-0 (Rodrygo, Modric, Joselu) - MOTM: Modric");
                System.out.println("Real Madrid vs Atletico Madrid (Upcoming) - 2 June");
                System.out.println("Real Madrid vs Manchester City (Upcoming) - 7 June");
            }
            case "Barcelona" -> {
                System.out.println("Barcelona vs Atletico: 1-1 (Lewandowski) - MOTM: Ter Stegen");
                System.out.println("Barcelona vs Valencia: 2-0 (Fati, Raphinha) - MOTM: Fati");
                System.out.println("Barcelona vs Girona (Upcoming) - 3 June");
                System.out.println("Barcelona vs Villarreal (Upcoming) - 9 June");
            }
            case "Manchester City" -> {
                System.out.println("Manchester City vs Liverpool: 3-2 (Silva, Foden, Haaland) - MOTM: Silva");
                System.out.println("Manchester City vs Arsenal: 4-1 (Haaland x2, De Bruyne x2) - MOTM: Haaland");
                System.out.println("Manchester City vs Tottenham (Upcoming) - 1 June");
                System.out.println("Manchester City vs Real Madrid (Upcoming) - 7 June");
            }
            case "Inter Milan" -> {
                System.out.println("Inter Milan vs AC Milan: 3-1 (Lautaro x2, Dzeko) - MOTM: Lautaro");
                System.out.println("Inter Milan vs Napoli: 1-0 (Barella) - MOTM: Barella");
                System.out.println("Inter Milan vs Roma (Upcoming) - 4 June");
                System.out.println("Inter Milan vs Juventus (Upcoming) - 8 June");
            }
            case "Bayern Munich" -> {
                System.out.println("Bayerm Munich vs Dortmund: 5-2 (Kane x3, Muller x2) - MOTM: Kane");
                System.out.println("Bayerm Munich vs Leipzig: 2-2 (Gnabry, Musiala) - MOTM: Musiala");
                System.out.println("Bayerm Munich vs Freiburg (Upcoming) - 2 June");
                System.out.println("Bayerm Munich vs Bayer Leverkusen (Upcoming) - 10 June");
            }
        }
    }

    /**
     * Displays league standings of all five teams.
     */
    public void displayStandings() {
        System.out.println("\nCurrent League Standings:");
        System.out.println("1. Manchester City - 75 pts");
        System.out.println("2. Real Madrid - 72 pts");
        System.out.println("3. Inter Milan - 69 pts");
        System.out.println("4. Bayern Munich - 66 pts");
        System.out.println("5. Barcelona - 65 pts");
    }
}
