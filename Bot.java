import java.util.ArrayList;

public abstract class Bot {
    protected String name;
    private ArrayList<Card> botHand;

    public Bot(String name) {
        this.name = name;
        this.botHand = new ArrayList<Card>();
    }
    
    public String getName(){
        return name;
    }

    public void addCard(Card card) {
        botHand.add(card);
    }
    public void addCardToBoard(Card card) {
        Board.getBoardCards().add(card);
    }
    public abstract Card botPlayCard(Board board);

    public ArrayList<Card> getHand() {
        return botHand;
    }

    public abstract ArrayList<Card> getBotTakenCards();






    
}
