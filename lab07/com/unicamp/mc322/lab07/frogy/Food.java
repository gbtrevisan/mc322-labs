package com.unicamp.mc322.lab07.frogy;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Food extends MapItem {

    private final String name;
    private final Position position;

    protected Food(String icon, String name, Position position) {
        super(icon);
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(position, "position");
        this.name = name;
        this.position = position;
    }

    public abstract int givePoints();

    @Override
    public void interactWithFrog(Frog frog) {
        frog.eat(this);
    }

    @Override
    public ArrayList<Position> getPosition() {
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(position);
        return positions;
    }

    @Override
    public boolean isInPosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public String toString() {
        return "Name: " + name + " - Type: Food" + " - Icon: " + showIcon();
    }

}
