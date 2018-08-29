import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.ek.Player;
import se.ek.se.ek.card.Card;
import se.ek.se.ek.card.CardType;

import java.util.ArrayList;
import java.util.List;

public class TestSoftHand {

    private Player player1;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("Player1");
    }

    public void dealCardsToPlayer(List<Card> mockedDeck) {
        for (int i = 0; i < mockedDeck.size(); i++) {
            player1.dealCard(mockedDeck.get(i));
        }
    }

    @Test
    public void testNormalHand() {
        List<Card> mockedDeck = new ArrayList<>();
        mockedDeck.add(new Card(8, CardType.DIAMOND));
        mockedDeck.add(new Card(6, CardType.HEART));
        dealCardsToPlayer(mockedDeck);
        Assert.assertEquals(14, player1.getCardTotal());
        Assert.assertEquals(0, player1.getSoftCardTotal());
    }

    @Test
    public void testNormalSoftHand() {
        List<Card> mockedDeck = new ArrayList<>();
        mockedDeck.add(new Card(1, CardType.DIAMOND));
        mockedDeck.add(new Card(6, CardType.HEART));
        dealCardsToPlayer(mockedDeck);
        Assert.assertEquals(17, player1.getCardTotal());
        Assert.assertEquals(7, player1.getSoftCardTotal());
    }

    @Test
    public void testLowestSoftHand() {
        List<Card> mockedDeck = new ArrayList<>();
        mockedDeck.add(new Card(1, CardType.DIAMOND));
        mockedDeck.add(new Card(1, CardType.HEART));
        dealCardsToPlayer(mockedDeck);
        Assert.assertEquals(12, player1.getCardTotal());
        Assert.assertEquals(2, player1.getSoftCardTotal());
    }

    @Test
    public void testBlackjackSoftHand() {
        List<Card> mockedDeck = new ArrayList<>();
        mockedDeck.add(new Card(1, CardType.DIAMOND));
        mockedDeck.add(new Card(10, CardType.HEART));
        dealCardsToPlayer(mockedDeck);
        Assert.assertEquals(21, player1.getCardTotal());
        Assert.assertEquals(0, player1.getSoftCardTotal());
    }

    @Test
    public void testOverSoftHand() {
        List<Card> mockedDeck = new ArrayList<>();
        mockedDeck.add(new Card(1, CardType.DIAMOND));
        mockedDeck.add(new Card(5, CardType.HEART));
        mockedDeck.add(new Card(7, CardType.HEART));
        dealCardsToPlayer(mockedDeck);
        Assert.assertEquals(13, player1.getCardTotal());
        Assert.assertEquals(0, player1.getSoftCardTotal());
    }

    @Test
    public void testOverSoftHandBust() {
        List<Card> mockedDeck = new ArrayList<>();
        mockedDeck.add(new Card(1, CardType.DIAMOND));
        mockedDeck.add(new Card(5, CardType.HEART));
        mockedDeck.add(new Card(7, CardType.HEART));
        mockedDeck.add(new Card(9, CardType.HEART));
        dealCardsToPlayer(mockedDeck);
        Assert.assertEquals(22, player1.getCardTotal());
        Assert.assertEquals(0, player1.getSoftCardTotal());
    }


}
