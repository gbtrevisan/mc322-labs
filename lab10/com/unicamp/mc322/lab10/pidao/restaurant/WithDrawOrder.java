package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.SubscribedRestaurant;
import com.unicamp.mc322.lab10.pidao.User;

import java.util.ArrayList;

public class WithDrawOrder extends Order {

    private OrderStatus status;
    private User owner;
    private String restaurantName;
    private final ArrayList<MenuItem> items;
    private double price;

    public WithDrawOrder(ArrayList<String> mealsIdentifiers) {
        super(mealsIdentifiers);
        items = new ArrayList<>();
        status = OrderStatus.NEW;
    }

    @Override
    public void assignOwner(User user) {
        owner = user;
    }

    @Override
    public void assignRestaurant(SubscribedRestaurant restaurant) {
        restaurantName = restaurant.getName();
    }

    @Override
    public void addItem(MenuItem item) {
        if (isInOrder(item)) {
            items.add(item);
        }
    }

    @Override
    public double calculatePrice() {
        double price = 0;
        for (MenuItem item : items) {
            price = price + item.calculatePrice();
        }
        if (owner.isFirstOrder()) {
            price = price * (1 - FIRST_ORDER_DISCOUNT);
        }
        return price;
    }

    @Override
    public void update() {
        OrderStatus[] orderStatus = OrderStatus.values();
        if (status != OrderStatus.DELIVERED) {
            status = orderStatus[status.ordinal() + 1];
        }
        if (status == OrderStatus.PREPARING) {
            price = calculatePrice();
        }
        if (status == OrderStatus.IN_TRANSPORT) {
            status = OrderStatus.DELIVERED;
        }
    }

    @Override
    public boolean toDelivery() {
        return false;
    }

    @Override
    public boolean belongsTo(String userCpf) {
        return userCpf.equals(owner.getCpf());
    }

    @Override
    public boolean isFinished() {
        return status.equals(OrderStatus.DELIVERED);
    }

    @Override
    public String toString() {
        StringBuilder formattedString = new StringBuilder("Restaurant: " + restaurantName + "\nOwner: " + owner.getName() + "\n\n");
        for (MenuItem item : items) {
            formattedString.append("* ").append(item).append("\n");
        }
        formattedString.append("\n").append("Status: ").append(status).append("\n");
        if (status != OrderStatus.NEW) {
            formattedString.append("Price: ").append(price).append("\n");
        }
        return formattedString.toString();
    }

}
