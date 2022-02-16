package com.unicamp.mc322.lab09;

import com.unicamp.mc322.lab09.ed.Element;

import java.util.Objects;

public class Person extends Element {

    private final String name;
    private final int age;
    private final String cpf;

    public Person(String name, int age, String cpf) {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(cpf, "cpf");
        this.name = name;
        this.age = age;
        this.cpf = cpf;
    }

    @Override
    public String show() {
        return "Name: " + name + " - Age: " + age + " - CPF: " + cpf;
    }

}
