package sokoban.tiles;

import javax.swing.*;
import java.awt.*;

/**
 * Parent Class for the specific tiles, that are used in the game.
 * Most methods are defined in the child classes.
 */
public class TileItem {

    private Image image;

    /**
     * Constructor that calls initItem.
     * @param filename - Absolute path for an Image
     */
    public TileItem(String filename) {
        initItem(filename);
    }

    /**
     * Getter for an Image.
     * @return - returns the item's Image.
     */
    public Image getImage() {
        return image;
    }

    /**
     * Setter for an Image.
     * @param image - Sets the image as the image attribute of the Item
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * Method that initializes an Item.
     * Sets the image basically.
     * @param filename - Absolute path to an image
     */
    public void initItem(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        Image image = icon.getImage();
        setImage(image);
    }

    /**
     * Getter for the tile's type
     * @return - returns a None tileType, as this doesn't exist in the game
     */
    public TileType getTileType() {
        return TileType.None;
    }

    /**
     * Overridden toString method, for comparison logic.
     * As this tileType shouldn't exist regarding the game it
     * @return - returns a String "rossz", meaning faulty in Hungarian.
     */
    public String toString() {
        return "rossz";
    }
}
