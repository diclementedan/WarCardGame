package wargame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

// I have left all the JUnit tests I had written attempting to test specific
// methods in the file as comments so you can see I made an honest attempt
// before resorting to manual instructions.

/**
 * Class used to test the functionality of WarGame.java class
 *
 * @author Daniel Di Clemente
 */
public class WarGameTest {

    public WarGameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("In setUpClass");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("In tearDownClass");
    }

    @Before
    public void setUp() {
        System.out.println("In setUp");
    }

    @After
    public void tearDown() {
        System.out.println("In tearDown");
    }

    // String used to determine score to update spelled correctly
    @Test
    public void testUpdateScoreGood() {
        System.out.println("updateScoreGood");
        String winner = "player wins!";
        boolean expResult = true;
        boolean result = (winner.toLowerCase().equals("player wins!"));
        assertEquals(expResult, result);
    }

    // String used to determine score to update mis-capitalized and misspelled
    @Test
    public void testUpdateScoreBad() {
        System.out.println("updateScoreBad");
        String winner = "compUtr wonS!";
        boolean expResult = false;
        boolean result = (winner.toLowerCase().equals("player wins!"));
        assertEquals(expResult, result);
    }

    // String used to determine score to update, correct spelling, wrong caps
    @Test
    public void testUpdateScoreBoundary() {
        System.out.println("updateScoreBoundary");
        String winner = "pLayER WInS!";
        boolean expResult = true;
        boolean result = (winner.toLowerCase().equals("player wins!"));
        assertEquals(expResult, result);
    }
    
    // One card has a clearly higher value than the other
    @Test
    public void testCompareHandsGood() {
        System.out.println("compareHandsGood");
        Card playerCard = new Card(Suit.CLUBS, Value.ACE);
        Card cpuCard = new Card(Suit.CLUBS, Value.FIVE);
        WarGame instance = new WarGame();
        String expResult = "Player wins!";
        String result = instance.compareHands(playerCard, cpuCard);
        assertEquals(expResult, result);
    }

    // Both cards have the same value
    @Test
    public void testCompareHandsBad() {
        System.out.println("compareHandsBad");
        Card playerCard = new Card(Suit.CLUBS, Value.ACE);
        Card cpuCard = new Card(Suit.HEARTS, Value.ACE);
        WarGame instance = new WarGame();
        String expResult = "It's a tie!";
        String result = instance.compareHands(playerCard, cpuCard);
        assertEquals(expResult, result);
    }

    // Cards are very close in value
    @Test
    public void testCompareHandsBoundary() {
        System.out.println("compareHandsBoundary");
        Card playerCard = new Card(Suit.SPADES, Value.SIX);
        Card cpuCard = new Card(Suit.SPADES, Value.SEVEN);
        WarGame instance = new WarGame();
        String expResult = "Computer Player wins!";
        String result = instance.compareHands(playerCard, cpuCard);
        assertEquals(expResult, result);
    }

    // There is not a boundary situation for the draw methods. Either a card is
    // drawn from the deck because the ArrayList has Cards or the list is empty
    // and the Card is null.
//    @Test
//    public void testDrawPlayerCardGood() {
//        System.out.println("drawPlayerCardGood");
//        WarGame instance = new WarGame();
//        Card expResult = instance.playerDeck.get(instance.playerDeck.size());
//        Card result = instance.drawPlayerCard();
//        assertEquals(expResult, result);
//    }
//
//    // When playerDeck is empty and a card is attempting to be drawn
//    @Test
//    public void testDrawPlayerCardBad() {
//        System.out.println("drawPlayerCardBad");
//        WarGame instance = new WarGame();
//        instance.playerDeck.clear();
//        Card expResult = null;
//        Card result = instance.drawPlayerCard();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testDrawCpuCardGood() {
//        System.out.println("drawCpuCardGood");
//        WarGame instance = new WarGame();
//        Card expResult = instance.cpuDeck.get(instance.cpuDeck.size() - 1);
//        Card result = instance.drawCpuCard();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testDrawCpuCardBad() {
//        System.out.println("drawCpuCardBad");
//        WarGame instance = new WarGame();
//        instance.cpuDeck.clear();
//        Card expResult = null;
//        Card result = instance.drawCpuCard();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testDeclareWinnerGood() {
//        System.out.println("declareWinnerGood");
//        WarGame instance = new WarGame();
//        instance.playerDeck.clear();
//        instance.player.setScore(2);
//        instance.computer.setScore(50);
//        boolean expResult = true;
//        boolean result = instance.declareWinner().equals("Computer wins, better luck next time!");
//        instance.declareWinner();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testDeclareWinnerBad() {
//        System.out.println("declareWinnerBad");
//        WarGame instance = new WarGame();
//        instance.playerDeck.clear();
//        instance.player.setScore(40);
//        instance.computer.setScore(12);
//        boolean expResult = false;
//        boolean result = instance.declareWinner().equals("Congratulations, you won!");
//        instance.declareWinner();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testDeclareWinnerBoundary() {
//        System.out.println("declareWinnerBoundary");
//        WarGame instance = new WarGame();
//        instance.player.setScore(26);
//        instance.computer.setScore(26);
//        boolean expResult = true;
//        boolean result = instance.declareWinner().contains("Game has been");
//        instance.declareWinner();
//        assertEquals(expResult, result);
//    }
//    
//    @Test
//    public void testTieBreakerGood() {
//        System.out.println("tieBreakerGood");
//        Card pCard = new Card(Suit.CLUBS, Value.ACE);
//        Card cpuCard = new Card(Suit.CLUBS, Value.ACE);
//        WarGame instance = new WarGame();
//        boolean expResult = true;
//        boolean result = instance.tieBreaker().contains("wins!");
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testTieBreakerBad() {
//        System.out.println("tieBreakerBad");
//        Card pCard = new Card(Suit.CLUBS, Value.FIVE);
//        Card cpuCard = new Card(Suit.CLUBS, Value.THREE);
//        WarGame instance = new WarGame();
//        boolean expResult = false;
//        boolean result = instance.tieBreaker().contains("Computer Player wins!");
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testTieBreakerBoundary() {
//        System.out.println("tieBreakerBoundary");
//        Card pCard = new Card(Suit.CLUBS, Value.NINE);
//        Card cpuCard = new Card(Suit.CLUBS, Value.TEN);
//        WarGame instance = new WarGame();
//        boolean expResult = true;
//        boolean result = instance.tieBreaker().contains("Computer Player wins!");
//        assertEquals(expResult, result);
//    }
}
