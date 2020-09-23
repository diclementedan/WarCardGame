/*
    WarGame.java
    Author: Daniel Di Clemente
    Date: April 2020

    Description
    This program models the card game WAR. It contains classes to create and
    register players, create Cards with set values and suits through the use of
    enums, create decks of Cards wit hthe use of ArrayLists, and finally this
    class models the game itself and the interactions with the user and the
    logic behind the game operations. This program makes use of many OOP design
    principles patterns including abstraction, Open Closed, encapsulating what
    is different, and more.
 */
package wargame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel Di Clemente
 */
public class WarGame {
    
    // Create deck object, ArrayLists, Players and Scanner for rest of class
    Deck d = new Deck();
    ArrayList<Card> deck = d.generateDeck();
    ArrayList<Card> playerDeck = new ArrayList();
    ArrayList<Card> cpuDeck = new ArrayList();
    CpuPlayer computer;
    HumanPlayer player;
    Scanner input = new Scanner(System.in);

    /**
     * Main method which conducts the rest of the methods to perform their
     * duties. Also includes some programming logic in order to run the game.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        WarGame war = new WarGame();
        System.out.println("Welcome to WAR, the card game!");
        
        // Instantiate player objects
        war.computer = new CpuPlayer();
        String playerName = war.getInput("Please enter your name: ");
        war.player = new HumanPlayer(playerName);

        // Call setup method to split decks, etc.
        war.setup();
        String playAgain = "y";

        // While user chooses, game will loop
        while (playAgain.toLowerCase().charAt(0) == 'y') {
            Card playerCard = war.drawCpuCard();
            Card cpuCard = war.drawPlayerCard();
            System.out.println("\nPlayer card: " + playerCard);
            System.out.println("Computer card: " + cpuCard);
            String winner = war.compareHands(playerCard, cpuCard);
            System.out.println("\n" + winner);
            if (winner.toLowerCase().equals("it's a tie!")) {
                System.out.println("Tiebreaker until one player has higher "
                        + "card: ");
                war.tieBreaker();
            } else {
                war.updateScore(winner);
                // If a deck is empty, the game ends
                if (war.playerDeck.isEmpty() || war.cpuDeck.isEmpty()) {
                    break; 
                }
                war.displayScore();
                playAgain = war.getInput("Ready for next round?(y/n): ");
            }
        }
        // When user decides to end the game or deck is empty, declare winner
        System.out.println(war.declareWinner());
    }

    /**
     * Method to get the inputs from the user
     * 
     * @param prompt Message to be displayed to user
     * @return String containing the user's input
     */
    public String getInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    /**
     * Method to shuffle the deck then iterate through the deck splitting it
     * into two decks, one for the player, one for the the computer player.
     */
    public void setup() {
        /* After players are registered, code would be written here that would
           have created the deck, shuffled it, then split it in two. One deck
           for each player. On each round, a card would be taken from the last
           index of each players ArrayList of cards, displayed on screen,
           and passed to the compareHands() method for comparison. That is where
           I have begun writing code in this class.
         */

        // Shuffle deck and split in two, one for each player
        deck = d.shuffle(deck);
        for (int i = 1; i <= deck.size(); i++) {
            if (i % 2 == 0) {
                playerDeck.add(deck.get(i - 1));
            } else {
                cpuDeck.add(deck.get(i - 1));
            }
        }
    }

    /**
     * Method to draw the top card from the players deck
     * 
     * @return Card from the top of players deck
     */
    public Card drawPlayerCard() {
        Card card = playerDeck.get(playerDeck.size() - 1);
        playerDeck.remove(playerDeck.size() - 1);
        return card;
    }

    /**
     * Method to draw the top card from the computer players deck
     * 
     * @return Card from top of computer players deck
     */
    public Card drawCpuCard() {
        Card card = cpuDeck.get(cpuDeck.size() - 1);
        cpuDeck.remove(cpuDeck.size() - 1);
        return card;
    }

    /**
     * Method to determine who is the winner of the game. If one of the decks is
     * empty then a winner is determined. If user exited game early, no winner
     * is determined because game was unfinished. Instead, display score and
     * notify user there was no winner.
     * 
     * @return String containing the winner and the message to display to user
     */
    public String declareWinner() {
        String output = "";
        if (playerDeck.isEmpty() || cpuDeck.isEmpty()) {
            displayScore();
            if (player.getScore() > computer.getScore()) {
                output = "Congratulations, you won!";
            } else {
                output = "Computer wins, better luck next time!";
            }
        } else {
            displayScore();
            output = "Game has been exited before a winner could be"
                    + " determined, current scores are listed above.\nPlease "
                    + "play again soon!";
        }
        return output;
    }

    // compareHands would be called after the draw card methods
    /**
     * Method to determine which player wins based on the value of the Cards
     * supplied.
     * 
     * @param playerCard The Players Card
     * @param cpuCard The computer Players Card
     * @return String containing the winner of the round
     */
    public String compareHands(Card playerCard, Card cpuCard) {
        String winner = "";
        double playerValue = playerCard.getValue().getCardValue();
        double cpuValue = cpuCard.getValue().getCardValue();

        if (playerValue > cpuValue) {
            winner = "Player wins!";
        } else if (playerValue == cpuValue) {
            winner = "It's a tie!";
        } else {
            winner = "Computer Player wins!";
        }

        return winner;
    }

    /**
     * Method to resolve a tie. Cards are drawn until one of the players has a 
     * card that is of higher value than their opponent. Calls the methods to
     * draw cards from each of the decks.Calls compareHands method to determine 
     * the winner of each pair of cards drawn.
     * 
     * @return String containing the winner, returned from compareHands()
     */
    public String tieBreaker() {
        Card pCard = drawPlayerCard();
        Card cpuCard = drawCpuCard();
        System.out.println("Player card: " + pCard);
        System.out.println("Computer card: " + cpuCard);

        while (pCard.getValue().getCardValue()
                == cpuCard.getValue().getCardValue()) {
            pCard = drawPlayerCard();
            cpuCard = drawCpuCard();
            System.out.println("Player card: " + pCard);
            System.out.println("Computer card: " + cpuCard);
        }

        String winner = compareHands(pCard, cpuCard);

        return winner;
    }

    /**
     * Method to update the score of whichever play has won the round
     * 
     * @param winner The winner of the round
     */
    public void updateScore(String winner) {
        if (winner.toLowerCase().equals("player wins!")) {
            player.addPoint();
        } else if (winner.toLowerCase().equals("computer player wins!")) {
            computer.addPoint();
        }
    }

    /**
     * Method to display the current score at the end of each round.
     */
    public void displayScore() {
        System.out.println("\nPlayer score: " + player.getScore());
        System.out.println("Computer score: " + computer.getScore());
    }
}
