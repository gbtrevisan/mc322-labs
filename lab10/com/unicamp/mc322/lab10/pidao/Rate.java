package com.unicamp.mc322.lab10.pidao;

public class Rate {

    private final Double rate;
    private final String comment;

    public Rate(Double rate, String comment) {
        if (rate > 5 || rate < 0) {
            throw new RuntimeException("Rate must be a number between 0 and 5");
        }
        this.rate = rate;
        this.comment = comment;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "[" + rate + "] - " + comment;
    }

}
