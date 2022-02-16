package com.unicamp.mc322.lab07.frogy.frogs;

import com.unicamp.mc322.lab07.frogy.*;

import java.util.ArrayList;

public class GreenFrog extends Frog {

    private Position lastPosition;
    private Position currentPosition;
    private int points;

    public GreenFrog(Position position) {
        super("}{", "Green");
        lastPosition = position;
        currentPosition = position;
        points = 0;
    }

    private int jump() {
        return 1;
    }

    private void move(Position position) {
        lastPosition = currentPosition;
        currentPosition = position;
    }

    @Override
    protected void eat(Food food) {
        points = points + food.givePoints();
    }

    @Override
    public void moveForward() {
        move(currentPosition.incrementY(jump()));
    }

    @Override
    public void moveBackwards() {
        move(currentPosition.incrementY(-jump()));
    }

    @Override
    public void moveRight() {
        move(currentPosition.incrementX(jump()));
    }

    @Override
    public void moveLeft() {
        move(currentPosition.incrementX(-jump()));
    }

    @Override
    public int getPoints() {
        return  points;
    }

    @Override
    public ArrayList<Position> getPosition() {
        ArrayList<Position> position = new ArrayList<>();
        position.add(currentPosition);
        return position;
    }

    @Override
    public boolean isInPosition(Position position) {
        return currentPosition.equals(position);
    }

    @Override
    protected void defineInitialPosition(Position position) {
        move(position);
    }

}

