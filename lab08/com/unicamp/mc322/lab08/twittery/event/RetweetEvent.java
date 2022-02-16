package com.unicamp.mc322.lab08.twittery.event;

import java.util.Objects;

public class RetweetEvent extends Event {

    private final String publicationTitle;

    public RetweetEvent(String authorNickname, String publicationTitle) {
        super(authorNickname);
        Objects.requireNonNull(publicationTitle, "publicationTitle");
        this.publicationTitle = publicationTitle;
    }

    @Override
    public String show() {
        return super.show() + " : retweeted \"" + publicationTitle + "\"";
    }


}
