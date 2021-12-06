package gui;

import javax.swing.*;
import java.awt.*;

public class levelSelectorScreen extends JPanel {

    public levelSelectorScreen() {
        //construct preComponents
        String[] jcomp1Items = {"1. Getting started", "2. Practice makes perfect", "3. You fell for it", "4. Today we make history", "5. Have you seen my dog", "6. Practice, practice, practice", "7. Like the evil", "8. Eighty percent", "9. Perfectionist"};

        //construct components
        JList<String> jcomp1 = new JList<>(jcomp1Items);
        JButton jcomp2 = new JButton("Start Game");
        JLabel jcomp3 = new JLabel("Level Selector");
        JTextArea jcomp4 = new JTextArea(10, 2);
        JButton jcomp5 = new JButton("Back");

        //adjust size and set layout
        setPreferredSize(new Dimension(944, 574));
        BorderLayout layout = new BorderLayout(40, 0);
        setLayout(layout);

        //add components
        add(jcomp1, BorderLayout.CENTER);
        add(jcomp2, BorderLayout.SOUTH);
        add(jcomp3, BorderLayout.NORTH);
        add(jcomp4, BorderLayout.EAST);
        add(jcomp5, BorderLayout.WEST);
    }
}

