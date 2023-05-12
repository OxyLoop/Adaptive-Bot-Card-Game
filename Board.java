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
    public static void removeCardsFromBoard() {
        boardCards.clear();
    }

    public Card getTopCardDeck() {
        int topvalue = boardCards.size()-1; //boyutu kontrol et
        return boardCards.get(topvalue);

    }

    public ArrayList<Card> getBoardCards(){
        return boardCards; 
    }

    public ArrayList<Card> getPlayedCards(){
        return playedCards; 
    }

    
    public void PlayedCard(Card playedCard, Players players, Board board) {

        //pişti yaparsa
        if(board.getBoardCards().isEmpty()==true){
            System.out.println( players.getName() +" played card and won nothing");  
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);
        }
        else if(board.getBoardCards().size() == 1 && board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace())) {
            System.out.println(players.getName() +" make PİŞTİ");
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            players.getTakenCards().addAll(boardCards);
            //skore ekle

            removeCardsFromBoard();             
        }
        //joker oynarsa
        else if(playedCard.getCardFace().equals("J")) {
            System.out.println(players.getName() +" used JOKER card and take cards on the board");
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            players.getTakenCards().addAll(boardCards);
            removeCardsFromBoard();             
        }
        //masa dolu ve atıp aldıysa
        else if (board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace())) {
            System.out.println(players.getName() +" took all cards on the board using same card");
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            players.getTakenCards().addAll(boardCards);
            removeCardsFromBoard();         
        }
        //masa boş ve eşit iflerine girmediyse
        else {    
            System.out.println(players.getName() +" played " + playedCard.cardNameString()); 
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);
        }
        
    }  
}
