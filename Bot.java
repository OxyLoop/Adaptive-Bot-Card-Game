import java.util.ArrayList;

public abstract class Bot {
    private ArrayList<Card> Hand;

    public Bot (ArrayList<Card> Hand){
        this.Hand = Hand;
    }

    public ArrayList<Card> getHand(){
        return Hand;
    }

    public abstract void play();


    
}
