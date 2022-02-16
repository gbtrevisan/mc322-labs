package com.unicamp.mc322.lab08.twittery.event;

import java.util.Objects;

public class Like extends Event {

    private final String publicationTitle;

    public Like(String authorNickname, String publicationTitle) {
        super(authorNickname);
        Objects.requireNonNull(publicationTitle, "publicationTitle");
        this.publicationTitle = publicationTitle;
    }

    @Override
    public String show() {
        return super.show() + " : liked \"" + publicationTitle + "\"";
    }

    @Override
    public String toString() {
        return super.show() + " : liked";
    }

}
