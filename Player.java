import java.util.ArrayList;

public class Player {
    private String name;
    private int score;

    ArrayList<Card> cardsInHand = new ArrayList<>();        // Player's hand card
    ArrayList<Card> wonCards = new ArrayList<>();       // Player's won cards

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
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


    public void showCards() {  //shows player cards
        System.out.println("\n----My Hand---- ");

        for (int i = 0; i < cardsInHand.size(); i++) {

            System.out.println(i + " " + cardsInHand.get(i).toString());
        }
    }

    public void calculateScore() {  // calculate user score
    }
}
