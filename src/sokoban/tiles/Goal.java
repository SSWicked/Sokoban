package sokoban.tiles;
/**
 * Class for goals in the file.
 * Inherited from TileItem.
 */
public class Goal extends TileItem {
    /**
     * Default constructor for a Goal Object.
     * By filename it gets an Image which is used in the graphic interfaces.
     */
    public Goal() {
        super("src/res/images/GoalOnTile.png");
    }

    /**
     * Constructor that has a parameter with which the program is able to use the Image.
     * @param filename - name of an Image
     */
    public Goal(String filename) {
        super(filename);
    }

    /**
     * Basic getter for Goal Object.
     * @return - returns the TileType (Goal) of a Goal Object
     */
    public TileType getTileType() {
        return TileType.Goal;
    }

    /**
     * Overridden toString method, for comparison logic.
     * @return - returns a String for a Goal (.)
     */
    @Override
    public String toString() {
        return ".";
    }
}
