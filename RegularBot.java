
import java.util.Random;

public class RegularBot extends Bot {
    
    public  RegularBot(String name) {
        super(name);
    }

    public Card PlayCard(Board board) {
        Card playedCard = null;
        
        //check pişti
        if(board.getTopCardDeck() != null){
            for(int i=0; i<getHand().size(); i++){
                if(getHand().get(i).getCardFace().equals(board.getTopCardDeck().getCardFace())){
                    playedCard = getHand().get(i);
                    getHand().remove(i);
                    break;
                }
            }
        }
        
        //random play
        if(playedCard==null){
            Random rand = new Random();
            int choosenCard = rand.nextInt(getHand().size());
            playedCard = getHand().get(choosenCard);
            getHand().remove(choosenCard);
        }
        return playedCard;
    }


}
