package com.unicamp.mc322.lab10.pidao.restaurant;

import com.unicamp.mc322.lab10.pidao.Position;
import com.unicamp.mc322.lab10.pidao.Rate;

import java.util.ArrayList;
import java.util.Objects;

public class Restaurant {

    private final String name;
    private final String cnpj;
    private final Position position;
    private final Menu menu;

    public Restaurant(String name, String cnpj, Menu menu, double xAxis, double yAxis) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(cnpj);
        Objects.requireNonNull(menu);

        this.name = name;
        this.cnpj = cnpj;
        this.menu = menu;
        position = new Position(xAxis, yAxis);
    }

    public void addToMenu(Meal meal, String id) {
        menu.add(meal, id);
    }

    public void removeFromMenu(String id) {
        menu.remove(id);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void makeOrder(Order order) {
        menu.createOrder(order);
    }

    public String showMenu() {
        return name + " menu:\n" + menu.show();
    }

    public boolean matchCnpj(String cnpj) {
        return this.cnpj.equals(cnpj);
    }

    public void applyDiscount(String id, Discount discount) {
        menu.applyDiscount(id, discount);
    }

    public void removeDiscount(String id) {
        menu.removeDiscount(id);
    }

}
