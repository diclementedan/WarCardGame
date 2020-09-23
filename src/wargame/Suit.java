/*
    Suit.java
    Author: Daniel Di Clemente
    Date: April 2020

    Description
    Enumeration clas for the possible suits of a card in a standard deck
 */
package wargame;

/**
 *
 * @author Daniel Di Clemente
 */
public enum Suit {

    SPADES("Spades", '\u2660'),
    HEARTS("Hearts", '\u2665'),
    DIAMONDS("Diamonds", '\u2666'),
    CLUBS("Clubs", '\u2663');

    private String suitName;
    private char suitSymbol;

    /**
     * Private constructor to build each constant in the enumeration
     * 
     * @param suitName String name of the suit
     * @param suitSymbol Unicode symbol for the suit
     */
    private Suit(String suitName, char suitSymbol) {
        this.suitName = suitName;
        this.suitSymbol = suitSymbol;
    }

    /**
     * Retrieves the name of the suit as a String
     * 
     * @return String containing the suit name
     */
    public String getSuitName() {
        return suitName;
    }

    /**
     * Retrieves the Unicode symbol for the suit
     * 
     * @return character representation of the suit as a Unicode character
     */
    public char getSuitSymbol() {
        return suitSymbol;
    }

    /**
     * Overrides default toString()
     * 
     * @return String containing the Unicode character for the suit
     */
    @Override
    public String toString() {
        return suitSymbol + "";
    }
    
    
}
