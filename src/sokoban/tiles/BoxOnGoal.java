package sokoban.tiles;

/**
 * Class for boxes that are on a goal in the file.
 * Inherited from TileItem.
 */
public class BoxOnGoal extends TileItem {
    /**
     * Default constructor for a BoxOnGoal Object.
     * By filename it gets an Image which is used in the graphic interfaces.
     */
    public BoxOnGoal() {
        super("src/res/images/goalBox.png");
    }

    /**
     * Constructor that has a parameter with which the program is able to use the Image.
     * @param filename - name of an Image
     */
    public BoxOnGoal(String filename) {
        super(filename);
    }

    /**
     * Basic getter for BoxOnGoal Object.
     * @return - returns the TileType (BoxOnGoal) of a BoxOnGoal Object
     */
    public TileType getTileType() {
        return TileType.BoxOnGoal;
    }

    /**
     * Overridden toString method, for comparison logic.
     * @return - returns a String for a BoxOnGoal (*)
     */
    @Override
    public String toString() {
        return "*";
    }
}
