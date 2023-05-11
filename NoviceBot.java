import java.util.ArrayList;
import java.util.Random;

public class NoviceBot extends Bot {
    private ArrayList<Card> botTakenCards = new ArrayList<>();
    private int score; // Bot's current score

    public  NoviceBot(String name) {
        super(name);
    }

    

    // Method to remove a card from the bot's hand
    public Card playCard(Board board) {
        Random rand = new Random();
        int index = rand.nextInt(getHand().size());
        Card card = getHand().get(index);
        getHand().remove(index);
        return card;

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
        getHand().clear();
        score = 0;
    }
}
