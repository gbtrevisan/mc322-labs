package com.unicamp.mc322.lab08.twittery.tweet.content;

import com.unicamp.mc322.lab08.twittery.tweet.content.extension.VideoExtension;

import java.util.Objects;

public class Video extends Archive {

    public final int PER_SECOND_STORAGE = 3;

    private final String name;
    private final int durationInSeconds;
    private final VideoExtension extension;

    public Video(String name, int durationInSeconds, VideoExtension extension) {
        Objects.requireNonNull(name, "video name");

        if (name.isBlank()) throw new RuntimeException("video name can`t be blank!");

        this.name = name.replace(" ", "_");
        this.durationInSeconds = durationInSeconds;
        this.extension = extension;
    }

    @Override
    public boolean acceptExtension(String extension) {
        for (VideoExtension videoExtension : VideoExtension.values())
            if (videoExtension.toString().toLowerCase().equals(extension))
                return true;
        return false;
    }

    @Override
    public double calculateStorage() {
        return durationInSeconds * PER_SECOND_STORAGE;
    }

    @Override
    public String show() {
        return name + "." + extension.toString().toLowerCase();
    }

}
