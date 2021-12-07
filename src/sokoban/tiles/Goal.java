package sokoban.tiles;

public class Goal extends TileItem {
    public Goal() {
        super("src/res/images/GoalOnTile.png");
    }

    public Goal(String filename) {
        super(filename);
    }
    public TileType getTileType() {
        return TileType.Goal;
    }

    @Override
    public String toString() {
        return ".";
    }
}
