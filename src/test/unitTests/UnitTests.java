package unitTests;

import org.junit.Before;
import org.junit.Test;
import sokoban.*;
import gui.*;
import static org.junit.Assert.*;

public class UnitTests {

    Board board;
    Coord player;
    GameLogic gameLogic;

    @Before
    public void beforeTests() {
        board = new Board();
        player = new Coord(5,3);
        gameLogic = new GameLogic();
    }

    @Test
    public void main() {
        Menu menu = new Menu();
        assertNotNull(menu);
    }
    @Test
    public void LevelSelectorScreen() {
        LevelSelectorScreen lss = new LevelSelectorScreen();
        assertNotNull(lss);
    }
    @Test
    public void setPosX() {
        player.setX(2);
        assertEquals(2,player.getX(),0);
    }
    @Test
    public void boardWidth() {
        board.setWidth(7);
        board.setWidth(8);
        int size = board.getWidth();
        assertNotEquals(7, size);
    }
    @Test
    public void playerSetting() {
        Coord newPlace = new Coord(1,1);
        board.setPlayer(newPlace);
        assertEquals(1,board.getPlayer().getX());
    }
}
