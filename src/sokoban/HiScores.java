package sokoban;

import gui.HiScoresUI;
import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * High Scores class is responsible for storing game data.
 * Data(name and stepcount) is stored in a serialized .dat file.
 */
public class HiScores extends AbstractTableModel {

    private List<Score> scoreList = new ArrayList<>();

    /**
     * Constructor for a HiScores Object.
     * This is only whole with HiScoresUI only.
     */
    public HiScores() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("src/res/scores.dat"));
            scoreList = (List<Score>) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(scoreList == null){
            scoreList = new ArrayList<>();
        }
        fireTableDataChanged();
        HiScoresUI ui = new HiScoresUI(this);
        ui.setVisible(true);
    }

    /**
     * Adds a new Score to the HiScores List
     * @param playerName - String; name of the player (or whatever the input is)
     * @param steps - int; steps made to finish a game
     * @throws IOException
     */
    public void addScore(String playerName, int steps) throws IOException {
        scoreList.add(new Score(playerName,steps));
        fireTableDataChanged();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/res/scores.dat"));
        objectOutputStream.writeObject(getScoreList());
        objectOutputStream.close();
    }

    @Override
    public int getRowCount() {
        return scoreList.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Score score = scoreList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> score.getName();
            default -> score.getSteps();
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Name";
            default -> "Steps";
        };
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
