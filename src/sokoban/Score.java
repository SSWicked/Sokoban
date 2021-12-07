package sokoban;

import java.io.Serializable;

public record Score(String name, String map, int steps) implements Serializable {
    public String getName() {
        return name;
    }

    public String getMap() {
        return map;
    }

    public int getSteps() {
        return steps;
    }

}
