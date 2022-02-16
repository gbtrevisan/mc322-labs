package com.unicamp.mc322.lab06.musicfy.media;

public class Song extends Audio {

    public Song(String name, String author, int durationInSeconds) {
        super(name, author, durationInSeconds);
    }

    @Override
    public String toString() {
        return "< SONG > : " + super.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        return super.equals(other) && other instanceof Song;
    }

}
