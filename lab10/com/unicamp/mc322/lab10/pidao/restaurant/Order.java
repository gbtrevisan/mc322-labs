package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.Rateable;
import com.unicamp.mc322.lab10.pidao.SubscribedRestaurant;
import com.unicamp.mc322.lab10.pidao.User;

import java.util.ArrayList;

public abstract class Order extends Rateable {

    public final static double FIRST_ORDER_DISCOUNT = 0.2;

    private final ArrayList<String> mealsIdentifiers;

    public Order(ArrayList<String> mealsIdentifiers) {
        this.mealsIdentifiers = new ArrayList<>();
        this.mealsIdentifiers.addAll(mealsIdentifiers);
    }

    protected boolean isInOrder(MenuItem item) {
        return mealsIdentifiers.contains(item.getId());
    }

    ArrayList<String> getMealsIdentifiers() {
        return mealsIdentifiers;
    }

    public abstract void assignOwner(User user);

    public abstract void assignRestaurant(SubscribedRestaurant restaurant);

    public abstract void addItem(MenuItem item);

    public abstract double calculatePrice();

    public abstract void update();

    public abstract boolean toDelivery();

    public abstract boolean belongsTo(String userCpf);

    public abstract boolean isFinished();

}
