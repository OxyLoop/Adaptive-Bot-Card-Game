import java.util.ArrayList;
import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Deck mainDeck = new Deck();
        Board board = new Board();
        ArrayList<Bot> bots = new ArrayList<Bot>();
        Player human = new Player(null);
        

        System.out.println(mainDeck.getCards().size()); //test
        //shuffing and cutting
        mainDeck.shuffle();
        System.out.println("Can you enter an index that you want to cut: ");
        int cutBeginIndex = sc.nextInt();
        mainDeck.cut(cutBeginIndex);
        
        //Asking the game settings
        boolean a = GameSettings.askPlayerPlay();
        if(a == true){
            GameSettings.nameOfPlayer();
        }
        int botnumber = GameSettings.howManyPlayers();
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


        while(true){
            //dealing cards to players
            if(bots.get(botnumber-1).getHand().isEmpty() == true){
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
            //writing top card on board
            System.out.println("Number of cards on board: " + Board.getBoardCards().size());
            System.out.println("Number of played cards: " + Board.getPlayedCards().size());
            System.out.println("Top card on the board:");
            System.out.println(Board.getTopCardDeck().cardNameString());


            if(a==true){
                Card playedcard = human.playerPlayCard();
                board.playerPlayedCard(playedcard, human);
            }
            for(int i=0; i<botnumber; i++){
                Card playedcard = bots.get(i).botPlayCard(board);
                Board.botPlayedCard(playedcard,bots.get(i));
            }
            
            
        }

    }
}