import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
    public final ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        creatingDeck();
    }
    //creating deck with using txt file
    private void creatingDeck() {
        boolean a = true;
        while(a){
            Scanner sc = new Scanner(System.in);
            System.out.println("Can you enter your file name which contains points of the cards: ");
            String nameOfFile = sc.nextLine();
        try {
            Scanner scanner = new Scanner(Paths.get(nameOfFile+".txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String suit = line.substring(0, 1);
                String cardFace = line.substring(1, 3).trim();
                String pointsString = line.substring(3).trim();
                //default value
                int points = 1; 
            
            try {
                points = Integer.parseInt(pointsString);
            } catch (NumberFormatException e) {
                System.out.println("Error reading card points from file. Card points will be default");
            }

                cards.add(new Card(suit, cardFace, points));
            }
            scanner.close();
            a=false;
            
        } 
        catch (IOException e) {
            System.out.println("Error reading card values from file");
        }
    }
}   

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
    //cut function for deck
    public ArrayList<Card> cut(int startIndex) {
        if (startIndex < 0 || startIndex >= cards.size()) {
            throw new IllegalArgumentException("Invalid start index: " + startIndex);
        }
        ArrayList<Card> cutCards = new ArrayList<>();
        for(int i = startIndex ; i < cards.size() ; i++ ) {
            cutCards.add(cards.get(i));
        }
        cards.subList(startIndex, cards.size()).clear();
        cards.addAll(0,cutCards);

        return cutCards;
   }
   //dealing cards
   public static void dealCards(int playerNumber, Deck mainDeck, ArrayList<Players> players, boolean a){
    for(int i=0; i<4; i++){
        for(int j=0; j<playerNumber; j++){
            players.get(j).addCard(mainDeck.getCards().get(0));
            mainDeck.getCards().remove(0);
        }
    }
   }

}