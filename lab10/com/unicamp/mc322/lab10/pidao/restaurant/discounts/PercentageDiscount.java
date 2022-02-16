package com.unicamp.mc322.lab10.pidao.restaurant.discounts;

import com.unicamp.mc322.lab10.pidao.restaurant.Discount;

public class PercentageDiscount extends Discount {

    private final double rate;

    public PercentageDiscount(double rate) {
        if (rate <= 0) {
            throw new RuntimeException("Discount rate must be a positive number");
        }

        this.rate = rate;
    }

    @Override
    public double apply(double price) {
        if (rate > 1) {
            return 0;
        }
        return price * (1 - rate);
    }

}
