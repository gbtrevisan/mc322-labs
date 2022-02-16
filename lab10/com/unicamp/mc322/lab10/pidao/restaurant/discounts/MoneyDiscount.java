package com.unicamp.mc322.lab10.pidao.restaurant.discounts;

import com.unicamp.mc322.lab10.pidao.restaurant.Discount;

public class MoneyDiscount extends Discount {

    private final double value;

    public MoneyDiscount(double value) {
        if (value <= 0) {
            throw new RuntimeException("Money discount value should be a positive number");
        }

        this.value = value;
    }

    @Override
    public double apply(double price) {
        price = price - value;
        if (price < 0) {
            return 0;
        } else {
            return price;
        }
    }

}
