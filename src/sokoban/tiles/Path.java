package sokoban.tiles;
/**
 * Class for paths in the file.
 * Inherited from TileItem.
 */
public class Path extends TileItem {
    /**
     * Default constructor for a Path Object.
     * By filename it gets an Image which is used in the graphic interfaces.
     */
    public Path() {
        super("src/res/images/Tile.png");
    }
    /**
     * Constructor that has a parameter with which the program is able to use the Image.
     * @param filename - name of an Image
     */
    public Path(String filename) {
        super(filename);
    }
    /**
     * Basic getter for Path Object.
     * @return - returns the TileType (Path) of a Path Object
     */
    public TileType getTileType() {
        return TileType.Path;
    }
    /**
     * Overridden toString method, for comparison logic.
     * @return - returns a String for a Path (" ")
     */
    @Override
    public String toString() {
        return " ";
    }
}
