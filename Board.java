import java.util.ArrayList;

public class Board {
    public static ArrayList<Card> boardCards;

    public Board(){
        boardCards = new ArrayList<>();
    }
    
    public static void addBoardCards(Card cards) {
        boardCards.add(cards);

    }

    public static Card getTopCardDeck() {
        int topvalue = boardCards.size(); //boyutu kontrol et
        return boardCards.get(topvalue);

    }


    
}
