package com.unicamp.mc322.lab07.frogy;

public abstract class Frog extends MapItem {

    private final String name;
    private boolean alive = true;

    public Frog(String icon, String name) {
        super(icon);
        this.name = name;
    }

    public abstract int getPoints();

    protected abstract void eat(Food food);

    protected void die() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public abstract void moveForward();

    public abstract void moveBackwards();

    public abstract void moveRight();

    public abstract void moveLeft();

    @Override
    public void interactWithFrog(Frog frog) {
        // multiplayer necessary
    }

    protected abstract void defineInitialPosition(Position position);

    protected String status() {
        StringBuilder status = new StringBuilder("Avatar: " + name + "\nType: Frog" + "\nHealth: ");
        if (alive)
            status.append("ALIVE\n");
        else
            status.append("DEAD\n");
        status.append("Score: ").append(getPoints());
        return status.toString();
    }

    @Override
    public String toString() {
        return "Name: " + name + " - Type: Frog" + " - Icon: " + showIcon();
    }

}
