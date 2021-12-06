package sokoban;

import sokoban.tiles.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameLogic extends KeyAdapter {

    private final boolean isFinished = false;
    private String levelName;
    private Board board;
    private final TileItem BoxOnGoal = new BoxOnGoal();
    private final TileItem Wall = new Wall();
    private final TileItem Goal = new Goal();
    private final TileItem Box = new Box();
    private final TileItem Path = new Path();
    private final TileItem Player = new Player();
    private final TileItem PlayerOnGoal = new PlayerOnGoal();

    public GameLogic() {
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int countBox(Board board) {
        int counter = 0;
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                if (TileType.Box.equals(board.getBoardElements()[i][j].getTileType()))
                    counter++;
            }
        }
        return counter;
    }

    public Coord moveLogic(KeyEvent e, Board board, Coord posPlayer) {
        if (isFinished()) {
            return null;
        }

        Coord move = new Coord();
        Coord player = new Coord();
        player.setX(posPlayer.getX());
        player.setY(posPlayer.getY());
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_LEFT:
                move.setX(-1);
                move.setY(0);
                break;

            case KeyEvent.VK_RIGHT:
                move.setX(1);
                move.setY(0);
                break;

            case KeyEvent.VK_DOWN:
                move.setX(0);
                move.setY(1);
                break;

            case KeyEvent.VK_UP:
                move.setX(0);
                move.setY(-1);
                break;

            case KeyEvent.VK_R:
                return player; ///MAJD implement restartBoard();
            default:
                return player;
        }
        Coord newPosition = new Coord();
        newPosition.setX(player.getX() + move.getX());
        newPosition.setY(player.getY() + move.getY());
        TileItem[][] boardElements = board.getBoardElements();

        if (!TileType.Wall.equals(boardElements[newPosition.getY()][newPosition.getX()].getTileType())) {

            if (TileType.Box.equals(boardElements[newPosition.getY()][newPosition.getX()].getTileType()) || TileType.BoxOnGoal.equals(boardElements[newPosition.getY()][newPosition.getX()].getTileType())) {

                if (TileType.Box.equals(boardElements[newPosition.getY() + move.getY()][newPosition.getX() + move.getY()].getTileType())
                        || TileType.Wall.equals(boardElements[newPosition.getY() + move.getY()][newPosition.getX() + move.getX()].getTileType())
                        || TileType.BoxOnGoal.equals(boardElements[newPosition.getY() + move.getY()][newPosition.getX() + move.getX()].getTileType())) {
                    return player;
                } else {
                    boardElements[newPosition.getY() + move.getY()][newPosition.getX() + move.getX()] = TileType.Goal.equals(boardElements[newPosition.getY() + move.getY()][newPosition.getX() + move.getX()].getTileType()) ? BoxOnGoal : Box;
                    boardElements[newPosition.getY()][newPosition.getX()] = TileType.BoxOnGoal.equals(boardElements[newPosition.getY()][newPosition.getX()].getTileType()) ? Goal : Path;
                }
            }
            boardElements[player.getY()][player.getX()] = TileType.Player.equals(boardElements[player.getY()][player.getX()].getTileType()) ? Path : Goal;
            player.setX(newPosition.getX());
            player.setY(newPosition.getY());

            if (TileType.Path.equals(boardElements[newPosition.getY()][newPosition.getX()].getTileType())) {
                boardElements[player.getY()][player.getX()] = Player;
            } else if (TileType.Goal.equals(boardElements[newPosition.getY()][newPosition.getX()].getTileType())) {
                boardElements[player.getY()][player.getX()] = PlayerOnGoal;
            }
        }
        return player;
    }

    public boolean isFinished() {
        return board.getNumBox() == 0;
    }
}
