package com.unicamp.mc322.lab05.notebook.note.reminder;

import java.util.Objects;

public class Person {

    private final String name;
    private final String email;
    private final String phone;

    public Person(String name, String email, String phone) {
        Objects.requireNonNull(name, "  person name");
        Objects.requireNonNull(email, "  person email");
        Objects.requireNonNull(phone, "  person phone");

        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + " - Phone: " + phone + " - Email: " + email;
    }

}
