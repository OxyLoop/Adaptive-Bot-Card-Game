import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private int playerPistiCounter;

    ArrayList<Card> playerHand = new ArrayList<>();        // Player's hand card
    ArrayList<Card> playerWonCards = new ArrayList<>();       // Player's won cards

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    public int getPlayerPistiCounter() {
        return playerPistiCounter;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addScore(int p) {
        score += p;
    }

    public Player(String name) {
        this.name = name;
    }
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }
    public void addCardToBoard(Card card) {
        Board.getBoardCards().add(card);
    }
    public void addCardToWon(Card card) {
        for(int i=0 ; i<Board.getBoardCards().size(); i++) {
            playerWonCards.add(card);
        }
    }


    public void showCards() {  //shows player cards
        System.out.println("\n----My Hand---- ");

        for (int i = 0; i < playerHand.size(); i++) {

            System.out.println(i + " " + playerHand.get(i).toString());
        }
    }

    public void calculateScore() {  // calculate user score
    }

    public Card playerPlayCard(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your cards are: ");
        showCards();
        System.out.println("Enter a number of card that you want to play: ");
        int cardChoose = sc.nextInt();
        Card card;

        //pişti olursa
        if(Board.getBoardCards().size() == 1 || Board.getTopCardDeck().getCardFace().equals(getPlayerHand().get(cardChoose).getCardFace())) {
            card = getPlayerHand().get(cardChoose);
            addCardToBoard(card);
            addCardToWon(card);                 //kartları topla
            getPlayerHand().remove(cardChoose);
            playerPistiCounter++;
        }
        //joker oynarsa
        else if(getPlayerHand().get(cardChoose).getCardFace() == "J") {
            card = getPlayerHand().get(cardChoose);
            addCardToBoard(card);
            addCardToWon(card);                 //kartları topla
            getPlayerHand().remove(cardChoose);
        }

        //masa boşsa veya ortadakiyle aynı kart OYNAMAZSA
        else if (Board.getBoardCards().size() == 0 || !(Board.getTopCardDeck().getCardFace().equals(getPlayerHand().get(cardChoose).getCardFace()))) {      // ! işareti not equal için
            card = getPlayerHand().get(cardChoose);
            addCardToBoard(card);
            getPlayerHand().remove(cardChoose);
        }
        //ortadakiyle aynı kart oynarsa
        else if (Board.getTopCardDeck().getCardFace().equals(getPlayerHand().get(cardChoose).getCardFace())) {
            card = getPlayerHand().get(cardChoose);
            addCardToBoard(card);
            addCardToWon(card);             //kartları topla
            getPlayerHand().remove(cardChoose);
        }

        return Board.getTopCardDeck();
    }


}
