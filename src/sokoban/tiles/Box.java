package sokoban.tiles;

/**
 * Class for boxes in the file.
 * Inherited from TileItem.
 */
public class Box extends TileItem {
    /**
     * Default constructor for a Box Object.
     * By filename it gets an Image which is used in the graphic interfaces.
     */
    public Box() {
        super("src/res/images/basicBox.png");
    }

    /**
     * Constructor that has a parameter with which the program is able to use the Image.
     * @param filename - name of an Image
     */
    public Box(String filename) {
        super(filename);
    }

    /**
     * Basic getter for Box Object.
     * @return - returns the TileType (Box) of a Box Object
     */
    public TileType getTileType() {
        return TileType.Box;
    }

    /**
     * Overridden toString method, for comparison logic.
     * @return - returns a String for a Box ($)
     */
    @Override
    public String toString() {
        return "$";
    }
}
