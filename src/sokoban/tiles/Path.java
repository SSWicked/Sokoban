package sokoban.tiles;

public class Path extends TileItem {
    public Path() {
        super("src/res/images/Tile.png");
    }

    public Path(String filename) {
        super(filename);
    }

    public TileType getTileType() {
        return TileType.Path;
    }

    @Override
    public String toString() {
        return " ";
    }
}
