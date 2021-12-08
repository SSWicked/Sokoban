package sokoban;

import sokoban.tiles.TileItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Board class that is used for file processes.
 * Reads in a file and stores important data.
 */
public class Board {

    private Coord Player = new Coord();
    private int Width = 0;
    private int Height = 0;
    private TileItem[][] boardElements;

    /**
     * Default constructor for a Board Object.
     */
    public Board() {
    }

    /**
     * Constructor for a Board Object that gets a file as parameter.
     * Reads a file in, and creates a board instance which can be indexed.
     * @param levelName - name of the processed file
     * @throws IOException - Throws IOException in case of non-existent files
     */
    public Board(String levelName) throws IOException {
        String line;
        int x = 0;
        int y = 0;
        BufferedReader bufferedReader;

        File f = new File(levelName);

        FileReader fileReader = new FileReader(f);
        bufferedReader = new BufferedReader(fileReader);
        this.Width = Integer.parseInt(bufferedReader.readLine());
        this.Height = Integer.parseInt(bufferedReader.readLine());
        this.boardElements = new TileItem[Width][Height];
        while ((line = bufferedReader.readLine()) != null) {
            for (char tile : line.toCharArray()) {
                switch (tile) {
                    case '+', '@' -> {
                        this.Player.setX(x);
                        this.Player.setY(y);
                        boardElements[x][y] = TileFactory.createTile(tile);
                    }
                    case '\n' -> {
                    }
                    default -> boardElements[x][y] = TileFactory.createTile(tile);
                }
                x++;
            }
            x = 0;
            y++;
        }
    }

    /**
     * Getter for the Player Object on the board.
     * @return - returns the coordinates of a Player Object
     */
    public Coord getPlayer() {
        return Player;
    }

    /**
     * Setter for the Player Object on the board.
     * @param player - As a parameter given to the method, the coordinates of the
     *               Player are settable
     */
    public void setPlayer(Coord player) {
        Player = player;
    }

    /**
     * Getter for the board instance's height attribute.
     * @return - returns the height of a board object
     */
    public int getHeight() {
        return Height;
    }

    /**
     * Getter for the board instance's width attribute.
     * @return - returns the width of a board object.
     */
    public int getWidth() {
        return Width;
    }

    /**
     * Getter for the TileItem Array, in which, the program stores the TileTypes of a file.
     * @return - returns a TileItem[][] filled with Items cast from chars.
     */
    public TileItem[][] getBoardElements() {
        return boardElements;
    }

    /**
     * Setter for a Board Object's Width attribute.
     * @param width - integer; the size of the board considering the axis x
     */
    public void setWidth(int width) {
        Width = width;
    }

    /**
     * Setter for a Board Object's Height attribute.
     * @param height - integer; the size of the board considering the axis y
     */
    public void setHeight(int height) {
        Height = height;
    }
}
