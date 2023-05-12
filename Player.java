import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    private int score;
    private int playerPistiCounter;

    static ArrayList<Card> playerHand = new ArrayList<>();        // Player's hand card
    static ArrayList<Card> playerWonCards = new ArrayList<>();       // Player's won cards

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
    public static ArrayList<Card> getWonCards() {
        return playerWonCards;
    }
    public static void addCardToHand(Card card) {
        playerHand.add(card);
    }
    
    public void addCardToWon(Card card) {
        for(int i=0 ; i<Board.getBoardCards().size(); i++) {
            playerWonCards.add(card);
        }
    }


    public void showCards() {  //shows player cards
        System.out.println("\n----My Hand---- ");

        for (int i = 0; i < playerHand.size(); i++) {

            System.out.println(i+1 + " " + playerHand.get(i).cardNameString());
        }
    }

    public void calculateScore() {  // calculate user score
    }

    public Card playerPlayCard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your cards are: ");
        showCards();
        System.out.println("Enter a number of card that you want to play: ");
        int cardChoose = sc.nextInt()-1;
        Card playedCard = getPlayerHand().get(cardChoose);
        getPlayerHand().remove(cardChoose);
        return playedCard;
        
    }

    public static void addCard(Card card) {
    }


}
