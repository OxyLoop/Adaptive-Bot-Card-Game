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
    //returns top card on the deck
    public Card getTopCardDeck() {
        int topvalue = boardCards.size()-1; //boyutu kontrol et
        if(boardCards.size() == 0){
            return null;
        }
        return boardCards.get(topvalue);

    }

    public ArrayList<Card> getBoardCards(){
        return boardCards; 
    }

    public ArrayList<Card> getPlayedCards(){
        return playedCards; 
    }

    //this function checks game rules for played cards
    public void PlayedCard(Card playedCard, Players players, Board board) {

        //pişti yaparsa
        if(board.getBoardCards().isEmpty()==true){
            System.out.println(players.getName() +" played " + playedCard.cardNameString());  
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);
        }
        else if(board.getBoardCards().size() == 1 && board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace())) {
            System.out.println(players.getName() +" make MİŞTİ");
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            players.getTakenCards().addAll(boardCards);
            int boardscore = 0;
            for(int i=0; i<boardCards.size();i++){
                boardscore = (boardCards.get(i).getPoints() + boardscore)* 5 ;
            }
            players.setScore(players.getScore()+boardscore);
            removeCardsFromBoard();             
        }
        //joker oynarsa
        else if(playedCard.getCardFace().equals("J")) {
            System.out.println(players.getName() +" used JOKER card and take cards on the board");
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            players.getTakenCards().addAll(boardCards);
            int boardscore = 0;
            for(int i=0; i<boardCards.size();i++){
                boardscore = boardCards.get(i).getPoints() + boardscore;
            }
            players.setScore(players.getScore()+boardscore);
            removeCardsFromBoard();             
        }
        //masa dolu ve atıp aldıysa
        else if (board.getTopCardDeck().getCardFace().equals(playedCard.getCardFace())) {
            System.out.println(players.getName() +" took all cards on the board using same card");
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);                
            players.getTakenCards().addAll(boardCards);
            int boardscore = 0;
            for(int i=0; i<boardCards.size();i++){
                boardscore = boardCards.get(i).getPoints() + boardscore;
            }
            players.setScore(players.getScore()+boardscore);
            removeCardsFromBoard();         
        }
        //masa boş ve eşit iflerine girmediyse
        else {    
            System.out.println(players.getName() +" played " + playedCard.cardNameString()); 
            addCardToBoard(playedCard);
            addPlayedCards(playedCard);
        }
    } 
    //this function returns the winner player
    public static Players getWinner(ArrayList<Players> players) {
        int highestScore = 0;
        int highestScorePlayerIndex = 0;
    
        // Find the highest score among all players
        for (int i=0;i<players.size();i++) {
            if (players.get(i).getScore() > highestScore) {
                highestScore = players.get(i).getScore();
                highestScorePlayerIndex = i; 
            }
        }
        return players.get(highestScorePlayerIndex);

    }
    
    
    
    
    
    
    
}
