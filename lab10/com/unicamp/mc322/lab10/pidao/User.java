package com.unicamp.mc322.lab10.pidao;

import java.util.Objects;

public class User {

    private final String name;
    private final String cpf;
    private int numberOfOrders;
    private final Position position;
    private boolean hasPendingRate;

    public User(String name, String cpf, int xAxis, int yAxis) {
        Objects.requireNonNull(name, "user name");
        Objects.requireNonNull(cpf, "user cpf");

        this.name = name;
        this.cpf = cpf;
        numberOfOrders = 0;
        position = new Position(xAxis, yAxis);
        hasPendingRate = false;
    }

    public void makeOrder() {
        numberOfOrders++;
        hasPendingRate = true;
    }

    public boolean isFirstOrder() {
        return numberOfOrders == 1;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Position getPosition() {
        return position;
    }

    public boolean matchCpf(String cpf) {
        return this.cpf.equals(cpf);
    }

    public boolean hasPendingRate() {
        return hasPendingRate;
    }

    public void spendRate() {
        hasPendingRate = false;
    }

}
