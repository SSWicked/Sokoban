package sokoban;

import sokoban.tiles.*;

/**
 * TileFactory class.
 * Used for creating TileItems from chars.
 */
public class TileFactory {
    /**
     * The method sorts the different chars to their TileItems based on TileTypes.
     * @param tileType - char parameter, read in from the file
     * @return - returns a TileItem based on the switch's case
     */
    public static TileItem createTile(char tileType) {
        return switch (tileType) {
            case '#' -> new Wall();
            case '*' -> new BoxOnGoal();
            case ' ' -> new Path();
            case '.' -> new Goal();
            case '@' -> new Player();
            case '+' -> new PlayerOnGoal();
            case '$' -> new Box();
            default -> new Wall();
        };
    }
}
