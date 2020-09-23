/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package wargame;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @modified Daniel Di Clemente April 2020
 */
public class Card {

    private final Suit suit;
    private final Value value;

    /**
     * Overloaded constructor to create a Card object.
     * 
     * @param suit Suit of the card
     * @param value Value of the card
     */
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    /**
     * Retrieves the value of the card
     * 
     * @return Value of the card as the constant from the enum
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * Retrieves the Suit of the card
     * 
     * @return Value of the card as the constant from the enum
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * Overrides the default toString method
     * 
     * @return the value enum toString concatenated with the suit enum toString
     */
    @Override
    public String toString() {
        return value.toString() + suit.toString();
    }

}
