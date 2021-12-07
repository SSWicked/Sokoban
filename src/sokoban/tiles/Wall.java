package sokoban.tiles;

public class Wall extends TileItem {
    public Wall() {
        super("src/res/images/Wall.png");
    }

    public Wall(String filename) {
        super(filename);
    }
    public TileType getTileType() {
        return TileType.Wall;
    }

    @Override
    public String toString() {
        return "#";
    }
}
