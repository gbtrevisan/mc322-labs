package com.unicamp.mc322.lab10.pidao;

import java.util.Objects;

public class DeliveryMen extends Rateable {

    private final String name;
    private final String cpf;
    private boolean isOnRun;

    public DeliveryMen(String name, String cpf) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(cpf);

        this.name = name;
        this.cpf = cpf;
        isOnRun = false;
    }

    public void finishRun() {
        isOnRun = false;
    }

    public boolean isOnRun() {
        return isOnRun;
    }

    public void assignRun() {
        isOnRun = true;
    }

    public String toString() {
        return "Name: " + name + "\ncpf: " + cpf;
    }

    public String getCpf() {
        return cpf;
    }

}
