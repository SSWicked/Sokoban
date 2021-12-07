package gui;

import sokoban.Board;
import sokoban.Coord;
import sokoban.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InGame extends JPanel{
    private Coord newPlayerPos;
    private final GameLogic gameLogic = new GameLogic();
    private final JButton[][] buttons;
    public InGame(Board board, String name) {
        setFocusable(true);
        gameLogic.setBoard(board);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                newPlayerPos = gameLogic.moveLogic(e, gameLogic.getBoard());
                gameLogic.getBoard().setPlayer(newPlayerPos);
                gameLogic.setSteps(gameLogic.getSteps()+1);
                refresh();
            }
        });
        buttons = new JButton[board.getHeight()][board.getWidth()];
        this.setLayout(new GridLayout(board.getHeight(),board.getWidth()));
        for (int x = 0; x < board.getWidth() ; x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                buttons[y][x] = new JButton();
                this.add(buttons[y][x]);
            }
        }
        refresh();

    }


    public void refresh() {
        for (int x= 0; x< gameLogic.getBoard().getWidth() ; x++) {
            for (int y = 0; y < gameLogic.getBoard().getHeight(); y++) {
                buttons[y][x].setIcon(new ImageIcon(gameLogic.getBoard().getBoardElements()[y][x].getImage()));
                System.out.print(gameLogic.getBoard().getBoardElements()[y][x].toString());
            }
            System.out.println();
        }

    }
    public static void createGui(Board board, String name) {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Back");
        InGame panel = new InGame(board,name);
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
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
