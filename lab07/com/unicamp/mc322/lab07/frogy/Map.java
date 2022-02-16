package com.unicamp.mc322.lab07.frogy;

import java.util.ArrayList;
import java.util.Objects;

public class Map {

    public final Icon FREE_SPACE_ICON = new Icon("--");
    public final String SPACE_BETWEEN_ICONS = "  ";

    private final int height;
    private final int width;
    private final ArrayList<MapItem> mapItems;
    private Frog frog;

    public Map(int height, int width) {
        if (height < 1 || width < 1) throw new RuntimeException("Not a valid map!");

        this.height = height;
        this.width = width;
        mapItems = new ArrayList<>();
        frog = null;
    }

    private Position middle() {
        return new Position(width / 2, height / 2);
    }

    void insertFrog(Frog frog) {
        this.frog = frog;
        if (positionIsFree(frog.getPosition()))
            this.frog = frog;
        else frog.defineInitialPosition(middle());
    }

    private boolean positionIsFree(ArrayList<Position> positions) {
        for (MapItem item : mapItems)
            if (item.isInPosition(positions))
                return false;
        return true;
    }

    private boolean supports(ArrayList<Position> positions) {
        for (Position position : positions)
            if (position.getX() >= width && position.getY() >= height)
                return false;
        return true;
    }

    private MapItem search(ArrayList<Position> positions) {
        for (MapItem mapItem : mapItems)
            if (mapItem.isInPosition(positions))
                return mapItem;
        return null;
    }

    private MapItem search(Position position) {
        for (MapItem mapItem : mapItems)
            if (mapItem.isInPosition(position))
                return mapItem;
        return null;
    }

    public void insertItem(MapItem mapItem) {
        if (positionIsFree(mapItem.getPosition()))
            mapItems.add(mapItem);
    }

    protected void update() {
        ArrayList<Position> frogPosition = frog.getPosition();
        if (!supports(frogPosition))
            frog.die();
        MapItem mapItem = search(frogPosition);
        if (mapItem != null) {
            mapItem.interactWithFrog(frog);
            mapItems.remove(mapItem);
        }
    }

    protected String render() {
        StringBuilder renderedMap = new StringBuilder();
        MapItem mapItem;
        for (int j = height - 1; j >= 0; j--) {
            for (int i = 0; i < width - 1; i++) {
                if (frog.isInPosition(new Position(i, j)))
                    renderedMap.append(frog.showIcon()).append(SPACE_BETWEEN_ICONS);
                else {
                    mapItem = search(new Position(i, j));
                    if (mapItem == null)
                        renderedMap.append(FREE_SPACE_ICON).append(SPACE_BETWEEN_ICONS);
                    else renderedMap.append(mapItem.showIcon()).append(SPACE_BETWEEN_ICONS);
                }
            }
            renderedMap.append("\n");
        }
        return renderedMap.toString();
    }

}
