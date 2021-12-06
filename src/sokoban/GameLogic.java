package sokoban;

import sokoban.tiles.Box;

///TODO GAME LOGIC
public class GameLogic {

    private boolean isFinished = false;
    private String levelName;
    private Board board;

    public GameLogic() {
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int countBox(Board board, Box box) {
        int counter = 0;
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                if (board.getBoardElements()[i][j].isBox())
                    counter++;
            }
        }
        return counter;
    }

    public boolean isFinished(int numBox) {
        return board.getNumBox() == 0;
    }
}
