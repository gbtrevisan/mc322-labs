package com.unicamp.mc322.lab08.twittery.tweet.content;

import com.unicamp.mc322.lab08.twittery.tweet.content.extension.ImageExtension;

import java.util.Objects;

public class Image extends Archive {

    public final int PER_PIXEL_STORAGE = 1;

    private final String name;
    private final int resolution;
    private final ImageExtension extension;
    private final String descriptiveText;

    public Image(String name, int resolution, ImageExtension extension, String descriptiveText) {
        Objects.requireNonNull(name, "image name");
        Objects.requireNonNull(descriptiveText, "image descriptiveText");

        if (name.isBlank()) throw new RuntimeException("image name can`t be blank!");

        if (resolution <= 240) throw new RuntimeException("Image resolution not allowed!");

        this.name = name.replace(" ", "_");
        this.resolution = resolution;
        this.extension = extension;
        this.descriptiveText = descriptiveText;
    }

    @Override
    public boolean acceptExtension(String extension) {
        for (ImageExtension imageExtension : ImageExtension.values())
            if (imageExtension.toString().toLowerCase().equals(extension))
                return true;
        return false;
    }

    @Override
    public double calculateStorage() {
        return resolution * PER_PIXEL_STORAGE;
    }

    @Override
    public String show() {
        return name + "." + extension.toString().toLowerCase() + "\n#Descriptive text: " + descriptiveText;
    }

}
