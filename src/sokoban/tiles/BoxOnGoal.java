package sokoban.tiles;

public class BoxOnGoal extends TileItem {
    public BoxOnGoal() {
        super("src/res/images/goalBox.png");
    }

    public BoxOnGoal(String filename) {
        super(filename);
    }
    public TileType getTileType() {
        return TileType.BoxOnGoal;
    }

    @Override
    public String toString() {
        return "*";
    }
}
