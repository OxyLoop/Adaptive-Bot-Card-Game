import java.util.ArrayList;
import java.util.Random;

public class RegularBot extends Bot {
    private ArrayList<Card> botTakenCards;
    private int score;
    
    public  RegularBot(String name) {
        super(name);
        this.botTakenCards = new ArrayList<Card>();
    }

    public Card botPlayCard(Board board) {
        Card playCard = null;
        //check pişti
        if(Board.getTopCardDeck() != null){
            for(int i=0; i<getHand().size(); i++){
                if(getHand().get(i).getCardFace().equals(Board.getTopCardDeck().getCardFace())){
                    playCard = getHand().get(i);
                    Board.addCardToBoard(playCard);
                    botTakenCards.addAll(Board.getBoardCards());          //kartları topladı
                    for(int j=0; j<Board.getBoardCards().size(); j++) {
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
            if(getHand().get(choosenCard).getCardFace().equals(Board.getTopCardDeck().getCardFace())) {
                botTakenCards.addAll(Board.getBoardCards());
                for(int i=0; i<Board.getBoardCards().size(); i++) {
                    // MASA BOŞALDIĞI İÇİN ORTADAKİ BÜTÜN KARTLARI SİLMEK LAZIM
                }
            }
            getHand().remove(choosenCard);
        }
        return playCard;
    }

    public ArrayList<Card> getBotTakenCards(){
        return botTakenCards;
    }


}
