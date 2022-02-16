package com.unicamp.mc322.lab07.frogy.foods;

import com.unicamp.mc322.lab07.frogy.Food;
import com.unicamp.mc322.lab07.frogy.Position;

public class Cricket extends Food {

    public Cricket(int x, int y) {
        super("Gr", "Cricket", new Position(x, y));
    }

    @Override
    public int givePoints() {
        return 20;
    }

}
