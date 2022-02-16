package com.unicamp.mc322.lab04.pidao;

import com.unicamp.mc322.lab04.pidao.position.Position;

public class User {

    private final String name;
    private final String cpf;
    private final Position position;
    private int numberOfOrders;


    public User(String name, String cpf, Position position) throws Exception {
        if (name == null || cpf == null || position == null) throw new Exception("Not a valid user!");

        this.name = name;
        this.cpf = cpf;
        this.position = position.copy();
        numberOfOrders = 0;
    }

    void makeOrder() {
        numberOfOrders++;
    }

    int getNumberOfOrders() {
        return numberOfOrders;
    }

    Position getDeliveryPoint() {
        return position;
    }

    public String toString() {
        return name + " (" + cpf + ")";
    }

    public User copy() throws Exception {
        return new User(name, cpf , position.copy());
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (!getClass().equals(other.getClass()))
            return false;
        if (this == other)
            return true;
        return cpf.equals(((User) other).cpf);
    }

}
