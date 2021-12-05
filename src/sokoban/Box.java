package sokoban;
import java.awt.*;
import javax.swing.ImageIcon;

public class Box extends Actor {
    public Box(int x, int y) {
        super(x,y);
        initBox();
    }
    private void initBox() {
        ImageIcon icon = new ImageIcon("PLACEHOLDER");
        Image image = icon.getImage();
        setImage(image);
    }
}
