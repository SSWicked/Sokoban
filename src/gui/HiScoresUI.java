package gui;

import sokoban.HiScores;

import javax.swing.*;
import java.awt.*;

/**
 * HiScoresUI class extends JFrame, and is responsible for creating the gui for a HiScores Object.
 */
public class HiScoresUI extends JFrame {
    static JTable table;
    JScrollPane scrollPane;

    /**
     * Constructor for the UI
     * @param input - HiScores; gets a file as input
     */
    public HiScoresUI(HiScores input) {
        super("Hi-Scores");
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(400,400));
        table = new JTable(input);
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
