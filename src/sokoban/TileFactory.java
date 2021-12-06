package sokoban;

import sokoban.tiles.*;

public class TileFactory {
    public static TileItem createTile(char tileType) {
        return switch (tileType) {
            case '#' -> new Wall();
            case '*' -> new BoxOnGoal();
            case ' ' -> new Path();
            case '.' -> new Goal();
            case '@' -> new Player();
            case '+' -> new PlayerOnGoal();
            case '$' -> new Box();
            default -> new Wall();
        };
    }
}
