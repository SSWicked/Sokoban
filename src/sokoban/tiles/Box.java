package sokoban.tiles;

public class Box extends TileItem {
    public Box() {
        super("src/res/images/basicBox.png");
    }

    public Box(String filename) {
        super(filename);
    }

    public boolean isBox() {
        return true;
    }
}
