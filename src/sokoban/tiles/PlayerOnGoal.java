package sokoban.tiles;
/**
 * Class for a player that is on a goal tile in the file.
 * Inherited from TileItem.
 */
public class PlayerOnGoal extends TileItem {
    /**
     * Default constructor for a PlayerOnGoal Object.
     * By filename, it gets an Image which is used in the graphic interfaces.
     */
    public PlayerOnGoal() {
        super("src/res/images/PlayerOnGoal.png");
    }
    /**
     * Constructor that has a parameter with which the program is able to use the Image.
     * @param filename - name of an Image
     */
    public PlayerOnGoal(String filename) {
        super(filename);
    }
    /**
     * Basic getter for PlayerOnGoal Object.
     * @return - returns the TileType (PlayerOnGoal) of a PlayerOnGoal Object
     */
    public TileType getTileType() {
        return TileType.PlayerOnGoal;
    }
    /**
     * Overridden toString method, for comparison logic.
     * @return - returns a String for a PlayerOnGoal ("+")
     */
    @Override
    public String toString() {
        return "+";
    }
}
