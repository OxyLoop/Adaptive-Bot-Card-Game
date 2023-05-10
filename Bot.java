import java.util.ArrayList;

public abstract class Bot {

    public abstract void addCard(Card card) ;

    public abstract Card playCard();

    public abstract ArrayList<Card> getHand() ;

    public abstract ArrayList<Card> getBotTakenCards();

    // public abstract ArrayList<Card> botPlayedCards();



    
}
