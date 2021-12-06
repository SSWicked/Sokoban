package sokoban.tiles;

import javax.swing.*;
import java.awt.*;

public class TileItem {
    private Image image;

    public TileItem(String filename) {
        initItem(filename);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void initItem(String filename) {
        ImageIcon icon = new ImageIcon(filename);
        Image image = icon.getImage();
        setImage(image);
    }

    public boolean isBox() {
        return false;
    }
}
