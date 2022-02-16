package com.unicamp.mc322.lab04.pidao;

public class OrderRecord {

    private Order[] orders;
    private int size;
    private int ordersNumber;

    OrderRecord() {
        size = 100;
        orders = new Order[size];
        ordersNumber = 0;
    }

    private void increaseSize() throws Exception {
        Order[] ordersCopy;
        if (ordersNumber == size) {
            ordersCopy = new Order[size * 2];
            for (int i = 0; i < ordersNumber; i++)
                ordersCopy[i] = orders[i].copy();
            orders = ordersCopy;
            size = size * 2;
        }
    }

    private boolean isOnRecord(Order order) {
        for (int i = 0; i < ordersNumber; i++)
            if (orders[i].equals(order))
                return true;
        return false;
    }

    void saveOrder(Order order) throws Exception {
        if (!isOnRecord(order) && order.isNew()) {
            orders[ordersNumber] = order;
            ordersNumber++;
            order.updateStatus();
            increaseSize();
        }
    }

    void updateOrderStatus(Order order) {
        boolean updated = false;
        for (int i = 0; i < ordersNumber && !updated; i++) {
            if (orders[i].equals(order)) {
                orders[i].updateStatus();
                updated = true;
            }
        }
    }

    void cancelOrder(Order order) {
        boolean canceled = false;
        for (int i = 0; i < ordersNumber && !canceled; i++)
            if (orders[i].equals(order) && orders[i].checkCanCancel()) {
                System.arraycopy(orders, i + 1, orders, i, ordersNumber - 1 - i);
                ordersNumber--;
                canceled = true;
            }
    }

    public String toString() {
        String DIV = "-----------------------------------------------------\n";
        StringBuilder formattedString = new StringBuilder("There are " + ordersNumber + " orders: \n");
        for (int i = 0; i < ordersNumber; i++) {
            formattedString.append(DIV);
            formattedString.append(orders[i].toString());
        }
        formattedString.append(DIV);
        return formattedString.toString();
    }

}
