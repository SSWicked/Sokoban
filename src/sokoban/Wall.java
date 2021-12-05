package sokoban;
import java.awt.*;
import javax.swing.ImageIcon;

public class Wall extends Actor {
    public Wall(int x, int y) {
        super(x,y);
        initWall();
    }
    private void initWall() {
        ImageIcon icon = new ImageIcon("PLACEHOLDER");
        Image image = icon.getImage();
        setImage(image);
    }
}
