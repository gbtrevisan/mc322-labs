package com.unicamp.mc322.lab07.frogy.obstacles;

import com.unicamp.mc322.lab07.frogy.Obstacle;
import com.unicamp.mc322.lab07.frogy.Position;

import java.util.ArrayList;
import java.util.Objects;

public class Predator extends Obstacle {

    private final ArrayList<Position> positions;

    public Predator(Position position1, Position position2) {
        super("$$", "Predator");
        Objects.requireNonNull(position1, "position");
        Objects.requireNonNull(position2, "position");

        positions = new ArrayList<>();
        if (position1.isAdjacent(position2)) {
            positions.add(position1);
            positions.add(position2);
        } else throw new RuntimeException("Predator should have only adjacent positions");
    }

    @Override
    public boolean isInPosition(Position position) {
        for (Position predatorPosition : positions)
            if (predatorPosition.equals(position))
                return true;
        return false;
    }

    @Override
    public ArrayList<Position> getPosition() {
        return positions;
    }

}
