package com.unicamp.mc322.lab13.manager;

import java.util.LinkedList;

public class InsaneDS implements ICrazyDS {

    private final LinkedList<IOrder> orders;

    private final IOrderingStrategy orderingStrategy;

    public InsaneDS(IOrderingStrategy orderingStrategy) {
        if (orderingStrategy == null) {
            throw new CrazyDSException("InsaneDS ordering strategy should not be null");
        }

        this.orderingStrategy = orderingStrategy;
        orders = new LinkedList<>();
    }

    private int searchPosition(IOrder newOrder) {
        int index = orders.size();
        double newOrderPriority = orderingStrategy.calculatePriority(newOrder);

        for (IOrder order : orders) {
            double priority = orderingStrategy.calculatePriority(order);

            if (newOrderPriority >= priority) {
                index = orders.indexOf(order);
                break;
            }
        }

        return index;
    }

    @Override
    public void add(IOrder newOrder) {
        if (newOrder == null) {
            throw new CrazyDSException("Order should not be null");
        }

        orders.add(searchPosition(newOrder), newOrder);
    }

    private void updateOrders() {
        for (IOrder order : orders) {
            order.incrementTurn();
        }
    }

    @Override
    public void remove(IOrder order) {
        if (order == null) {
            throw new CrazyDSException("Order should not be null");
        }

        updateOrders();

        orders.remove(order);
    }

    @Override
    public IOrder peek() throws EmptyCrazyDSException {
        if (orders.size() == 0) {
            throw new EmptyCrazyDSException("InsaneDS have no order to peek");
        }

        return orders.remove(0);
    }

    @Override
    public void print() {
        for (IOrder order : orders) {
            System.out.print(order.getOwner() + " ( " + orderingStrategy.calculatePriority(order) + ")\n");
        }
    }

}
