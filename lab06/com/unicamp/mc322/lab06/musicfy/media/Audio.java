package com.unicamp.mc322.lab06.musicfy.media;

import java.util.Objects;

public class Audio extends Media {

    public final int STORAGE_PER_MINUTE = 5;

    private final String author;
    private final int durationInSeconds;

    Audio(String name, String author, int durationInSeconds) {
        super(name);

        Objects.requireNonNull(author, "author");

        if (durationInSeconds <= 0) throw new RuntimeException("Audio duration can`t be 0 or negative!");

        this.author = author;
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public double calculateStorage() {
        if (durationInSeconds < 60)
            return  0;
        return ((double) durationInSeconds / 60) * STORAGE_PER_MINUTE;
    }

    @Override
    public int calculateDuration() {
        return durationInSeconds;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        return super.equals(other) && other instanceof Audio;
    }

}
