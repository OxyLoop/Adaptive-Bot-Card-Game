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

    private void creatingDeck() {
        
            Scanner sc = new Scanner(System.in);
            System.out.println("Can you enter your file name which contains points of the cards: ");
            String nameOfFile = sc.nextLine();
        try {
            Scanner scanner = new Scanner(Paths.get(nameOfFile+".txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String suit = line.substring(0, 1);
                String cardFace = line.substring(1, 3).trim();
                int point = Integer.parseInt(line.substring(3).trim());

                cards.add(new Card(suit, cardFace, point));
            }
            scanner.close();
            sc.close();
        } 
        catch (IOException e) {
            System.out.println("Error reading card values from file");
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

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

   public static void dealCards(int botnumber, Deck mainDeck, ArrayList<Bot> bots, int deckCardCounter,boolean a){
    for(int i=0; i<4; i++){
        if(a=true){
            //player.addCard(mainDeck.getCards().get(deckCardCounter));
            //deckCardCounter++;
        }
        for(int j=1; j<botnumber; j++){
            bots.get(i).addCard(mainDeck.getCards().get(deckCardCounter));
            deckCardCounter++;
        }
    }
   }

}