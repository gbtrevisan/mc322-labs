package com.unicamp.mc322.lab07.frogy.obstacles;

import com.unicamp.mc322.lab07.frogy.Obstacle;
import com.unicamp.mc322.lab07.frogy.Position;

import java.util.ArrayList;
import java.util.Objects;

public class Trap extends Obstacle {

    private final ArrayList<Position> positions;

    public Trap(Position position1, Position position2, Position position3) {
        super("{ }", "Trap");
        Objects.requireNonNull(position1, "position");

        positions = new ArrayList<>();
        positions.add(position1);

        if (position2 != null)
            positions.add(position2);
        if (position3 != null)
            positions.add(position3);

        validateTrap();
    }

    public Trap(Position position1, Position position2) {
        this(position1, position2, null);
    }

    public Trap(Position position) {
        this(position, null, null);
    }

    private void validateTrap() {
        for (Position position1 : positions)
            for (Position position2 : positions)
                if (position1.manhattanDistance(position2) > 2)
                    throw new RuntimeException("Not a valid trap!");
    }

    @Override
    public boolean isInPosition(Position position) {
        for (Position trapPosition : positions)
            if (trapPosition.equals(position))
                return true;
        return false;
    }

    @Override
    public ArrayList<Position> getPosition() {
        return positions;
    }

}
