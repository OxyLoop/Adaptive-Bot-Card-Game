import java.util.ArrayList;
import java.util.Random;

public class ExpertBot extends Bot {
    private static ArrayList<Card> botHand; // Bot's hand of cards
    private ArrayList<Card> botTakenCards;
    private int score;
    
    public  ExpertBot(String name) {
        super(name);
    }

    @Override
    public void addCard(Card card) {
        botHand.add(card);
    }

    @Override
    public Card playCard(Board board) {
        Card playCard = null;

        //check pişti
        if(Board.getTopCardDeck() != null){
            for(int i=0; i<botHand.size(); i++){
                if(botHand.get(i).getCardFace().equals(Board.getTopCardDeck().getCardFace())){
                    playCard = botHand.get(i);
                    // botPlayedCards.add(playCard);                  *******EXPERT BOT GÖRSÜN DİYE ARRAYLİSTE EKLEDİ
                    botHand.remove(i);
                    score = score + 10;
                    break;
                }
            }
        }

        //check played cards on game

        
        
        //random play
        if(playCard !=null){
            Random rand = new Random();
            int index = rand.nextInt(botHand.size());
            playCard = botHand.get(index);
            // botPlayedCards.add(playCard);                      *******EXPERT BOT GÖRSÜN DİYE ARRAYLİSTE EKLEDİ
            botHand.remove(index);
        }
        return playCard;
        
    }

    @Override
    public ArrayList<Card> getHand() {
        return botHand;
    }

    public ArrayList<Card> getBotTakenCards(){
        return botTakenCards;
    }

    public String getName() {
        return name;
    }
    
}
