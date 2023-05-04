public class Card {
    private final String suit;
    private final String cardFace;
    private int point;

    public Card(String suit, String cardFace, int point) {
        this.suit = suit;
        this.cardFace = cardFace;
        this.point = point;
    }

    public String getSuit() {
        return suit;
    }

    public String getCardFace() {
        return cardFace;
    }

    public int getPoints() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }

    public String cardNameString() {
        return suit + cardFace + " " + point;
    }
}
    