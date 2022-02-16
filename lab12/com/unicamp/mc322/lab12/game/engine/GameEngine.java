package com.unicamp.mc322.lab12.game.engine;

import com.unicamp.mc322.lab12.game.elements.LabyrinthMap;
import com.unicamp.mc322.lab12.game.engine.exception.GameEngineException;

public abstract class GameEngine {

    private final LabyrinthMap labyrinthMap;

    public GameEngine(LabyrinthMap labyrinthMap) {
        if (labyrinthMap == null) {
            throw new GameEngineException("Labyrinth map should not be null");
        }

        this.labyrinthMap = labyrinthMap;
    }

    protected LabyrinthMap getLabyrinthMap() {
        return labyrinthMap;
    }

    public abstract void gameLoop();

}
