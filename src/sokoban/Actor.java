package sokoban;
import java.awt.*;

/**
 * <p>This class has 4 subclasses named, Player, Way, Wall and Box; which are
 * the basic elements of the Board.</p>
 * @version 0.1
 */
public class Actor {
    private final int size = 50;
    private int x,y;
    private Image image;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean isLeftCollision(Actor actor) {
        return getX()-size == actor.getX() && getY() == actor.getY();
    }
    public boolean isRightCollision(Actor actor) {
        return getX()+size == actor.getX() && getY() == actor.getY();
    }
    public boolean isTopCollision(Actor actor) {
        return getY()-size == actor.getY() && getX() == actor.getX();
    }
    public boolean isBottomCollision(Actor actor) {
        return getY()+size == actor.getY() && getX() == actor.getX();
    }
}
