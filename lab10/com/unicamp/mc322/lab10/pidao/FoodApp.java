package com.unicamp.mc322.lab10.pidao;

import com.unicamp.mc322.lab10.pidao.restaurant.Meal;
import com.unicamp.mc322.lab10.pidao.restaurant.Order;
import com.unicamp.mc322.lab10.pidao.restaurant.Restaurant;

import java.util.ArrayList;

public class FoodApp {

    private final ArrayList<User> users;
    private final ArrayList<SubscribedRestaurant> subscribedRestaurants;

    public FoodApp() {
        users = new ArrayList<>();
        subscribedRestaurants = new ArrayList<>();
    }

    private boolean checkUserIsSubscribed(String cpf) {
        for (User user : users) {
            if (user.matchCpf(cpf)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRestaurantIsSubscribed(String cnpj) {
        for (SubscribedRestaurant restaurant : subscribedRestaurants) {
            if (restaurant.matchCnpj(cnpj)) {
                return true;
            }
        }
        return false;
    }

    public void subscribe(String name, String cpf, int xAxis, int yAxis) {
        if (!checkUserIsSubscribed(cpf)) {
            users.add(new User(name, cpf, xAxis, yAxis));
        }
    }

    public void subscribe(Restaurant restaurant) {
        if (!checkRestaurantIsSubscribed(restaurant.getCnpj())) {
            subscribedRestaurants.add(new SubscribedRestaurant(restaurant));
        }
    }

    private User searchUser(String cpf) {
        for (User user : users) {
            if (user.matchCpf(cpf)) {
                return user;
            }
        }
        return null;
    }

    private SubscribedRestaurant searchRestaurant(String cnpj) {
        for (SubscribedRestaurant restaurant : subscribedRestaurants) {
            if (restaurant.matchCnpj(cnpj))
                return restaurant;
        }
        return null;
    }

    public boolean makeOrder(Order order, String userCpf, String restaurantCnpj) {
        User user = searchUser(userCpf);
        SubscribedRestaurant restaurant = searchRestaurant(restaurantCnpj);
        if (user != null && restaurant != null) {
            order.assignOwner(user);
            order.assignRestaurant(restaurant);
            if (restaurant.makeOrder(order)) {
                user.makeOrder();
                return true;
            }
        }
        return false;
    }

    public boolean updateOrder(String restaurantCnpj, String userCpf) {
        SubscribedRestaurant restaurant = searchRestaurant(restaurantCnpj);
        User user = searchUser(userCpf);
        if (restaurant != null && user != null) {
            restaurant.updateOrder(userCpf);
            return true;
        }
        return false;
    }

    public void addToMenu(String cnpj, Meal meal, String id) {
        SubscribedRestaurant restaurant = searchRestaurant(cnpj);
        if (restaurant != null) {
            restaurant.addToMenu(meal, id);
        }
    }

    public void removeFromMenu(String cnpj, String id) {
        SubscribedRestaurant restaurant = searchRestaurant(cnpj);
        if (restaurant != null) {
            restaurant.removeFromMenu(id);
        }
    }

    public void rateRestaurant(String cnpj, double rate, String comment, String userCpf) {
        User user = searchUser(userCpf);
        SubscribedRestaurant restaurant = searchRestaurant(cnpj);
        if (user != null && restaurant != null) {
            if (user.hasPendingRate()) {
                restaurant.rate(rate, comment);
            }
        }
    }

    public void rateDeliveryMen(String cnpj, double rate, String comment, String userCpf, String deliveryMenCPf) {
        User user = searchUser(userCpf);
        SubscribedRestaurant restaurant = searchRestaurant(cnpj);
        if (user != null && restaurant != null) {
            if (user.hasPendingRate()) {
                user.spendRate();
                restaurant.rateDeliveryMen(deliveryMenCPf, rate, comment);
            }
        }
    }

    public void assignDeliveryMen(String cpf, String cnpj) {
        User user = searchUser(cpf);
        SubscribedRestaurant restaurant = searchRestaurant(cnpj);
        if (user != null && restaurant != null) {
            restaurant.assignDeliveryMen(user.getName(), user.getCpf());
        }
    }

    public void rateOrder(String cnpj, double rate, String comment, String userCpf) {
        User user = searchUser(userCpf);
        SubscribedRestaurant restaurant = searchRestaurant(cnpj);
        if (user != null && restaurant != null) {
            if (user.hasPendingRate()) {
                user.spendRate();
                restaurant.rateOrder(userCpf, rate, comment);
            }
        }
    }

    public void showMenu(String cnpj) {
        SubscribedRestaurant restaurant = searchRestaurant(cnpj);
        if (restaurant != null) {
            FoodAppIO.display(restaurant.showMenu());
        }
    }

    public void showOrders() {
        for (SubscribedRestaurant restaurant : subscribedRestaurants) {
            FoodAppIO.display(restaurant.showOrders());
        }
    }

    public void showRates() {
        for (SubscribedRestaurant restaurant : subscribedRestaurants) {
            FoodAppIO.display(restaurant.showRate());
            FoodAppIO.display(restaurant.showDeliveryMensRate());
            FoodAppIO.display(restaurant.showOrderRates());
        }
    }



}
