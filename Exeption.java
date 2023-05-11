import java.util.*;

public class Exeptions {
    public static void main(String[] args) {
        // Check if the required number of command line arguments is provided
        if (args.length < 4) {
            System.out.println("Invalid number of arguments.");
            System.out.println("Usage: java PistiGame <num_players> <point_file> <player1_name> <player1_level> ...");
            return;
        }

        // Parse the number of players
        int numPlayers;
        try {
            numPlayers = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of players. Please provide a valid integer.");
            return;
        }

        // Check if the number of players is within a valid range
        if (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Invalid number of players. The number of players should be between 2 and 4.");
            return;
        }

        // Parse the point file name
        String pointFile = args[1];

        // Create a map to store player names and expertise levels
        Map<String, String> players = new HashMap<>();

        // Iterate over the remaining command line arguments and parse player names and levels
        for (int i = 2; i < args.length; i += 2) {
            String playerName = args[i];
            String botLevel = args[i + 1];

            // Check if the player level is valid
            if (!isValidPlayerLevel(botLevel)) {
                System.out.println("Invalid player level for player: " + playerName);
                System.out.println("Valid levels are: beginner, intermediate, advanced.");
                return;
            }

            // Add the player to the map
            players.put(playerName, botLevel);
        }

        // Print the parsed game parameters
        System.out.println("Number of Players: " + numPlayers);
        System.out.println("Point File: " + pointFile);
        System.out.println("Players and Expertise Levels:");
        for (Map.Entry<String, String> entry : players.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


    }

    // Method to check if the bot level is valid
    private static boolean isValidPlayerLevel(String level) {
        return level.equals("Regular") || level.equals("Novice") || level.equals("Expert");
    }
}
