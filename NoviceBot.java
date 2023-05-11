import java.util.ArrayList;
import java.util.Random;

public class NoviceBot extends Bot {
    private ArrayList<Card> botTakenCards = new ArrayList<>();
    private int score; // Bot's current score

    public NoviceBot(String name) {
        super(name);
    }

    //novice bot play random
    public Card botPlayCard(Board board) {
        Random rand = new Random();
        int chosenCard = rand.nextInt(getHand().size());
        Card playCard = getHand().get(chosenCard);
        addCardToBoard(playCard);
        if(playCard.getCardFace().equals(Board.getTopCardDeck().getCardFace())) {
            botTakenCards.addAll(Board.getBoardCards());                //kartları kazandıklarına topladı
            for(int i=0; i<Board.getBoardCards().size(); i++) {
                // MASA BOŞALDIĞI İÇİN ORTADAKİ BÜTÜN KARTLARI SİLMEK LAZIM
            }
        }
        getHand().remove(chosenCard);
        return playCard;
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
