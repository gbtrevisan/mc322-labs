package com.unicamp.mc322.lab07.frogy.frogs;

import com.unicamp.mc322.lab07.frogy.Food;
import com.unicamp.mc322.lab07.frogy.Frog;
import com.unicamp.mc322.lab07.frogy.Position;

import java.util.ArrayList;

public class TomatoFrog extends Frog {

    public final double POINTS_INCREASE_RATE = 0.1;

    private Position lastPosition;
    private Position currentPosition;
    private int points;

    public TomatoFrog(Position position) {
        super(")(", "Tomato");
        lastPosition = position;
        currentPosition = position;
        points = 0;
    }

    private int jump(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    private void move(Position position) {
        lastPosition = currentPosition;
        currentPosition = position;
    }

    @Override
    protected void eat(Food food) {
        points = (int) (points + food.givePoints() * (1 + POINTS_INCREASE_RATE));
    }

    @Override
    public void moveForward() {
        move(currentPosition.incrementY(jump(2, 3)));
    }

    @Override
    public void moveBackwards() {
        move(currentPosition.incrementY(-jump(1, 4)));
    }

    @Override
    public void moveRight() {
        move(currentPosition.incrementX(jump(1, 3)));
    }

    @Override
    public void moveLeft() {
        move(currentPosition.incrementX(-jump(1, 3)));
    }

    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public ArrayList<Position> getPosition() {
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(currentPosition);
        return positions;
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
