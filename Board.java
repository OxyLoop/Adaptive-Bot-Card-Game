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

    
    public static void botPlayedCard(Card playedCard, Bot playedBot) {

        //pişti yaparsa
        if(Board.getBoardCards().size() == 1 || Board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace())) {
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            playedBot.getBotTakenCards().addAll(boardCards);
            //skore ekle

            removeCardsFromBoard();             
        }
        //joker oynarsa
        if(playedCard.getCardFace() == "J") {
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            playedBot.getBotTakenCards().addAll(boardCards);
            removeCardsFromBoard();             
        }
        //masa dolu ve atıp aldıysa
        if (Board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace())) {
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            playedBot.getBotTakenCards().addAll(boardCards);
            removeCardsFromBoard();         
        }
        //masa boş ve eşit değilse
        if (Board.getBoardCards().size() == 0 && !(Board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace()))) {      // ! işareti not equal için
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);
        }
        
    }
    
    public void playerPlayedCard(Card playedCard, Player player) {

        //pişti yaparsa
        if(Board.getBoardCards().size() == 1 || Board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace())) {
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            Player.getWonCards().addAll(boardCards);
            //skore ekle

            removeCardsFromBoard();             
        }
        //joker oynarsa
        if(playedCard.getCardFace() == "J") {
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            Player.getWonCards().addAll(boardCards);
            removeCardsFromBoard();             
        }
        //masa dolu ve atıp aldıysa
        if (Board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace())) {
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            Player.getWonCards().addAll(boardCards);
            removeCardsFromBoard();         
        }
        //masa boş ve eşit değilse
        if (Board.getBoardCards().size() == 0 || !(Board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace()))) {      // ! işareti not equal için
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);
        }
        
    }

}
