package com.unicamp.mc322.lab07;

import com.unicamp.mc322.lab07.frogy.Frog;
import com.unicamp.mc322.lab07.frogy.Frogy;
import com.unicamp.mc322.lab07.frogy.Map;
import com.unicamp.mc322.lab07.frogy.Position;
import com.unicamp.mc322.lab07.frogy.foods.Cricket;
import com.unicamp.mc322.lab07.frogy.foods.Firefly;
import com.unicamp.mc322.lab07.frogy.frogs.TomatoFrog;
import com.unicamp.mc322.lab07.frogy.obstacles.Predator;
import com.unicamp.mc322.lab07.frogy.obstacles.Rock;
import com.unicamp.mc322.lab07.frogy.obstacles.Trap;

public class Runner {

    public static void main(String[] args) {
        Map map = new Map(10, 10);

        map.insertItem(new Rock(new Position(2,7)));
        map.insertItem(new Rock(new Position(3,2)));
        map.insertItem(new Rock(new Position(7,1)));
        map.insertItem(new Rock(new Position(8,4)));
        map.insertItem(new Rock(new Position(8,8)));

        map.insertItem(new Predator(new Position(4, 4), new Position(5, 5)));

        map.insertItem(new Trap(new Position(0, 0), new Position(0, 1)));

        map.insertItem(new Firefly(1, 3));
        map.insertItem(new Cricket(4, 7));

        Frog player = new TomatoFrog(new Position(8 ,7));

        Frogy frogyGame = new Frogy(player, map);

        frogyGame.run();
    }

}
