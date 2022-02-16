package com.unicamp.mc322.lab12.game.engine.types;

import com.unicamp.mc322.lab12.game.elements.Checkpoint;
import com.unicamp.mc322.lab12.game.elements.Player;
import com.unicamp.mc322.lab12.game.elements.Wall;

public interface LabyrinthObjectVisitor {

    void visit(Player player);

    void visit(Wall wall);

    void visit(Checkpoint checkpoint);

}
