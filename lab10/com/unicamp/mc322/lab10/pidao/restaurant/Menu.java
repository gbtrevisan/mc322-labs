package com.unicamp.mc322.lab10.pidao.restaurant;

import java.util.ArrayList;

public class Menu {

    private final ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    private boolean isInMenu(String id) {
        MenuItem menuItem = search(id);
        return menuItem != null;
    }

    private MenuItem search(String id) {
        for (MenuItem menuItem : items) {
            if (menuItem.getId().equals(id)) {
                return menuItem;
            }
        }
        return null;
    }

    public void add(Meal meal, String id) {
        if (!isInMenu(id)) {
            items.add(new MenuItem(meal, id));
        }
    }

    public void remove(String id) {
        MenuItem menuItem = search(id);
        if (menuItem != null) {
            items.remove(menuItem);
        }
    }

    public void applyDiscount(String id, Discount discount) {
        MenuItem menuItem = search(id);
        if (menuItem != null) {
            menuItem.applyDiscount(discount);
        }
    }

    public void removeDiscount(String id) {
        MenuItem menuItem = search(id);
        if (menuItem != null) {
            menuItem.removeDiscount();
        }
    }

    public void createOrder(Order order) {
        for (String id : order.getMealsIdentifiers()) {
            if (isInMenu(id)) {
                order.addItem(search(id));
            }
        }
    }

    public String show() {
        StringBuilder menu = new StringBuilder();
        for (MenuItem menuItem : items) {
            menu.append("- ").append(menuItem).append("\n");
        }
        return menu.toString();
    }

}
