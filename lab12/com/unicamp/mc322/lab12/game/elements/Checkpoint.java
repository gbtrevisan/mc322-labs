package com.unicamp.mc322.lab12.game.elements;

import com.unicamp.mc322.lab12.game.engine.types.LabyrinthObjectVisitor;

public class Checkpoint extends LabyrinthObject {

    private boolean conquered;

    Checkpoint(int x, int y) {
        super(x, y);
        conquered = false;
    }

    @Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isConquered() {
        return conquered;
    }

    void conquer() {
        conquered = true;
    }

}
