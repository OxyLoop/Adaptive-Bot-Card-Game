
import java.util.Random;

public class NoviceBot extends Bot {

    public NoviceBot(String name) {
        super(name);
    }

    //novice bot play random
    public Card PlayCard(Board board) {
        Random rand = new Random();
        int chosenCard = rand.nextInt(getHand().size());
        Card playedCard = getHand().get(chosenCard);
        getHand().remove(chosenCard);
        return playedCard;
    }

    

    // Method to reset the bot's hand and score
    public void reset() {
        getHand().clear();
        //setScore() = 0;
    }
}
