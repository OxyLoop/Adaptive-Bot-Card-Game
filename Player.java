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
    public static ArrayList<Card> getPlayerHand() {
        return playerHand;
    }



    public void showCards() {  //shows player cards
        System.out.println("\n----My Hand---- ");

        for (int i = 0; i < playerHand.size(); i++) {

            System.out.println(i + " " + playerHand.get(i).toString());
        }
    }

    public void calculateScore() {  // calculate user score
    }


    public void playerPlayCard(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your cards are: ");
        showCards();
        System.out.println("Enter a number of card that you want to play: ");
        int cardChoose = sc.nextInt();
        Card card;

        //pişti olursa
        Board.playerCheckPisti(cardChoose);
        //joker oynarsa
        Board.playedJoker(cardChoose);
        //masa boşsa veya ortadakiyle aynı kart OYNAMAZSA
        Board.playedSame(cardChoose);
        //ortadakiyle aynı kart oynarsa
        Board.playedDifferent(cardChoose);

    }


}
