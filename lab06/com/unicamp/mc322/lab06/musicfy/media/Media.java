package com.unicamp.mc322.lab06.musicfy.media;

import java.util.Objects;

public abstract class Media {

    private final String name;

    public Media(String name) {
        Objects.requireNonNull(name, "media name");

        this.name = name;
    }

    public abstract double calculateStorage();

    public abstract int calculateDuration();

    public abstract String getAuthor();

    public int compareDuration(Media otherMedia) {
        return Integer.compare(calculateDuration(), otherMedia.calculateDuration());
    }

    @Override
    public String toString() {
        int duration = calculateDuration();
        return "Name: " + name + " - Author: " + getAuthor() + " - Duration: " +
                duration / 60 + ":" + duration % 60 + " - Size: " + String.format("%, .1f", calculateStorage()) + "MB";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof Media)
            return name.equals(((Media) other).name) &&
                    getAuthor().equals(((Media) other).getAuthor()) &&
                    calculateDuration() == ((Media) other).calculateDuration() &&
                    calculateStorage() == ((Media) other).calculateStorage();
        return false;
    }

}
