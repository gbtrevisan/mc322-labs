package com.unicamp.mc322.lab13.manager.order;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {

    private final String name;
    private final String cpf;
    private final LocalDate birthDate;

    public Person(String name, String cpf, LocalDate birthDate) {
        Objects.requireNonNull(name, "Person name should not be null");
        Objects.requireNonNull(cpf, "Person cpf should not be null");
        Objects.requireNonNull(birthDate, "Person birth date should not be null");

        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Name: " + name + " - CPF: " + cpf + " - Age: " + getAge();
    }

}
