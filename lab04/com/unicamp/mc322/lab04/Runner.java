package com.unicamp.mc322.lab04;

import com.unicamp.mc322.lab04.pidao.*;

public class Runner {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        Pidao pidaoApp = new Pidao("MARAMBAR", "123.456.789-10", 10, 2);

        User user1 = pidaoApp.registerUser("Marcos Paulo", "123.789.643-11", 1, 2);
        User user2 = pidaoApp.registerUser("Pereira", "223.790.843-11", 8, 4);

        Meal cuscuz = new Meal("CCZ00", "Cuscuz com ovo", 10.00);
        Meal macaxeira = new Meal("MXCOS", "Macaxeira com costela no bafo", 15.00);
        Meal coxinhaFrango = new Meal("CXFRA", "Coxinha de frango", 8.00);

        pidaoApp.addMealOption(cuscuz);
        pidaoApp.addMealOption(macaxeira);
        pidaoApp.addMealOption(coxinhaFrango);

        pidaoApp.applyDiscount("CCZ00", 10, DiscountType.PERCENTAGE);

        Order p1 = new Order(user1);
        p1.addMeal(cuscuz);
        p1.addMeal(macaxeira);
        pidaoApp.makeOrder(p1);

        Order p2 = new Order(user2);
        p2.addMeal(coxinhaFrango);
        p2.addMeal(coxinhaFrango);
        pidaoApp.makeOrder(p2);

        Order p3 = new Order(user2);
        p3.addMeal(coxinhaFrango);
        p3.addMeal(coxinhaFrango);
        pidaoApp.makeOrder(p3);

        pidaoApp.printMenu();

        pidaoApp.printOrders();
    }

}
