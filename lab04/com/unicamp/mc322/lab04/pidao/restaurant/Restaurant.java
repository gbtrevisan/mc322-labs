package com.unicamp.mc322.lab04.pidao.restaurant;

import com.unicamp.mc322.lab04.pidao.position.Position;

public class Restaurant {

    private String name;
    private final String cnpj;
    private Position position;

     public Restaurant(String name, String cnpj, int xAxis, int yAxis) throws Exception {
        if (name == null || cnpj == null) throw new Exception("Not a valid restaurant ...");

        this.name = name;
        this.cnpj = cnpj;
        position = new Position(xAxis, yAxis);
    }

    public String toString() {
        return  name + "\nLocation: " + position;
    }

    String getCnpj() {
        return cnpj;
    }

    void changeLocation(int xAxis, int yAxis) {
        position = new Position(xAxis, yAxis);
    }

    void changeName(String name) throws  Exception {
        if (name == null) throw new Exception("Not a valid restaurant name!");

        this.name = name;
    }

}
