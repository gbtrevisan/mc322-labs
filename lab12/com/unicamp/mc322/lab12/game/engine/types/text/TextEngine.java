package com.unicamp.mc322.lab12.game.engine.types.text;

import com.unicamp.mc322.lab12.game.elements.Direction;
import com.unicamp.mc322.lab12.game.elements.LabyrinthMap;
import com.unicamp.mc322.lab12.game.engine.GameEngine;

import java.util.Scanner;

public class TextEngine extends GameEngine {

    private final TextRenderManager renderManager;

    public TextEngine(LabyrinthMap labyrinthMap) {
        super(labyrinthMap);
        renderManager = new TextRenderManager(labyrinthMap.getWidth(), getLabyrinthMap().getHeight());
    }

    private Direction readCommandFromKeyboard(Scanner scanner) {
        String direction = scanner.next();

        switch (direction.toUpperCase()) {
            case "W":
                return Direction.UP;
            case "A":
                return Direction.LEFT;
            case "S":
                return Direction.DOWN;
            case "D":
                return Direction.RIGHT;
        }

        return Direction.UP;
    }

    @Override
    public void gameLoop() {
        Scanner scanner = new Scanner(System.in);
        LabyrinthMap map = getLabyrinthMap();
        Direction newDirection;

        while(!map.isDone()) {
            renderManager.render(map);
            newDirection = readCommandFromKeyboard(scanner);
            map.updateMap(newDirection);
        }

        System.out.println("Labirinto finalizado! Parabens");
        scanner.close();
    }

}
