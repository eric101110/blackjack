package se.ek.se.ek.card;

public final class Card {

    private final int cardNumber;
    private final CardType cardType;

    public Card(int cardNumber, CardType cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", cardType=" + cardType +
                '}';
    }
}
