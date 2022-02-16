package com.unicamp.mc322.lab07.frogy.obstacles;

import com.unicamp.mc322.lab07.frogy.Obstacle;
import com.unicamp.mc322.lab07.frogy.Position;

import java.util.ArrayList;
import java.util.Objects;

public class Rock extends Obstacle {

    private final Position position;

    public Rock(Position position) {
        super("<>", "Rock");
        Objects.requireNonNull(position);
        this.position = position;
    }

    @Override
    public boolean isInPosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public ArrayList<Position> getPosition() {
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(position);
        return positions;
    }

}
