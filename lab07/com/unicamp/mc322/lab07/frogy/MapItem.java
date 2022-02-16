package com.unicamp.mc322.lab07.frogy;

import java.util.ArrayList;
import java.util.Objects;

public abstract class MapItem {

    private final Icon icon;

    public MapItem(String icon) {
        Objects.requireNonNull(icon, "map icon");
        this.icon = new Icon(icon);
    }

    public Icon showIcon() {
        return icon;
    }

    public abstract ArrayList<Position> getPosition();

    public abstract boolean isInPosition(Position position);

    public boolean isInPosition(ArrayList<Position> positions) {
        for (Position position : positions)
            if (isInPosition(position))
                return true;
        return false;
    }

    public abstract void interactWithFrog(Frog frog);

}
