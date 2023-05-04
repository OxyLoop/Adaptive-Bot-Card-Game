public class Card {
    private final String suit;
    private final String cardface;
    private final int points;

    public Card(String suit, String cardface, int points) {
        this.suit = suit;
        this.cardface = cardface;
        this.points = points;
    }

    public String getSuit() {
        return suit;
    }

    public String getCardface() {
        return cardface;
    }

    public int getPoints() {
        return points;
    }

    public String cardNameString() {
        return cardface + suit;
    }
}
    