package com.unicamp.mc322.lab07.frogy;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Obstacle extends MapItem {

    private final String name;

    public Obstacle(String icon, String name) {
        super(icon);
        Objects.requireNonNull(icon, "icon");
        Objects.requireNonNull(name, "name");
        this.name = name;
    }

    @Override
    public void interactWithFrog(Frog frog) {
        frog.die();
    }

    @Override
    public abstract boolean isInPosition(Position position);

    @Override
    public abstract ArrayList<Position> getPosition();

    @Override
    public String toString() {
        return "Name: " + name + " - Type: Obstacle" + " - Icon: " + showIcon();
    }

}

