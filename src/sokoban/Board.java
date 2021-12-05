package sokoban;

public class Board {
    public int[][] boardMatrix, goalMatrix;
    public Coordinates boardCoords = new Coordinates();
    public Coordinates Player      = new Coordinates();

    public Board() {
        boardCoords.setX(0);
        boardCoords.setY(0);
        Player.setX(0);
        Player.setY(0);
    }
    public Coordinates getPlayer() {
        return Player;
    }
}
