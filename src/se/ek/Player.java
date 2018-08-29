package se.ek;

import se.ek.se.ek.card.Card;
import se.ek.se.ek.card.CardType;

import java.util.ArrayList;
import java.util.List;

public final class Player {
    private final String playerName;
    private List<Card> cards = new ArrayList<>();
    private int softCardTotal = 0;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void dealCard(Card card) {
        this.cards.add(card);
    }

    public String printCards() {
        String cardsString = "";

        for (Card card : cards) {
            cardsString += "[" + card.getCardNumber() + " " + CardType.getCardTypeString(card.getCardType()) + "]";
        }
        return cardsString;
    }

    public int getCardTotal() {
        int total = 0;
        if (hasFirstCardAce()) {
            softCardTotal = 1;
            total = 11;
            for (int i = 1; i < cards.size(); i++) {
                softCardTotal += cards.get(i).getCardNumber();
                total += cards.get(i).getCardNumber();
                if (total > 21) total = softCardTotal;
            }
            if (softCardTotal > 10) softCardTotal = 0;
        } else {
            for (Card card : cards) {
                total += card.getCardNumber();
            }
        }
        return total;
    }

    public boolean hasFirstCardAce() {
        return cards.get(0).getCardNumber() == 1;
    }

    public int getSoftCardTotal() {
        return softCardTotal;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", cards=" + cards +
                '}';
    }
}
