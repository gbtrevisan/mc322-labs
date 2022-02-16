package com.unicamp.mc322.lab10.pidao.restaurant;

import java.util.Objects;

public class Meal {

    private final String name;
    private double price;

    public Meal(String name, double price) {
        Objects.requireNonNull(name, "Meal name should not be null");

        if (price <= 0) {
            throw new RuntimeException("Meal price should be a positive number");
        }

        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " - R$ " + price;
    }

}
