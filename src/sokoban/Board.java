package sokoban;

import sokoban.tiles.TileItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Board {

    private Coord Player = new Coord();
    private int Width = 0;
    private int Height = 0;
    private int numBox = 0;
    private TileItem[][] boardElements;

    public Board() {
    }

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
                    case '$' -> {
                        numBox++;
                        boardElements[x][y] = TileFactory.createTile(tile);
                    }
                    default -> boardElements[x][y] = TileFactory.createTile(tile);
                }
                x++;
            }
            x = 0;
            y++;
        }
    }

    public Coord getPlayer() {
        return Player;
    }

    public void setPlayer(Coord player) {
        Player = player;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getNumBox() {
        return numBox;
    }

    public void setNumBox(int numBox) {
        this.numBox = numBox;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public TileItem[][] getBoardElements() {
        return boardElements;
    }
}
