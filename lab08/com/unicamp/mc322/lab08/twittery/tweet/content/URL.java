package com.unicamp.mc322.lab08.twittery.tweet.content;

import java.time.LocalDate;
import java.util.Objects;

public class URL extends Content {

    private final String url;
    private final LocalDate accessDate;

    public URL(String url) {
        Objects.requireNonNull(url, "URL");

        this.url = url;
        accessDate = LocalDate.now();
    }

    public String show() {
        return url + "- Last visited in: " + accessDate;
    }

}
