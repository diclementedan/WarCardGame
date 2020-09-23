/*
    HumanPlayer.java
    Author: Daniel Di Clemente
    Date: April 2020

    Description
    This class represents a human player. it extends the abstract class Player.
    It adds the datafield of name.
 */
package wargame;

/**
 *
 * @author Daniel Di Clemente
 */
public class HumanPlayer extends Player {
    
    private String name;

    /**
     * Constructor requiring the name players name. Places a call to the super
     * constructor.
     * 
     * @param name Player name
     */
    public HumanPlayer(String name) {
        super();
        this.name = name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }
}
