package se.ek.se.ek.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Deck {

    private final int DECK_SIZE = 52;
    private final int DECK_AMOUNT = 1;

    private List<Card> cardDeck = new ArrayList<>();
    private CardType[] cardTypes = new CardType[]{CardType.CLUB, CardType.DIAMOND, CardType.HEART, CardType.SPADE};

    public void createCardDeck() {
        int cardNumber = 1;
        int cardType = 0;
        for (int i = 0; i < DECK_AMOUNT; i++) {
            for (int j = 0; j < DECK_SIZE; j++) {
                if (cardNumber > 13) cardNumber = 1;
                if (cardType > 3) cardType = 0;

                cardDeck.add(new Card(cardNumber > 10 ? 10 : cardNumber, cardTypes[cardType]));
                cardNumber++;
                cardType++;
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(cardDeck);
    }

    public void printDeck() {
        for (Card card : cardDeck) {
            System.out.println(card);
        }
    }

    public List<Card> getCardDeck() {
        return cardDeck;
    }

}
