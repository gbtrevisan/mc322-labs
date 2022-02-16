package com.unicamp.mc322.lab13.manager;

public interface ICrazyDS {

    void add(IOrder order);

    void remove(IOrder order);

    IOrder peek() throws EmptyCrazyDSException;

    void print();

}
