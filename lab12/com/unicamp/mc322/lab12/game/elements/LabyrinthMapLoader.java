package com.unicamp.mc322.lab12.game.elements;

public class LabyrinthMapLoader {

    private static LabyrinthMapLoader instance;

    private LabyrinthMapLoader() {

    }

    public static LabyrinthMapLoader getInstance() {
        if (instance == null) {
            instance = new LabyrinthMapLoader();
        }

        return instance;
    }

    public LabyrinthMap loadDefaultMap() {
        return null;
    }

}
