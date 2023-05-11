import java.util.ArrayList;
import java.util.Random;

public class RegularBot extends Bot {
    private ArrayList<Card> botTakenCards;
    private int score;
    
    public  RegularBot(String name) {
        super(name);
        this.botTakenCards = new ArrayList<Card>();
    }

 
    public Card playCard(Board board) {
        Card playCard = null;

        //check pişti
        if(Board.getTopCardDeck() != null){
            for(int i=0; i<getHand().size(); i++){
                if(getHand().get(i).getCardFace().equals(Board.getTopCardDeck().getCardFace())){
                    playCard = getHand().get(i);
                    getHand().remove(i);
                    score = score + 10;
                    break;
                }
            }
        }
        //random play
        if(playCard !=null){
            Random rand = new Random();
            int index = rand.nextInt(getHand().size());
            playCard = getHand().get(index);
            getHand().remove(index);
        }
        return playCard;
        
    }

    public ArrayList<Card> getBotTakenCards(){
        return botTakenCards;
    }
    
}
