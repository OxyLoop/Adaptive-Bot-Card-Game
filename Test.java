import java.util.ArrayList;
import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int deckCardCounter = 0;
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

        //dealing cards to board
        for(int i=0; i<4; i++){
            Board.addBoardCards(mainDeck.getCards().get(deckCardCounter));
            Board.addPlayedCards(mainDeck.getCards().get(deckCardCounter));
            deckCardCounter++;
            // MASADAKİ KARTLARIN EN ÜSTÜNDEKİNİ DE EXPERT BOTUN GÖRMESİ LAZIM
        }


        while(true){
            //dealing cards to players
            if(bots.get(bots.size()).getHand().get(1)==null){
                Deck.dealCards(botnumber,mainDeck,bots,deckCardCounter,a);
            }
            //if(a==true){
             //  Card playedcard = player.play();
             // Board.addBoardCards(playedcard);
             // Board.addPlayedCards(playedcard);

            //}
            for(int i=1; i<botnumber; i++){
                Card playedcard = bots.get(i).playCard();
                Board.addBoardCards(playedcard);
                Board.addPlayedCards(playedcard);
            }
            
            
        }






        //play turns
        //while(true){

        


    }
}