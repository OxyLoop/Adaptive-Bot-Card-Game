import java.util.ArrayList;
import java.util.Random;

public class NoviceBot extends Bot {
    private static ArrayList<Card> botHand; // Bot's hand of cards
    private ArrayList<Card> botTakenCards;
    private int score; // Bot's current score

    public  NoviceBot() {
        botHand = new ArrayList<Card>();
        score = 0;
    }

    // Method to add a card to the bot's hand
    public void addCard(Card card) {
        botHand.add(card);
    }

    // Method to remove a card from the bot's hand
    public Card playCard() {
        Random rand = new Random();
        int index = rand.nextInt(botHand.size());
        Card card = botHand.get(index);
        botHand.remove(index);
        return card;
    }

    public ArrayList<Card> getHand() {
        return botHand;
    }

    // Method to get the bot's current score
    public int getScore() {
        return score;
    }

    public ArrayList<Card> getBotTakenCards(){
        return botTakenCards;
    }

    // Method to reset the bot's hand and score
    public void reset() {
        botHand.clear();
        score = 0;
    }
}
