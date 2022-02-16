package com.unicamp.mc322.lab08.twittery.tweet;

import java.util.Objects;

public class Title {

    public final int MAX_CHAR = 60;

    private final String title;

    Title(String title) {
        Objects.requireNonNull(title, "title");

        if (title.isBlank()) throw new RuntimeException("title can`t be blank!");

        if (title.strip().length() > 60) throw new RuntimeException("title max char exceeded!");

        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other instanceof Title)
            return title.equals(((Title) other).title);
        return false;
    }

}
