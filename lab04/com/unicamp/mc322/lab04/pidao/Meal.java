package com.unicamp.mc322.lab04.pidao;

public class Meal {

    private final String identifier;
    private final String name;
    private double price;
    private double moneyDiscount;
    private double rateDiscount;

    public Meal(String identifier, String name, double price) throws Exception {
        if (identifier == null || name == null) throw new Exception("Not a valid meal!");

        if (price < 0) throw new Exception("Meal price should be a positive number ...");

        this.name = name;
        this.identifier = identifier;
        this.price = price;
        moneyDiscount = 0;
        rateDiscount = 0;
    }

    private Meal(String identifier, String name, double price, double moneyDiscount, double rateDiscount)
            throws Exception
    {
        this(identifier, name, price);
        this.moneyDiscount = moneyDiscount;
        this.rateDiscount = rateDiscount;
    }

    void applyRateDiscount(double rate) {
        rateDiscount += rate;
    }

    void applyMoneyDiscount(double discount) {
        this.moneyDiscount += discount;
    }

    double calculatePriceWithDiscount() {
        double priceWithDiscount = price * (1 - rateDiscount) - moneyDiscount;
        if (priceWithDiscount < 0)
            return 0;
        return priceWithDiscount;
    }

    public String toString() {
        StringBuilder formattedString = new StringBuilder(
                "[" + identifier + "] " + name +
                        " R$ " + calculatePriceWithDiscount());
       if (hasDiscount())
           formattedString.append(" * WITH DISCOUNT! NORMAL PRICE: R$ ").append(price).append(" *");
       return formattedString.toString();
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (!this.getClass().equals(other.getClass()))
            return false;
        if (this == other)
            return true;
        return identifier.equals(((Meal) other).identifier);
    }

    public boolean hasDiscount() {
        return (moneyDiscount != 0 || rateDiscount != 0);
    }

    void cancelDiscount() {
        moneyDiscount = 0;
        rateDiscount = 0;
    }

    void changePrice(double newPrice) throws Exception {
        if (newPrice < 0 ) throw new Exception("Meal price should be higher then 0 ...");

        this.price = newPrice;
    }

    String getIdentifier() {
        return identifier;
    }

    public Meal copy() throws Exception {
        return new Meal(identifier, name, price, moneyDiscount, rateDiscount);
    }

}
