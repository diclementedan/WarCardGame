/**
 * SYST 17796 Project Winter 2020 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package wargame;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @modified Paul Bonenfant Jan 2020
 * @modified Daniel Di Clemente
 */
public abstract class Player {

    private int score;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player() {
        score = 0;
    }

    /**
     * Retrieves the score of the player
     * 
     * @return Player score in an int
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score of the player
     * 
     * @param score The score to be assigned to the player
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * Method to increase by 1 the players score
     */
    public void addPoint() {
        score++;
    }
}
