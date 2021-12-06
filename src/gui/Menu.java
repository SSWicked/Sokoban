package gui;
//This is some basic shit about swing gui
///TODO WORK ON GUI
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    private final JMenuItem open = new JMenuItem("Open");
    private final JMenuItem cancel = new JMenuItem("Cancel");

    public Menu() {
        JFrame frame = new JFrame("Sokoban");
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");

        open.addActionListener(this);
        cancel.addActionListener(this);
        jMenu.add(open);
        jMenu.add(cancel);
        menuBar.add(jMenu);

        frame.setJMenuBar(menuBar);
        frame.setSize(300,100);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == open) {
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.showOpenDialog(null);
        }
        if(e.getSource() == cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Menu();
    }
}