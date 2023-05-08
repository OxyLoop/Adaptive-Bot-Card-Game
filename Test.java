import java.util.ArrayList;
import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Deck mainDeck = new Deck();
        ArrayList<Bot> bots = new ArrayList<Bot>();
        

        System.out.println(mainDeck.getCards().size());

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
        int cutBeginIndex = sc.nextInt();

        mainDeck.cut(cutBeginIndex);
        System.out.println("Cut deck is: ");
        for(Card card: mainDeck.cards) {
            System.out.println(card.cardNameString());
        }

        //Asking the game settings
        GameSettings.askPlayerPlay();
        boolean a = GameSettings.getIsPlayerPlay();
        if(a = true){
            GameSettings.nameOfPlayer();
        }
        int botnumber = GameSettings.howManyPlayers();
        GameSettings.botLevelChoose(bots);




        while(true){
            //if(a==true){
             //   player.play();
            //}
            for(int i=1; i<botnumber; i++){
                
            }
            
            
        }






        //play turns
        //while(true){

        


    }
}