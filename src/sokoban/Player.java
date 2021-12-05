package sokoban;
import java.awt.*;
import javax.swing.ImageIcon;

public class Player extends Actor {
    public Player(int x, int y) {
        super(x,y);
        initPlayer();
    }
    private void initPlayer() {
        ImageIcon icon = new ImageIcon("PLACEHOLDER");
        Image image = icon.getImage();
        setImage(image);
    }
    public void move(int x, int y) {
        int newX = getX() + x;
        int newY = getY() + y;
        setX(newX);
        setY(newY);
    }
}
