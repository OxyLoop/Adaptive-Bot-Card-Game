import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deck {
    public final ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        creatingDeck();
    }

    private void creatingDeck() {
        try {
            Scanner scanner = new Scanner(Paths.get("cardvalues.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String suit = line.substring(0, 1);
                String cardface = line.substring(1, 2);
                int points = Integer.parseInt(line.substring(3).trim());
                cards.add(new Card(suit, cardface, points));
            }
            scanner.close();
        } 
        catch (IOException e) {
            System.out.println("Error reading card values from file");
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}