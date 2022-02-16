package com.unicamp.mc322.lab12.game.elements;

import com.unicamp.mc322.lab12.game.engine.types.LabyrinthObjectVisitor;

public class Wall extends LabyrinthObject {

    Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }

}
