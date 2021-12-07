package sokoban;

import sokoban.tiles.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * GameLogic class, responsible for the most important logic implementations such as moves.
 * Connects the UI and the File process basically.
 */
public class GameLogic extends KeyAdapter {

    private final TileItem BoxOnGoal = new BoxOnGoal();
    private final TileItem Goal = new Goal();
    private final TileItem Box = new Box();
    private final TileItem Path = new Path();
    private final TileItem Player = new Player();
    private final TileItem PlayerOnGoal = new PlayerOnGoal();
    private Board board;
    private int steps = 0;

    /**
     * Default constructor for a GameLogic Object.
     */
    public GameLogic() {
    }

    /**
     * Getter for a gameLogic's board.
     * @return - returns a Board Object
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Setter for a gameLogic's board
     * @param board - Sets the parametric board as the new value of the gameLogic's board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Method which counts the Box Object on an opened Board.
     * @param board - Opened board, that is the game currently played on
     * @return - returns an int, representing the number of boxes not on goals.
     */
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

    /**
     * Most important method of the program.
     * Responsible for all the operations on a Board Object.
     * @param e - KeyEvent, is responsible for all keyboard inputs
     * @param board - Gets the current Board Object, so it can alter the data
     * @return - returns a coordinate, so the player's position is known for the next "iteration" of the gameloop
     */
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

    /**
     * Method that checks whether the number of boxes that are not on goals equal 0.
     * @return - true/false depending on the value of the comparison
     */
    public boolean isFinished() {
        return this.countBox(board) == 0;
    }

    /**
     * Getter for the steps made, so it can be updated
     * @return - an int, representing the number of steps made
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Setter for steps variable, so it can be "iterated" during a loop.
     * @param steps - the previous value of the variable
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }
}
