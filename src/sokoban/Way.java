package sokoban;
import java.awt.*;
import javax.swing.ImageIcon;

public class Way extends Actor {
    public Way(int x, int y) {
        super(x,y);
        initWay();
    }
    private void initWay() {
        ImageIcon icon = new ImageIcon("PLACEHOLDER");
        Image image = icon.getImage();
        setImage(image);
    }
}
