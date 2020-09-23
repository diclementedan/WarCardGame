/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package wargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @modified Paul Bonenfant Jan 2020
 * @modified Daniel Di Clemente April 2020
 */
public class Deck {

    //The group of cards, stored in an ArrayList
    private final int size = 52;
    private ArrayList<wargame.Card> deck = new ArrayList(size);

    /**
     * The group of cards, stored in an ArrayList
     */
    private Collection<Card> cards;//the size of the grouping

    /**
     * No argument constructor
     */
    public Deck() {
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> generateDeck() {
        int countCards = 0;
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                deck.add((new Card(suit, value)));
                countCards++;
            }
        }
        return deck;
    }

    /**
     * Method to shuffle the list of Cards
     * 
     * @param deck The deck to be shuffled
     * @return The deck that has been shuffled
     */
    public ArrayList shuffle(ArrayList deck) {
        Collections.shuffle(deck);
        return deck;
    }

    /**
     * Retrieves the size of the group of Cards
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to get the cards in the collection
     * 
     * @return Collection of type Card
     */
    public Collection<Card> getCards() {
        return this.cards;
    }

}