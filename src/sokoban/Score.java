package sokoban;

import java.io.Serializable;

public record Score(String name, int steps) implements Serializable {
    public String getName() {
        return name;
    }

    public int getSteps() {
        return steps;
    }

}
