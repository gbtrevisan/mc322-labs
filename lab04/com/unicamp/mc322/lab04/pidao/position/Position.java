package com.unicamp.mc322.lab04.pidao.position;

public class Position {

    private final int x;
    private final int y;

    public Position(int xAxis, int yAxis) {
        x = xAxis;
        y = yAxis;
    }

    public double distance(Position otherPosition) {
        return Math.sqrt(Math.pow(x - otherPosition.x, 2) +
                Math.pow(y - otherPosition.y, 2));
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Position copy() {
        return new Position(x, y);
    }

}
