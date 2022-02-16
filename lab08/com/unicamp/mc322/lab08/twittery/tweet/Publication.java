package com.unicamp.mc322.lab08.twittery.tweet;

public abstract class Publication {

    public abstract boolean comment(String authorNickname, String comment);

    public abstract boolean like(String authorNickname);

    public abstract String show();

    public abstract void publish();

    public abstract Publication retweet();

    public abstract boolean matchTitle(String publicationTitle);

}
