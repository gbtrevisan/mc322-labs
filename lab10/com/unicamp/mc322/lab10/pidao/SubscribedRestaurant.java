package com.unicamp.mc322.lab10.pidao;

import com.unicamp.mc322.lab10.pidao.restaurant.Meal;
import com.unicamp.mc322.lab10.pidao.restaurant.Order;
import com.unicamp.mc322.lab10.pidao.restaurant.Restaurant;

import java.util.ArrayList;
import java.util.Objects;

public class SubscribedRestaurant extends Rateable {

    private final Restaurant restaurant;
    private final ArrayList<DeliveryMen> deliveryMens;
    private final ArrayList<Order> orders;

    public SubscribedRestaurant(Restaurant restaurant) {
        Objects.requireNonNull(restaurant);

        this.restaurant = restaurant;
        deliveryMens = new ArrayList<>();
        orders = new ArrayList<>();
    }

    private DeliveryMen getAvailableDeliveryMen() {
        for (DeliveryMen deliveryMen : deliveryMens) {
            if (!deliveryMen.isOnRun()) {
                return deliveryMen;
            }
        }
        return null;
    }

    private DeliveryMen searchDeliveryMen(String cpf) {
        for (DeliveryMen deliveryMen : deliveryMens) {
            if (deliveryMen.getCpf().equals(cpf)) {
                return deliveryMen;
            }
        }
        return null;
    }

    public void addToMenu(Meal meal, String id) {
        restaurant.addToMenu(meal, id);
    }

    public void removeFromMenu(String id) {
        restaurant.removeFromMenu(id);
    }

    public void assignDeliveryMen(String name, String cpf) {
        if (searchDeliveryMen(cpf) == null) {
            deliveryMens.add(new DeliveryMen(name, cpf));
        }
    }

    public void unAssignDeliveryMen(String cpf) {
        deliveryMens.removeIf(deliveryMen -> deliveryMen.getCpf().equals(cpf));
    }

    public boolean makeOrder(Order order) {
        DeliveryMen deliveryMen = getAvailableDeliveryMen();
        if (order.toDelivery() && deliveryMen != null) {
            deliveryMen.assignRun();
            order.update();
        } else if (!order.toDelivery()) {
            order.update();
        } else {
            return false;
        }
        restaurant.makeOrder(order);
        orders.add(order);
        return true;
    }

    public String showMenu() {
        return restaurant.showMenu();
    }

    public String showOrders() {
        StringBuilder formattedString = new StringBuilder();
        for (Order order : orders) {
            formattedString.append(order).append("\n\n");
        }
        return formattedString.toString();
    }

    public void updateOrder(String userCpf) {
        for (Order order : orders) {
            if (order.belongsTo(userCpf)) {
                order.update();
            }
        }
    }

    public boolean matchCnpj(String cnpj) {
        return restaurant.matchCnpj(cnpj);
    }

    public String getCnpj() {
        return restaurant.getCnpj();
    }

    public String getName() {
        return restaurant.getName();
    }

    public Position getPosition() {
        return restaurant.getPosition();
    }

    public void rateDeliveryMen(String cpf, double rate, String comment) {
        DeliveryMen deliveryMen = searchDeliveryMen(cpf);
        if (deliveryMen != null) {
            deliveryMen.rate(rate, comment);
        }
    }

    private Order searchOrder(String cpf) {
        for (Order order : orders) {
            if (order.belongsTo(cpf)) {
                return order;
            }
        }
        return null;
    }

    public void rateOrder(String userCpf, double rate, String comment) {
        Order order = searchOrder(userCpf);
        if (order != null) {
            order.rate(rate, comment);
        }
    }

    public String showDeliveryMensRate() {
        StringBuilder formattedString = new StringBuilder();
        for (DeliveryMen deliveryMen : deliveryMens) {
            formattedString.append(deliveryMen.showRate()).append("\n");
        }
        return formattedString.toString();
    }

    public String showOrderRates() {
        StringBuilder formattedString = new StringBuilder();
        for (Order order : orders) {
            formattedString.append(order.showRate()).append("\n");
        }
        return formattedString.toString();
    }

}
