package com.unicamp.mc322.lab12.game.elements;

import com.unicamp.mc322.lab12.game.elements.exception.LabyrinthSizeException;
import com.unicamp.mc322.lab12.game.engine.types.LabyrinthObjectVisitor;

import java.util.ArrayList;
import java.util.Objects;

public class LabyrinthMap {

    public static final int MIN_WIDTH = 1;
    public static final int MIN_HEIGHT = 1;

    private final int width;
    private final int height;
    private final Player player;
    private final ArrayList<Checkpoint> checkpoints;
    private final ArrayList<Wall> walls;

    protected LabyrinthMap(int width, int height, Player player, ArrayList<Checkpoint> checkpoints, ArrayList<Wall> walls) {
        if (width < MIN_WIDTH) {
            throw new LabyrinthSizeException("Labyrinth have a min width of 1");
        }

        if (height < MIN_HEIGHT) {
            throw new LabyrinthSizeException("Labyrinth have a min height of 1");
        }

        Objects.requireNonNull(player, "Labyrinth player should not be null");
        Objects.requireNonNull(checkpoints, "Checkpoints list should not be null");
        Objects.requireNonNull(walls, "Walls list should not be null");

        this.width = width;
        this.height = height;
        this.player = player;
        this.checkpoints = checkpoints;
        this.walls = walls;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void conquerCheckpoint(Player player) {
        for (Checkpoint checkpoint : checkpoints) {
            if (checkpoint.isSameCoordinates(player)) {
                checkpoint.conquer();
            }
        }
    }

    public void updateMap(Direction direction) {
        if (direction != null) {
            player.move(direction, walls);
            conquerCheckpoint(player);
        }
    }

    public boolean isDone() {
        for (Checkpoint checkpoint : checkpoints) {
            if (!checkpoint.isConquered()) {
                return false;
            }
        }

        return true;
    }

    public void accept(LabyrinthObjectVisitor visitor) {
        for (Checkpoint checkpoint : checkpoints) {
            checkpoint.accept(visitor);
        }

        for (Wall wall : walls) {
            wall.accept(visitor);
        }

        player.accept(visitor);
    }

}
