package se.ek;

import se.ek.se.ek.card.Card;
import se.ek.se.ek.card.Deck;

import java.util.List;
import java.util.Scanner;

public final class Blackjack {

    private final Player player1 = new Player("Player1");
    private final Player dealer = new Player("Dealer");

    private static List<Card> cardDeck;
    private int currentCardIndex = 0;

    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        Deck deck = new Deck();
        cardDeck = deck.getCardDeck();
        deck.createCardDeck();
        deck.shuffleDeck();
        blackjack.play();
    }

    private void play() {
        player1.dealCard(fetchCard());
        dealer.dealCard(fetchCard());
        player1.dealCard(fetchCard());

        printBoard();
        Scanner keyInput = new Scanner(System.in);
        String line = keyInput.nextLine();

        while (!line.equalsIgnoreCase("r")) {
            if (line.equalsIgnoreCase("h")) hit();
            if (line.equalsIgnoreCase("s")) stand();
            line = keyInput.nextLine();
        }
    }

    private void hit() {
        System.out.println("Hit");
        player1.dealCard(fetchCard());
        printBoard();

        if (player1.getCardTotal() > 21) {
            System.out.println("Too much, you lost!");
            System.exit(1);
        }
    }

    private void stand() {
        System.out.println("Stand");
        while (dealer.getCardTotal() <= 16) {
            dealer.dealCard(fetchCard());
            printBoard();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (dealer.getCardTotal() > 21) {
            System.out.println(dealer.getPlayerName() + " got too much " + player1.getPlayerName() + " wins!");
            System.exit(1);
        }

        if (player1.getCardTotal() > dealer.getCardTotal()) {
            System.out.println(player1.getPlayerName() + " wins!");
        } else if (player1.getCardTotal() < dealer.getCardTotal()) {
            System.out.println(dealer.getPlayerName() + " wins!");
            System.out.println("Possible next card " + fetchCard().getCardNumber());
        } else {
            System.out.println("Push");
        }
    }

    private void printBoard() {
        for (int i = 0; i < 30; i++) {
            System.out.println("\b");
        }
        String dealerTotalString = String.valueOf(dealer.getCardTotal());
        if (dealer.hasFirstCardAce() && dealer.getSoftCardTotal() > 0)
            dealerTotalString = dealer.getSoftCardTotal() + "/" + dealerTotalString;

        String player1TotalString = String.valueOf(player1.getCardTotal());
        if (player1.hasFirstCardAce() && player1.getSoftCardTotal() > 0)
            player1TotalString = player1.getSoftCardTotal() + "/" + player1TotalString;

        System.out.println(dealer.getPlayerName() + " " + dealer.printCards() + " Total:" + dealerTotalString + "\n");
        System.out.println(player1.getPlayerName() + " " + player1.printCards() + " Total:" + player1TotalString + "\n");

        System.out.println("---- Press H to hit, S to stand, R to quit ----\n");
    }

    private Card fetchCard() {
        return cardDeck.get(currentCardIndex++);
    }

}
