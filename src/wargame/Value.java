/*
    Value.java
    Author: Daniel Di Clemente
    Date: April 2020

    Description
    Enumeration for the possible values of a card in a standard deck.
 */
package wargame;

/**
 *
 * @author Daniel Di Clemente
 */
public enum Value {

    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace", 14);

    private String cardName;
    private double cardValue;

    /**
     * private constructor to build each Constant in the enumeration
     * 
     * @param cardName
     * @param cardValue 
     */
    private Value(String cardName, double cardValue) {
        this.cardName = cardName;
        this.cardValue = cardValue;
    }

    /**
     * Retrieves the name of the card value as a String
     * 
     * @return String containing the name of the card
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Retrieves the value of the card as an integer
     * 
     * @return Card value in integer form
     */
    public double getCardValue() {
        return cardValue;
    }

    /**
     * Overrides default toString() method
     * 
     * @return the name of the card in String form
     */
    @Override
    public String toString() {
        return cardName;
    }
    
    
}
