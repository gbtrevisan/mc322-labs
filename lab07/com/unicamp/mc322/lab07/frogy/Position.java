package com.unicamp.mc322.lab07.frogy;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double euclideanDistance(Position otherPosition) {
        return Math.sqrt(Math.pow(x - otherPosition.x, 2) + Math.pow(y - otherPosition.y, 2));
    }

    public double manhattanDistance(Position position) {
        return Math.abs(x - position.x) + Math.abs(y - position.y);
    }

    public boolean isAdjacent(Position otherPosition) {
        return euclideanDistance(otherPosition) <= Math.sqrt(2);
    }

    public Position incrementX(int number) {
        return new Position(x + number, y);
    }

    public Position incrementY(int number) {
        return new Position(x, y + number);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof Position)
            return x == ((Position) other).x && y == ((Position) other).y;
        return false;
    }

}
