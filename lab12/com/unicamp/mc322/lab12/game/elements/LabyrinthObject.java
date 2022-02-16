package com.unicamp.mc322.lab12.game.elements;

import com.unicamp.mc322.lab12.game.engine.types.LabyrinthObjectVisitor;

public abstract class LabyrinthObject {

    private final Coordinate coordinate;

    LabyrinthObject(int x, int y) {
        coordinate = new Coordinate(x, y);
    }

    public int getX() {
        return coordinate.getX();
    }

    public int getY() {
        return coordinate.getY();
    }

    protected Coordinate getCoordinate() {
        return coordinate;
    }

    public boolean isSameCoordinates(int x, int y) {
        return coordinate.isSameCoordinates(x, y);
    }

    public boolean isSameCoordinates(LabyrinthObject labyrinthObject) {
        return this.getX() == labyrinthObject.getX() && this.getY() == labyrinthObject.getY();
    }

    public abstract void accept(LabyrinthObjectVisitor visitor);

}
