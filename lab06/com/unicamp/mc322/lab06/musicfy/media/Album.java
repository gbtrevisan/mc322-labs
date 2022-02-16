package com.unicamp.mc322.lab06.musicfy.media;

import java.util.ArrayList;

public class Album extends Media {

    private final ArrayList<Song> songs;
    private final String author;

    public Album(String name, ArrayList<Song> songs) {
        super(name);

        if (songs.isEmpty()) throw new RuntimeException("Album must have at least one song!");

        this.songs = songs;
        author = defineAuthor();
    }

    private String defineAuthor() {
        String possibleAuthor = songs.get(0).getAuthor();

        for (Song song : songs)
            if (!song.getAuthor().equals(possibleAuthor))
                return "Multiple authors";

        return possibleAuthor;
    }

    @Override
    public double calculateStorage() {
        double storage = 0;

        for (Song song : songs)
            storage += song.calculateStorage();

        return  storage;
    }

    @Override
    public int calculateDuration() {
        int duration = 0;

        for (Song song : songs)
            duration += song.calculateDuration();

        return duration;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        StringBuilder formattedString = new StringBuilder("< ALBUM > " + super.toString() + " - Songs: " + songs.size());

        for (Song song : songs)
            formattedString.append("\n\t").append(song.toString());

        return formattedString.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        return super.equals(other) &&
                other instanceof Album &&
                songs.equals(((Album) other).songs);
    }

}
