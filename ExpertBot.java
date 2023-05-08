import java.util.ArrayList;
import java.util.Random;

public class ExpertBot extends Bot {
    private static ArrayList<Card> botHand; // Bot's hand of cards
    private ArrayList<Card> botTakenCards;
    private int score;
    
    public  ExpertBot() {
        botHand = new ArrayList<Card>();
        score = 0;
    }

    @Override
    public void addCard(Card card) {
        botHand.add(card);
    }

    @Override
    public Card playCard() {
        Card playCard = null;

        //check pişti
        for(int i=0; i<botHand.size(); i++){
            if(botHand.get(i).getCardFace().equals(Board.getTopCardDeck().getCardFace())){
                playCard = botHand.get(i);
                botHand.remove(i);
                score = score + 10;
                break;
            }
        }
        //random play
        if(playCard !=null){
            Random rand = new Random();
            int index = rand.nextInt(botHand.size());
            playCard = botHand.get(index);
            botHand.remove(index);
        }
        return playCard;
        
    }

    @Override
    public ArrayList<Card> getHand() {
        return botHand;
    }

    public ArrayList<Card> getBotTakenCards(){
        return botTakenCards;
    }
    
}
