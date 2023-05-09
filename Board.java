import java.util.ArrayList;

public class Board {
    private static ArrayList<Card> boardCards;
    private static ArrayList<Card> playedCards;

    public Board(){
        boardCards = new ArrayList<>();
    }
    
    public static void addBoardCards(Card cards) {
        boardCards.add(cards);

    }

    public static void addPlayedCards(Card card){
        playedCards.add(card);
    }

    public static Card getTopCardDeck() {
        int topvalue = boardCards.size(); //boyutu kontrol et
        return boardCards.get(topvalue);

    }

    public static ArrayList<Card> getPlayedCards(){
        return playedCards; 
    }




    
}
