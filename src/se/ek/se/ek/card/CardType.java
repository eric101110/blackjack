package se.ek.se.ek.card;

import java.util.HashMap;
import java.util.Map;

public enum CardType {
    SPADE,
    HEART,
    DIAMOND,
    CLUB;

    private static Map<CardType, String> cardTypes = new HashMap<>();

    static {
        cardTypes.put(SPADE, "♠");
        cardTypes.put(CardType.DIAMOND, "♦");
        cardTypes.put(CardType.HEART, "♥");
        cardTypes.put(CardType.CLUB, "♣");
    }

    public static String getCardTypeString(CardType cardType) {
        return cardTypes.get(cardType);
    }
}
