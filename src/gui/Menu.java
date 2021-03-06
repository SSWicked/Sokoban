package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Menu class, responsible for the graphic implementation of the main Menu.
 * There are 2 JButtons on this interface; a Start game and an Exit.
 * Apart from that it shows the name of the game (Sokoban) as a title.
 */
public class Menu extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame("Sokoban");

    /**
     * Constructor for a Menu.
     * Sets the needed attributes, and initializes the game.
     */

    public Menu() {
        //Frame
        frame.setSize(800, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Panel
        JPanel panel = new JPanel();
        panel.setSize(800, 400);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //Title
        JLabel sokoTitle = new JLabel("Sokoban");
        sokoTitle.setFont(new Font("Monospaced", (Font.BOLD + Font.ITALIC), 64));
        sokoTitle.setAlignmentX(CENTER_ALIGNMENT);

        //Buttons (start, hiscores, exit)
        JButton start = new JButton("Level Select");
        start.setAlignmentX(CENTER_ALIGNMENT);
        start.addActionListener(e -> {
            new LevelSelectorScreen();
            frame.dispose();
        });
        JButton exit = new JButton("Exit Game");
        exit.setAlignmentX(CENTER_ALIGNMENT);
        exit.addActionListener(e -> System.exit(0));

        //Adding everything to the JPanel
        panel.add(sokoTitle);
        panel.add(Box.createRigidArea(new Dimension(20, 80)));
        panel.add(start);
        panel.add(Box.createRigidArea(new Dimension(20, 40)));
        panel.add(exit);
        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}