import java.util.ArrayList;
import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Deck mainDeck = new Deck();
        Board board = new Board();
        ArrayList<Bot> bots = new ArrayList<Bot>();
        

        System.out.println(mainDeck.getCards().size()); //test

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
        boolean a = GameSettings.askPlayerPlay();
        if(a == true){
            GameSettings.nameOfPlayer();
        }
        int botnumber = GameSettings.howManyPlayers() - 1 ;
        GameSettings.botLevelChoose(bots);

        //dealing cards to board
        for(int i=0; i<4; i++){
            Board.addCardToBoard(mainDeck.getCards().get(0));
            mainDeck.getCards().remove(0);
            Board.addPlayedCards(mainDeck.getCards().get(0));
        }

        System.out.println("Board is: ");
        for(Card card: Board.getBoardCards()) {
            System.out.println(card.cardNameString());
        }
        
        System.out.println("Dealed board deck is: ");
        for(Card card: mainDeck.cards) {
            System.out.println(card.cardNameString());
        }


        //while(true){
            //dealing cards to players
            if(bots.get(botnumber).getHand().isEmpty() == true){
                Deck.dealCards(botnumber,mainDeck,bots,a);
            }

            for(Bot deneme: bots) {
                System.out.println(deneme);
            }

            System.out.println("1. bot hand: ");
            for(Card card: bots.get(0).getHand()) {
                System.out.println(card.cardNameString());
            }
            System.out.println("2. bot hand: ");
            for(Card card: bots.get(1).getHand()) {
                System.out.println(card.cardNameString());
            }
            //System.out.println("3. bot hand: ");
            //for(Card card: bots.get(2).getHand()) {
               // System.out.println(card.cardNameString());
            //}


            //if(a==true){
             // Card playedcard = player.play();
             // Board.addBoardCards(playedcard);
             // Board.addPlayedCards(playedcard);

            //}
            for(int i=1; i<botnumber; i++){
                Card playedcard = bots.get(i).botPlayCard(board);
                Board.addCardToBoard(playedcard);
                Board.addPlayedCards(playedcard);
            }
            
            
        //}

    }
}