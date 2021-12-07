package gui;

import sokoban.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * LevelSelectorScreen class that extends JFrame.
 * Responsible for creating the levelselector interface, where the player inputs their name, the name of the level and start the game.
 */
public class LevelSelectorScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Level");
    /**
     * Constructor for a LevelSelectorScreen.
     * Consists of 4 JButtons on a JPanel, and 2 JTextFields.
     */
    public LevelSelectorScreen() {
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setSize(800, 600);
        panel.setLayout(new GridLayout(2, 2));
        panel.setAlignmentX(CENTER_ALIGNMENT);

        JTextField name = new JTextField();
        JTextField level = new JTextField();
        JButton start = new JButton("Start Game");
        JButton back = new JButton("Back to Menu");
        start.setAlignmentX(LEFT_ALIGNMENT);
        back.setAlignmentX(LEFT_ALIGNMENT);
        start.addActionListener(e -> {
            name.getText();
            level.getText();
            try {
                Board played = new Board("src/res/" + level.getText() + ".txt");
                InGame.createGui(played, name.getText());
                frame.dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(getParent(), "Invalid input!");
            }
        });
        back.addActionListener(e -> {
            new Menu();
            frame.dispose();
        });

        panel.add(name);
        panel.add(level);
        panel.add(start);
        panel.add(back);
        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

