package com.unicamp.mc322.lab08.twittery.tweet.content;

public abstract class Archive extends Content {

    public abstract boolean acceptExtension(String extension);

    public abstract double calculateStorage();

}
