import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        Deck mainDeck = new Deck();
        Board board = new Board();
        ArrayList<Players> players = new ArrayList<Players>();
        

        System.out.println(mainDeck.getCards().size()); //test
        //shuffing and cutting
        mainDeck.shuffle();
        System.out.println("Deck is shuffled.");
        int cutBeginIndex = rand.nextInt(52);
        mainDeck.cut(cutBeginIndex);
        System.out.println("Deck is cutted.");
        
        //Asking the game settings
        boolean a = GameSettings.askPlayerPlay();
        int playersNumber;
        if(a == true){
            String playerName = GameSettings.nameOfPlayer();
            Human human = new Human(playerName);
            players.add(human);
            playersNumber = GameSettings.howManyBots() +1;
        }else{
            playersNumber = GameSettings.howManyBots();
        }
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
            if(a!= true){
                for(int i=0;i<playersNumber;i++){
                    System.out.println((i+1)+". bot hand: ");
                    for(Card card: players.get(i).getHand()) {
                        System.out.println(card.cardNameString());
                    }
                }
            }
             
            //writing top card on board
            if(board.getBoardCards().isEmpty()==true){
                System.out.println("There are no cards on board");
            }else {
                System.out.println("Top card on the board:");
            System.out.println(board.getTopCardDeck().cardNameString());
            }
            
            //players turn
            for(int i=0; i<playersNumber; i++){
                Card playedcard = players.get(i).PlayCard(board);
                board.PlayedCard(playedcard,players.get(i),board);
            }
            if(a!=true){
                System.out.println("Write anything to end turn of bots");
                sc.nextLine();   
            }
            if(board.getPlayedCards().size()==52){
                break;
            }
            
            
            
        }
        System.out.println("Calculating players score");

        //calculating players score
        for(Players player: players) {
            System.out.println(player.getName()+ " score: " +player.getScore());
        }
        System.out.println("--------------GAME OVER--------------");
        Players Winner = Board.getWinner(players);
        System.out.println(Winner.getName()+" wins the game with "+ Winner.getScore()+" score.");

        GameSettings.saveScores(Winner);
        

    }
}