package com.unicamp.mc322.lab13.manager.strategy;

import com.unicamp.mc322.lab13.manager.IOrder;
import com.unicamp.mc322.lab13.manager.IOrderingStrategy;

public class NameSizeStrategy implements IOrderingStrategy {

    @Override
    public double calculatePriority(IOrder order) {
        return (order.getOwner().getName().length() + (10 * order.getTurn()) / (double) 100);
    }

}
