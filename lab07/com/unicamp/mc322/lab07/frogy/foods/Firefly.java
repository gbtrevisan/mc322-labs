package com.unicamp.mc322.lab07.frogy.foods;

import com.unicamp.mc322.lab07.frogy.Food;
import com.unicamp.mc322.lab07.frogy.Position;

public class Firefly extends Food {

    public Firefly(int x, int y) {
        super("Va", "Firefly", new Position(x, y));
    }

    @Override
    public int givePoints() {
        return 15;
    }

}
