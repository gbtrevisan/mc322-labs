package com.unicamp.mc322.lab13.manager.strategy;

import com.unicamp.mc322.lab13.manager.IOrder;
import com.unicamp.mc322.lab13.manager.IOrderingStrategy;

public class PriorityScoreStrategy implements IOrderingStrategy {

    @Override
    public double calculatePriority(IOrder order) {
        if (order == null) {
            throw new IllegalArgumentException("Order should not be null");
        }

        return ((double) order.getOwner().getAge() / 100) + (double) order.getTurn() * 7 / 100 ;
    }

}
