package sokoban;

public class Coord {
    private int posX;
    private int posY;

    public Coord() {
        posX = 0;
        posY = 0;
    }

    public Coord(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getX() {
        return posX;
    }

    public void setX(int x) {
        posX = x;
    }

    public int getY() {
        return posY;
    }

    public void setY(int y) {
        posY = y;
    }
}
