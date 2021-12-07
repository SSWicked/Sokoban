package sokoban.tiles;

/**
 * Enum, that enumerates the possible TileTypes.
 * Later business logics use this structure.
 */
public enum TileType {
    Wall,
    Path,
    Goal,
    Box,
    BoxOnGoal,
    PlayerOnGoal,
    Player,
    None
}
