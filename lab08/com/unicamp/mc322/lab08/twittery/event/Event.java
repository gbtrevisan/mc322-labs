package com.unicamp.mc322.lab08.twittery.event;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Event {

    private final LocalDate date;
    private final String authorNickname;

    public Event(String authorNickname) {
        Objects.requireNonNull(authorNickname, "authorNickname");
        date = LocalDate.now();
        this.authorNickname = authorNickname;
    }

    public String show() {
        return "[" + date + "] " + authorNickname;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof Event)
            return authorNickname.equals(((Event) other).authorNickname);
        return false;
    }

}
