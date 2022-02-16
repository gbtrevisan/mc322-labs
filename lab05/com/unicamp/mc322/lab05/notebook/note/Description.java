package com.unicamp.mc322.lab05.notebook.note;

import java.util.Objects;

public class Description {

    public final int MAX_DESCRIPTION_CHARACTERS = 250;

    private String description;

    Description(String description) {
        validateDescription(description);
        this.description = description;
    }

    private void validateDescription(String description) {
        Objects.requireNonNull(description, "description");

        if (description.strip().length() > MAX_DESCRIPTION_CHARACTERS)
            throw new RuntimeException("Title exceeds " + MAX_DESCRIPTION_CHARACTERS + " characters");
    }

    void change(String newDescription) {
        validateDescription(newDescription);
        description = newDescription;
    }

    @Override
    public String toString() {
       return description;
    }

}
