
package sokoban;

/**
 * <p>Basic coordinate class to allow easy navigation in the used matrices </p>
 * @version 0.1
 */

public class Coordinates {
    public int x; //Private?
    public int y; //Private?

    public Coordinates(){
        x = 0;
        y = 0;
    }
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
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
}
