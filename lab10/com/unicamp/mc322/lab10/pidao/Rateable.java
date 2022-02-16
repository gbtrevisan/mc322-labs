package com.unicamp.mc322.lab10.pidao;

import java.util.ArrayList;

public abstract class Rateable {

    private final ArrayList<Rate> rates;

    public Rateable() {
        rates = new ArrayList<>();
    }

    public void rate(double value, String comment) {
        rates.add(new Rate(value, comment));
    }

    public String showRate() {
        StringBuilder formattedString = new StringBuilder();
        for (Rate rate : rates) {
            formattedString.append(rate).append(rate);
        }
        return formattedString.toString();
    }

    public double calculateAverageRate() {
        double totalRate = 0;
        for (Rate rate : rates) {
            totalRate = totalRate + rate.getRate();
        }
        return totalRate / rates.size();
    }

}
