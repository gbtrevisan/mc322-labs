package com.unicamp.mc322.lab07.frogy;

import java.util.Objects;

public class Frogy {

    private final Frog frog;
    private final Map map;

    public Frogy(Frog frog, Map map) {
        Objects.requireNonNull(frog, "frog");
        Objects.requireNonNull(map, "map");
        this.frog = frog;
        this.map = map;
        map.insertFrog(frog);
    }

    public void run() {
        boolean exit = false;
        GameIO.displayWelcomeMessage();
        GameIO.displayTutorialMessage();

        while (frog.isAlive() && !exit) {
            GameIO.display(map.render());
            Command command = GameIO.nextCommand();

            switch (command) {
                case MOVE_FORWARD:
                    frog.moveForward();
                    break;
                case MOVE_BACKWARDS:
                    frog.moveBackwards();
                    break;
                case MOVE_RIGHT:
                    frog.moveRight();
                    break;
                case MOVE_LEFT:
                    frog.moveLeft();
                    break;
                case EXIT:
                    exit = true;
                    break;
            }

            map.update();
        }

        exit();
    }

    private void exit() {
        GameIO.display("Player Score:\n");
        GameIO.display(frog.status());
        GameIO.displayBlankLine();
        GameIO.displayGoodbyeMessage();
    }

}
