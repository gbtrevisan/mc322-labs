package com.unicamp.mc322.lab13.manager;

import com.unicamp.mc322.lab13.manager.order.Person;

public interface IOrder {

    void incrementTurn();

    int getTurn();

    String getId();

    void printOwnerName();

    void printOwner();

    Person getOwner();

}
