package sokoban.tiles;

public class PlayerOnGoal extends TileItem {
    public PlayerOnGoal() {
        super("src/res/images/PlayerOnGoal.png");
    }

    public PlayerOnGoal(String filename) {
        super(filename);
    }
    public TileType getTileType() {
        return TileType.PlayerOnGoal;
    }

    @Override
    public String toString() {
        return "+";
    }
}
