package gui;

import sokoban.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * InGame Class that extends JPanel.
 * This class implements the graphic methods for an in game state.
 */
public class InGame extends JPanel {
    private final GameLogic gameLogic = new GameLogic();
    private final JButton[][] buttons;
    private Coord newPlayerPos;
    /**
     * Constructor for an InGame Object
     * @param board - current board that this class generates the interface for
     * @param name - name of the player, needed for high scores
     */
    public InGame(Board board, String name) {

        setFocusable(true);
        gameLogic.setBoard(board);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameLogic.isFinished()) {
                    try {
                        (new HiScores()).addScore(name, gameLogic.getSteps());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                newPlayerPos = gameLogic.moveLogic(e, gameLogic.getBoard());
                gameLogic.countBox(gameLogic.getBoard());
                gameLogic.getBoard().setPlayer(newPlayerPos);
                gameLogic.setSteps(gameLogic.getSteps() + 1);
                refresh();
            }
        });
        buttons = new JButton[board.getHeight()][board.getWidth()];
        this.setLayout(new GridLayout(board.getHeight(), board.getWidth()));
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                buttons[y][x] = new JButton();
                this.add(buttons[y][x]);
            }
        }
        refresh();

    }

    /**
     * Method for creating the graphic interface of the game itself.
     * @param board - current Board Object read in from its file
     * @param name - name of the player, needed for high scores
     */
    public static void createGui(Board board, String name) {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Back");
        InGame panel = new InGame(board, name);
        JFrame frame = new JFrame("Sokoban");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        exit.addActionListener(e -> {
            new LevelSelectorScreen();
            frame.dispose();
        });
        file.add(exit);
        menuBar.add(file);
        frame.setJMenuBar(menuBar);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Method that updates the graphics, based on the logic implemented in gameLogic
     */
    public void refresh() {
        for (int x = 0; x < gameLogic.getBoard().getWidth(); x++) {
            for (int y = 0; y < gameLogic.getBoard().getHeight(); y++) {
                buttons[y][x].setIcon(new ImageIcon(gameLogic.getBoard().getBoardElements()[y][x].getImage()));
            }
        }
    }
}
