package com.unicamp.mc322.lab04.pidao;

import com.unicamp.mc322.lab04.pidao.position.Position;
import com.unicamp.mc322.lab04.pidao.restaurant.Restaurant;

public class Pidao {

    private final Restaurant restaurant;
    private final Menu menu;
    private final OrderRecord orders;
    private final UserRecord users;

    public Pidao(String restaurantName, String restaurantCnpj, int xAxis, int yAxis)
            throws Exception
    {
        restaurant = new Restaurant(restaurantName, restaurantCnpj, xAxis, yAxis);
        menu = new Menu();
        orders = new OrderRecord();
        users = new UserRecord();
    }

    public User registerUser(String name, String cpf, int xAxis, int yAxis) throws Exception {
        User user = new User(name, cpf, new Position(xAxis, yAxis));
        users.registerUser(user);
        return user;
    }

    public void addMealOption(Meal meal) throws Exception {
        menu.addOption(meal);
    }

    public void removeMealOption(String mealId) {
        menu.removeOption(mealId);
    }

    public void printMenu() {
        System.out.println(restaurant + "\n\n" + menu + "\n");
    }

    public void applyDiscount(String mealId, double value, DiscountType discountType) {
        menu.applyDiscount(new Discount(discountType, value), mealId);
    }

    public void cancelDiscount(String mealId) {
        menu.cancelDiscount(mealId);
    }

    public void makeOrder(Order order) throws Exception {
        if (users.isNotOnRecord(order.getUser()))
            users.registerUser(order.getUser());
        if (order.checkOrderIsOnMenu(menu))
            orders.saveOrder(order);
    }

    public void cancelOrder(Order order) throws Exception {
        orders.cancelOrder(order);
    }

    public void updateOrderStatus(Order order) {
        orders.updateOrderStatus(order);
    }

    public void printOrders() {
        System.out.println(orders);
    }

}
