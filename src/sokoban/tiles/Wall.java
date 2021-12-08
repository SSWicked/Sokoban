package sokoban.tiles;
/**
 * Class for walls in the file.
 * Inherited from TileItem.
 */
public class Wall extends TileItem {
    /**
     * Default constructor for a Wall Object.
     * By filename, it gets an Image which is used in the graphic interfaces.
     */
    public Wall() {
        super("src/res/images/Wall.png");
    }
    /**
     * Constructor that has a parameter with which the program is able to use the Image.
     * @param filename - name of an Image
     */
    public Wall(String filename) {
        super(filename);
    }
    /**
     * Basic getter for Wall Object.
     * @return - returns the TileType (Wall) of a Wall Object
     */
    public TileType getTileType() {
        return TileType.Wall;
    }
    /**
     * Overridden toString method, for comparison logic.
     * @return - returns a String for a Wall (#)
     */
    @Override
    public String toString() {
        return "#";
    }
}
