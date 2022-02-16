package com.unicamp.mc322.lab10.pidao.restaurant;

import java.util.ArrayList;
import java.util.Objects;

public class MenuItem {

    private final Meal meal;
    private final String id;
    private ArrayList<Discount> discounts;

    MenuItem(Meal meal, String id) {
        Objects.requireNonNull(meal, "MenuItem meal should not be null");
        Objects.requireNonNull(id, "MenuItem id should not be null");

        if (id.length() != 5) {
            throw new RuntimeException("Meal identifier should have 5 letters");
        }

        this.meal = meal;
        this.id = id;
        discounts = new ArrayList<>();
    }

    String getId() {
        return id;
    }

    boolean hasDiscount() {
        return discounts.size() != 0;
    }

    void applyDiscount(Discount discount) {
        discounts.add(discount);
    }

    void removeDiscount() {
        discounts = new ArrayList<>();
    }

    double calculatePrice() {
        double priceWithDiscount = meal.getPrice();
        for (Discount discount : discounts) {
            priceWithDiscount = discount.apply(priceWithDiscount);
        }
        return priceWithDiscount;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other instanceof MenuItem) {
            return this.id.equals(((MenuItem) other).id);
        }
        return false;
    }

    @Override
    public String toString() {
        String formattedText = "[" + id + "]" + " " + meal.getName() + " - R$ ";
        if (hasDiscount()) {
            formattedText = formattedText + calculatePrice() + " (WITH DISCOUNT - OLD PRICE: R$ " + meal.getPrice() + ")";
        } else {
            formattedText = formattedText + meal.getPrice();
        }
        return formattedText;
    }

}
