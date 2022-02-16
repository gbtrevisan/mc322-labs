package com.unicamp.mc322.lab13.manager.order;

import com.unicamp.mc322.lab13.manager.IOrder;

import java.util.Objects;

public abstract class Order implements IOrder {

    private final Person owner;
    private final String id;
    private int turn;

    public Order(Person owner, String id) {
        Objects.requireNonNull(owner, "Order owner should not be null");
        Objects.requireNonNull(id, "Order id should not be null");

        this.owner = owner;
        this.id = id;
        turn = 0;
    }


    @Override
    public void incrementTurn() {
        turn++;
    }

    @Override
    public int getTurn() {
        return turn;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void printOwnerName() {
        System.out.println(owner.getName());
    }

    @Override
    public void printOwner() {
        System.out.println(owner);
    }

    @Override
    public Person getOwner() {
        return owner;
    }

}
