import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        Deck mainDeck = new Deck();

        //System.out.println(mainDeck.getCards().size());

        System.out.println("Original deck is: " );
        for(Card card: mainDeck.cards) {
            System.out.println(card.cardNameString());
        }

        System.out.println("____________________________________");

        mainDeck.shuffle();
        System.out.println("Shuffled deck is: ");
        for(Card card: mainDeck.cards) {
            System.out.println(card.cardNameString());
        }

        System.out.println("____________________________________");

        System.out.println("Can you enter an index that you want to cut: ");
        Scanner sc = new Scanner(System.in);
        int cutBeginIndex = sc.nextInt();

        mainDeck.cut(cutBeginIndex);
        System.out.println("Cut deck is: ");
        for(Card card: mainDeck.cards) {
            System.out.println(card.cardNameString());
        }


    }
}