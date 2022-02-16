package com.unicamp.mc322.lab12.game.engine.types.text;

import com.unicamp.mc322.lab12.game.elements.*;
import com.unicamp.mc322.lab12.game.engine.types.LabyrinthObjectVisitor;

import java.util.Arrays;

class TextRenderManager implements LabyrinthObjectVisitor {

    private final char[][] charMap;

    TextRenderManager(int mapWidth, int mapHeight) {
        this.charMap = new char[mapHeight][mapWidth];
    }

    public void render(LabyrinthMap labyrinthMap) {
        clearMap();
        labyrinthMap.accept(this);
        printMap();
    }

    private void clearMap() {
        for (char[] chars : charMap) {
            Arrays.fill(chars, ' ');
        }
    }

    private void printMap() {
        for (char[] chars : charMap) {
            for (char character : chars) {
                System.out.print(character + " ");
            }

            System.out.println();
        }
    }

    private void setSymbol(LabyrinthObject labyrinthObject, char character) {
        charMap[labyrinthObject.getY()][labyrinthObject.getX()] = character;
    }


    @Override
    public void visit(Player player) {
        setSymbol(player, 'J');
    }

    @Override
    public void visit(Wall wall) {
        setSymbol(wall, 'X');
    }

    @Override
    public void visit(Checkpoint checkpoint) {
        if (checkpoint.isConquered()) {
            setSymbol(checkpoint, 'T');
        } else {
            setSymbol(checkpoint, 'C');
        }
    }

}
