import java.util.ArrayList;
import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Deck mainDeck = new Deck();
        Board board = new Board();
        ArrayList<Players> players = new ArrayList<Players>();
        

        System.out.println(mainDeck.getCards().size()); //test
        //shuffing and cutting
        mainDeck.shuffle();
        int cutBeginIndex = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Can you enter an index that you want to cut: ");
                cutBeginIndex = sc.nextInt();
                if(cutBeginIndex<0) {
                    throw new IllegalArgumentException("Negative number is not allowed.");
                }
                validInput = true;
            }catch (IllegalArgumentException exception) {
                System.out.println("Error: " + exception.getMessage());
            }
        }
        mainDeck.cut(cutBeginIndex);
        
        //Asking the game settings
        boolean a = GameSettings.askPlayerPlay();
        if(a == true){
            String playerName = GameSettings.nameOfPlayer();
            Human human = new Human(playerName);
            players.add(human);
        }
        int playersNumber = GameSettings.howManyBots() +1;
        GameSettings.botLevelChoose(players);

        //dealing cards to board
        for(int i=0; i<4; i++){
            Board.addCardToBoard(mainDeck.getCards().get(0));
            Board.addPlayedCards(mainDeck.getCards().get(0));
            mainDeck.getCards().remove(0);
        }

        System.out.println("Board is: ");
        for(Card card: board.getBoardCards()) {
            System.out.println(card.cardNameString());
        }
        System.out.println("Dealed board deck is: ");
        for(Card card: mainDeck.cards) {
            System.out.println(card.cardNameString());
        }


        while(true){
            //dealing cards to players
            if(players.get(playersNumber-1).getHand().isEmpty() == true){
                System.out.println("Dealing new Cards.");
                Deck.dealCards(playersNumber,mainDeck,players,a);
            }

            System.out.println("1. bot hand: ");
            for(Card card: players.get(1).getHand()) {
                System.out.println(card.cardNameString());
            }
            System.out.println("2. bot hand: ");
            for(Card card: players.get(2).getHand()) {
                System.out.println(card.cardNameString());
            }
            //writing top card on board
            System.out.println("Board cards are:");
            for(Card card: board.getBoardCards()) {
                System.out.println(card.cardNameString());
            }
            System.out.println("Played cards are:");
            for(Card card: board.getPlayedCards()) {
                System.out.println(card.cardNameString());
            }
            
            if(board.getBoardCards().isEmpty()==true){
                System.out.println("There are no cards on board");
            }else {
                System.out.println("Top card on the board:");
            System.out.println(board.getTopCardDeck().cardNameString());
            }
            
            for(int i=0; i<playersNumber; i++){
                Card playedcard = players.get(i).PlayCard(board);
                board.PlayedCard(playedcard,players.get(i),board);
            }
            //test
            for(Players player: players) {
                System.out.println(player.getName()+ " score: " +player.getScore());
            }
            
            
        }

    }
}