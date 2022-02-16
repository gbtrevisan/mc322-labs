package com.unicamp.mc322.lab04.pidao;

public class Discount {

    public static final double USER_FIRST_ORDER_DISCOUNT = 0.2;
    public static final int EVERY_TEN_ORDERS_DISCOUNT = 60;
    public static final double USER_ORDER_OVERLOAD_100_DISCOUNT = 0.1;

    private final DiscountType discountType;
    private final double value;

    Discount(DiscountType discountType, double value) {
        this.discountType = discountType;
        this.value = value;
    }

    void applyDiscountOnMeal(Meal meal) {
        switch (discountType) {
            case MONEY:
                meal.applyMoneyDiscount(value);
                break;
            case PERCENTAGE:
                meal.applyRateDiscount(value / 100);
                break;
        }
    }

}
