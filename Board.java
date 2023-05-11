import java.util.ArrayList;

public class Board {
    private static ArrayList<Card> boardCards;
    private static ArrayList<Card> playedCards;

    public Board(){
        boardCards = new ArrayList<>();
        playedCards = new ArrayList<>();
    }

    public static void addPlayedCards(Card card){
        playedCards.add(card);
    }
    public static void addCardToBoard(Card card) {
        boardCards.add(card);
    }
    public static void addCardToWon(Card card) {
        for(int i=0 ; i<Board.getBoardCards().size(); i++) {
            Player.playerWonCards.add(card);
        }
    }
    public static void removeCardsFromBoard() {
        for(int i=0 ; i<Board.getBoardCards().size(); i++) {
            getBoardCards().remove(i);
        }
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

    
    public static Card playerCheckPisti(int cardChoose) {
        Card card = null;
        if(Board.getBoardCards().size() == 1 || Board.getTopCardDeck().getCardFace().equals(Player.getPlayerHand().get(cardChoose).getCardFace())) {
            card = Player.getPlayerHand().get(cardChoose);
            addCardToBoard(card);
            addCardToWon(card);                 //kartları topla
            Player.getPlayerHand().remove(cardChoose);
            removeCardsFromBoard();             //masadaki kartlar silindi
        }
        return card;
    }

    public static Card playedJoker(int cardChoose) {
        Card card = null;
        if(Player.getPlayerHand().get(cardChoose).getCardFace() == "J") {
            card = Player.getPlayerHand().get(cardChoose);
            addCardToBoard(card);
            addCardToWon(card);                 //kartları topla
            Player.getPlayerHand().remove(cardChoose);
            removeCardsFromBoard();             //masadaki kartlar silindi
        }
        return card;
    }
    public static Card playedDifferent(int cardChoose) {
        Card card = null;
        if (Board.getBoardCards().size() == 0 || !(Board.getTopCardDeck().getCardFace().equals(Player.getPlayerHand().get(cardChoose).getCardFace()))) {      // ! işareti not equal için
            card = Player.getPlayerHand().get(cardChoose);
            addCardToBoard(card);
            Player.getPlayerHand().remove(cardChoose);
        }
        return card;
    }
    public static Card playedSame(int cardChoose) {
        Card card = null;
        if (Board.getTopCardDeck().getCardFace().equals(Player.getPlayerHand().get(cardChoose).getCardFace())) {
            card = Player.getPlayerHand().get(cardChoose);
            addCardToBoard(card);
            addCardToWon(card);             //kartları topla
            Player.getPlayerHand().remove(cardChoose);
            removeCardsFromBoard();         //masadaki kartlar silindi
        }
        return card;
    }

}
