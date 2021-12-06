package gui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    public Menu() {
        //construct components
        JButton levelSelector = new JButton("Level Selector");
        JButton hiScores = new JButton("Hi-Scores");
        JButton quit = new JButton("Quit");

        //adjust size and set layout
        setPreferredSize(new Dimension(1000, 575));
        setLayout(null);

        //add components
        add(levelSelector);
        add(hiScores);
        add(quit);

        //set component bounds (only needed by Absolute Positioning)
        levelSelector.setBounds(175, 230, 225, 85);
        hiScores.setBounds(500, 230, 225, 85);
        quit.setBounds(340, 350, 225, 85);
    }
}

