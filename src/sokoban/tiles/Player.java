package sokoban.tiles;

public class Player extends TileItem {
    public Player() {
        super("src/res/images/player.png");
    }

    public Player(String filename) {
        super(filename);
    }
    public TileType getTileType() {
        return TileType.Player;
    }

    @Override
    public String toString() {
        return "@";
    }
}
