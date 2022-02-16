package com.unicamp.mc322.lab10.pidao;

public class Position {

    private final double x;
    private final double y;

    public Position(double xAxis, double yAxis) {
        x = xAxis;
        y = yAxis;
    }

    public double distance(Position otherPosition) {
        return Math.sqrt(Math.pow((x - otherPosition.x), 2) + Math.pow((y - otherPosition.y), 2));
    }

}
