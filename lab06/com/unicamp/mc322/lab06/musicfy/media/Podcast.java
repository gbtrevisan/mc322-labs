package com.unicamp.mc322.lab06.musicfy.media;

import java.util.Objects;

public class Podcast extends Media {

    public final int STORAGE_PER_MINUTE = 1;

    private final String author;
    private final int episodes;
    private final int durationInSeconds;

    public Podcast(String name, String author, int durationInSeconds ,int episodes) {
        super(name);

        Objects.requireNonNull(author, "author");
        if (durationInSeconds <= 0) throw new RuntimeException("Podcast episodes duration can`t be 0 or negative!");
        if (episodes <= 0) throw new RuntimeException("Podcast must have at least one episode!");

        this.author = author;
        this.episodes = episodes;
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public double calculateStorage() {
        if (calculateDuration() < 60)
            return 0;
        return ((double) calculateDuration() / 60) * STORAGE_PER_MINUTE;
    }

    @Override
    public int calculateDuration() {
        return durationInSeconds * episodes;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "< PODCAST > " + super.toString() + " - Episodes: " + episodes;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (super.equals(other) && other instanceof Podcast)
            return episodes == ((Podcast) other).episodes;
        return false;
    }

}
