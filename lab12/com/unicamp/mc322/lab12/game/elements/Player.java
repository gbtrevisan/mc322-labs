package com.unicamp.mc322.lab12.game.elements;

import com.unicamp.mc322.lab12.game.engine.types.LabyrinthObjectVisitor;

import java.util.ArrayList;

public class Player extends LabyrinthObject {

    private Direction currentDirection;

    Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    private void move(Direction direction) {
        switch (direction) {
            case UP:
                getCoordinate().changeCoordinates(getX(), getY() + 1);
                break;
            case DOWN:
                getCoordinate().changeCoordinates(getX(), getY() - 1);
                break;
            case RIGHT:
                getCoordinate().changeCoordinates(getX() + 1, getY());
                break;
            case LEFT:
                getCoordinate().changeCoordinates(getX() - 1, getY());
        }
    }

    void move(Direction direction, ArrayList<Wall> walls) {
        boolean pathIsClear = true;

        for (Wall wall : walls) {
            if (wall.isSameCoordinates(this)) {
                pathIsClear = false;
            }
        }

        if (pathIsClear) {
            currentDirection = direction;
            move(direction);
        }
    }

}
