package com.unicamp.mc322.lab10;

import com.unicamp.mc322.lab10.pidao.FoodApp;
import com.unicamp.mc322.lab10.pidao.restaurant.DeliveryOrder;
import com.unicamp.mc322.lab10.pidao.restaurant.Meal;
import com.unicamp.mc322.lab10.pidao.restaurant.Menu;
import com.unicamp.mc322.lab10.pidao.restaurant.Restaurant;
import com.unicamp.mc322.lab10.pidao.restaurant.discounts.MoneyDiscount;

import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        FoodApp pidao = new FoodApp();

        Menu menu = new Menu();
        menu.add(new Meal("Strogonoff", 20), "STRGF");
        menu.add(new Meal("Peixe grelhado", 20), "PXGRL");
        menu.applyDiscount("STRGF", new MoneyDiscount(5));

        pidao.subscribe(new Restaurant("Marmitas Delivery", "00.998.786/4221-90", menu, 0, 0));

        pidao.subscribe("Jose da Silva","931-312-450-00", 5, 7);

        pidao.subscribe("Carla Luiza","931-313-513-00", 0, 5);

        ArrayList<String> meals = new ArrayList<>();
        meals.add("STRGF");

        pidao.assignDeliveryMen("931-313-513-00", "00.998.786/4221-90");

        pidao.makeOrder(new DeliveryOrder(meals), "931-312-450-00", "00.998.786/4221-90");

        pidao.updateOrder("00.998.786/4221-90", "931-312-450-00");
        pidao.updateOrder("00.998.786/4221-90", "931-312-450-00");
        pidao.updateOrder("00.998.786/4221-90", "931-312-450-00");

        pidao.showMenu("00.998.786/4221-90");

        pidao.showOrders();
    }

}
