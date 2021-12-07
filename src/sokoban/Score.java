package sokoban;

import java.io.Serializable;

/**
 * A record that contains the name and the steps made of a player in a game.
 * Used for keeping score of high scores.
 */
public record Score(String name, int steps) implements Serializable {
    /**
     * Getter for the name of a player.
     * @return - returns a String, representing a player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the stepcount of a player in a game.
     * @return - returns an integer, representing a player's steps made
     */
    public int getSteps() {
        return steps;
    }

}
