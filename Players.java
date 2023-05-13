import java.util.ArrayList;
public abstract class Players {
    private String name;
    private ArrayList<Card> hand;
    private ArrayList<Card> takenCards;
    private int score;

    public Players(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.takenCards = new ArrayList<Card>();
        score = 0;
    }
    
    public String getName(){
        return name;
    }

    public void addCard(Card card) {
        hand.add(card);
    }
    
    public abstract Card PlayCard(Board board);

    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public ArrayList<Card> getTakenCards(){
        return takenCards;
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

    public Players[] getWinner() {
        return null;
    }
}