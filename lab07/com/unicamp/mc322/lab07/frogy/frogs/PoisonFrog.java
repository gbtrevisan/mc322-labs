package com.unicamp.mc322.lab07.frogy.frogs;

import com.unicamp.mc322.lab07.frogy.Direction;
import com.unicamp.mc322.lab07.frogy.Food;
import com.unicamp.mc322.lab07.frogy.Frog;
import com.unicamp.mc322.lab07.frogy.Position;

import java.util.ArrayList;
import java.util.Random;

public class PoisonFrog extends Frog {

    public final double POINTS_INCREASE_RATE = 0.2;
    public final int HIGHEST_JUMP = 4;
    public final int LOWEST_JUMP = 1;

    private Position lastPosition;
    private Position currentPosition;
    private int points;

    public PoisonFrog(Position position) {
        super("][", "Poison");
        lastPosition = position;
        currentPosition = position;
        points = 0;
    }

    private int jump() {
        return (int) (Math.random() * (HIGHEST_JUMP - LOWEST_JUMP) + LOWEST_JUMP);
    }

    private void move() {
        int random = (new Random()).nextInt(3);
        Direction direction = Direction.values()[random];

        switch (direction) {
            case FORWARD:
                move(currentPosition.incrementY(jump()));
                break;
            case BACKWARDS:
                move(currentPosition.incrementY(-jump()));
                break;
            case RIGHT:
                move(currentPosition.incrementX(jump()));
                break;
            case LEFT:
                move(currentPosition.incrementX(-jump()));
                break;
        }
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
        move();
    }

    @Override
    public void moveBackwards() {
        move();
    }

    @Override
    public void moveRight() {
        move();
    }

    @Override
    public void moveLeft() {
        move();
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
