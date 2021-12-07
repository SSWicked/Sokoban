package sokoban;

/**
 * Basic coordinate class.
 * This class helps navigation, and later business logic.
 */
public class Coord {
    private int posX;
    private int posY;

    /**
     * Default constructor for a Coord Object.
     * Sets the posX and posY variables to 0.
     */
    public Coord() {
        posX = 0;
        posY = 0;
    }

    /**
     * Constructor that enables the user to change the coordinates of the wanted Object.
     * @param x - parameter of the x-axis
     * @param y - parameter of the y-axis
     */
    public Coord(int x, int y) {
        posX = x;
        posY = y;
    }

    /**
     * Getter for a Coord Object's posX variable.
     * @return - returns the position of the Object on the x-axis
     */
    public int getX() {
        return posX;
    }

    /**
     * Setter for a Coord Object's posX variable.
     * @param x - Sets the parameter as the new value stored in posX.
     */
    public void setX(int x) {
        posX = x;
    }
    /**
     * Getter for a Coord Object's posY variable.
     * @return - returns the position of the Object on the y-axis
     */
    public int getY() {
        return posY;
    }
    /**
     * Setter for a Coord Object's posY variable.
     * @param y - Sets the parameter as the new value stored in posY.
     */
    public void setY(int y) {
        posY = y;
    }
}
