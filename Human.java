import java.util.ArrayList;
import java.util.Scanner;

public class Human extends Players {


    static ArrayList<Card> playerHand = new ArrayList<>();        // Player's hand card
    static ArrayList<Card> playerWonCards = new ArrayList<>();       // Player's won cards


    public Human(String name) {
        super(name);
    }
    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }
    public ArrayList<Card> getWonCards() {
        return playerWonCards;
    }
    public void addCard(Card card) {
        playerHand.add(card);
    }
    

    public void showCards() {  //shows player cards
        System.out.println("\n----My Hand---- ");

        for (int i = 0; i < playerHand.size(); i++) {

            System.out.println(i+1 + " " + playerHand.get(i).cardNameString());
        }
    }

    public void calculateScore() {  // calculate user score
    }

    public Card PlayCard(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Your cards are: ");
        showCards();
        System.out.println("Enter a number of card that you want to play: ");
        int cardChoose = sc.nextInt()-1;
        Card playedCard = getPlayerHand().get(cardChoose);
        getPlayerHand().remove(cardChoose);
        
        return playedCard;
        
    }


}
