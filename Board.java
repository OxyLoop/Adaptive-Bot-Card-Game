import java.util.ArrayList;

public class Board {
    private static ArrayList<Card> boardCards;
    private static ArrayList<Card> playedCards;

    public Board(){
        boardCards = new ArrayList<>();
        playedCards = new ArrayList<>();
    }
    
    public static void addBoardCards(Card cards) {
        boardCards.add(cards);

    }

    public static void addPlayedCards(Card card){
        playedCards.add(card);
    }

    public static Card getTopCardDeck() {
        int topvalue = boardCards.size()-1; //boyutu kontrol et
        return boardCards.get(topvalue);

    }

    public static ArrayList<Card> getBoardCards(){
        return boardCards; 
    }

    public static ArrayList<Card> getPlayedCards(){
        return playedCards; 
    }




    
}
