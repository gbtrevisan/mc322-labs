package com.unicamp.mc322.lab12.game.elements;

public class Coordinate {

    private int x;
    private int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void changeCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isSameCoordinates(int x, int y) {
        return this.x == x && this.y == y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj instanceof Coordinate) {
            return ((Coordinate) obj).isSameCoordinates(x, y);
        }
        return false;
    }

}
