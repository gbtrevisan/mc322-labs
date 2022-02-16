package com.unicamp.mc322.lab08.twittery.event;

import java.util.Objects;

public class Comment extends Event {

    public final int MAX_CHAR = 100;

    private final String comment;
    private final String publicationTitle;

    public Comment(String authorNickname, String comment, String publicationTitle) {
        super(authorNickname);
        Objects.requireNonNull(comment, "comment");
        Objects.requireNonNull(publicationTitle, "publicationTitle");
        this.comment = comment;
        this.publicationTitle = publicationTitle;
    }

    @Override
    public String show() {
        return super.show() + " : commented on \"" + publicationTitle + "\"";
    }

    @Override
    public String toString() {
        return super.show() + " : " + comment;
    }

}
