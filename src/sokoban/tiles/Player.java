package sokoban.tiles;
/**
 * Class for player in the file.
 * Inherited from TileItem.
 */
public class Player extends TileItem {
    /**
     * Default constructor for a Player Object.
     * By filename it gets an Image which is used in the graphic interfaces.
     */
    public Player() {
        super("src/res/images/player.png");
    }
    /**
     * Constructor that has a parameter with which the program is able to use the Image.
     * @param filename - name of an Image
     */
    public Player(String filename) {
        super(filename);
    }
    /**
     * Basic getter for Player Object.
     * @return - returns the TileType (Player) of a Player Object
     */
    public TileType getTileType() {
        return TileType.Player;
    }
    /**
     * Overridden toString method, for comparison logic.
     * @return - returns a String for a Player (@)
     */
    @Override
    public String toString() {
        return "@";
    }
}
