package sokoban;

import sokoban.tiles.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameLogic extends KeyAdapter {

    private final boolean isFinished = false;
    private final TileItem BoxOnGoal = new BoxOnGoal();
    private final TileItem Wall = new Wall();
    private final TileItem Goal = new Goal();
    private final TileItem Box = new Box();
    private final TileItem Path = new Path();
    private final TileItem Player = new Player();
    private final TileItem PlayerOnGoal = new PlayerOnGoal();
    private String levelName;
    private Board board;
    private int steps = 0;

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

    public Coord moveLogic(KeyEvent e, Board board) {
        if (isFinished()) {
            return null;
        }

        Coord move = new Coord();
        Coord player = new Coord();
        player.setY(board.getPlayer().getY());
        player.setX(board.getPlayer().getX());

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

        if (!(TileType.Wall.toString().equals(boardElements[newPosition.getX()][newPosition.getY()].getTileType().toString()))) {

            if (TileType.Box.toString().equals(boardElements[newPosition.getX()][newPosition.getY()].getTileType().toString()) || TileType.BoxOnGoal.toString().equals(boardElements[newPosition.getX()][newPosition.getY()].getTileType().toString())) {

                if (TileType.Box.toString().equals(boardElements[newPosition.getX() + move.getX()][newPosition.getY() + move.getY()].getTileType().toString())
                        || TileType.Wall.toString().equals(boardElements[newPosition.getX() + move.getX()][newPosition.getY() + move.getY()].getTileType().toString())
                        || TileType.BoxOnGoal.toString().equals(boardElements[newPosition.getX() + move.getX()][newPosition.getY() + move.getY()].getTileType().toString())) {
                    return player;
                } else {
                    boardElements[newPosition.getX() + move.getX()][newPosition.getY() + move.getY()] = TileType.Goal.toString().equals(boardElements[newPosition.getX() + move.getX()][newPosition.getY() + move.getY()].getTileType().toString()) ? BoxOnGoal : Box;
                    boardElements[newPosition.getX()][newPosition.getY()] = TileType.BoxOnGoal.toString().equals(boardElements[newPosition.getX()][newPosition.getY()].getTileType().toString()) ? Goal : Path;
                }
            }
            boardElements[player.getX()][player.getY()] = TileType.Player.toString().equals(boardElements[player.getX()][player.getY()].getTileType().toString()) ? Path : Goal;
            player.setX(newPosition.getX());
            player.setY(newPosition.getY());

            if (TileType.Path.toString().equals(boardElements[newPosition.getX()][newPosition.getY()].getTileType().toString())) {
                boardElements[player.getX()][player.getY()] = Player;
            } else if (TileType.Goal.toString().equals(boardElements[newPosition.getX()][newPosition.getY()].getTileType().toString())) {
                boardElements[player.getX()][player.getY()] = PlayerOnGoal;
            }
        }
        return player;
    }

    public boolean isFinished() {
        return board.getNumBox() == 0;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
