package sokoban;

import java.io.IOException;
import gui.*;

public class Main {
    public static void main(String[] args) {
        try {
            Board board = new Board("src/res/1.getting started.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
