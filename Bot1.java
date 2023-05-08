import java.util.ArrayList;
import java.util.Random;

public class Bot1 {
    private ArrayList<Card> botHand; // Bot's hand of cards
    private int score; // Bot's current score

    public  Bot1() {
        botHand = new ArrayList<Card>();
        score = 0;
    }

    // Method to add a card to the bot's hand
    public void addCard(Card card) {
        botHand.add(card);
    }

    // Method to remove a card from the bot's hand
    public Card removeCard() {
        Random rand = new Random();
        int index = rand.nextInt(botHand.size());
        Card card = botHand.get(index);
        botHand.remove(index);
        return card;
    }

    // Method to check if the bot can make a "Pisti" with the last played card
    public boolean checkPisti(Card lastCard) {
        boolean pisti = false;
        for (Card card : botHand) {
            if (card.getPoints() == lastCard.getPoints()) {
                pisti = true;
                break;
            }
        }
        if (pisti) {
            score += 10;
        }
        return pisti;
    }

    // Method to get the bot's current score
    public int getScore() {
        return score;
    }

    // Method to reset the bot's hand and score
    public void reset() {
        botHand.clear();
        score = 0;
    }
}
