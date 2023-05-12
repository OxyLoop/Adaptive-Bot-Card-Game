
import java.util.Random;

public class RegularBot extends Bot {
    
    public  RegularBot(String name) {
        super(name);
    }

    public Card PlayCard(Board board) {
        Card playCard = null;
        //check pişti
        if(board.getTopCardDeck() != null){
            for(int i=0; i<getHand().size(); i++){
                if(getHand().get(i).getCardFace().equals(board.getTopCardDeck().getCardFace())){
                    playCard = getHand().get(i);
                    Board.addCardToBoard(playCard);
                    getTakenCards().addAll(board.getBoardCards());          //kartları topladı
                    for(int j=0; j<board.getBoardCards().size(); j++) {
                        // MASA BOŞALDIĞI İÇİN ORTADAKİ BÜTÜN KARTLARI SİLMEK LAZIM
                    }
                    getHand().remove(i);
                    break;
                }
            }
        }
        //random play
        if(playCard !=null){
            Random rand = new Random();
            int choosenCard = rand.nextInt(getHand().size());
            playCard = getHand().get(choosenCard);
            Board.addCardToBoard(playCard);
            if(getHand().get(choosenCard).getCardFace().equals(board.getTopCardDeck().getCardFace())) {
                getTakenCards().addAll(board.getBoardCards());
                for(int i=0; i<board.getBoardCards().size(); i++) {
                    // MASA BOŞALDIĞI İÇİN ORTADAKİ BÜTÜN KARTLARI SİLMEK LAZIM
                }
            }
            getHand().remove(choosenCard);
        }
        return playCard;
    }



}
