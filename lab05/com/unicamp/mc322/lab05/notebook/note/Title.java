package com.unicamp.mc322.lab05.notebook.note;

import java.util.Objects;

public class Title {

    public final int MAX_TITLE_CHARACTERS = 20;

    private String title;

    Title(String title) {
        validateTitle(title);
        this.title = title;
    }

    private void validateTitle(String title) throws RuntimeException {
        Objects.requireNonNull(title, "title");

        if (title.isBlank())
            throw new RuntimeException("Note title can`t be blank!");

        if (title.strip().length() > MAX_TITLE_CHARACTERS)
            throw new RuntimeException("Note title exceeds " + MAX_TITLE_CHARACTERS + " characters");
    }

    void change(String newTitle) {
        validateTitle(newTitle);
        title = newTitle;
    }

    @Override
    public String toString() {
        return title;
    }

}
