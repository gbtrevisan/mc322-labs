package com.unicamp.mc322.lab06.musicfy.media;

public class Video extends Audio {

    public final Integer PIXEL_STORAGE = 1 / 1000000;

    private final Integer pixels;
    private final int fps;

    public Video(String name, String author, int durationInSeconds, Integer pixels, int fps) {
        super(name, author, durationInSeconds);

        if (pixels <= 0) throw new RuntimeException("Video pixels number can`t be 0 or negative.");
        if (fps <= 0) throw new RuntimeException("Video frames per second can`t be 0 or negative.");

        this.pixels = pixels;
        this.fps = fps;
    }

    @Override
    public double calculateStorage() {
        if (calculateDuration() < 60)
            return 0;
        return (super.calculateStorage() + (pixels * PIXEL_STORAGE * fps * calculateDuration()));
    }

    @Override
    public String toString() {
        return "< VIDEO > : " + super.toString() + " - FPS: " + fps;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (super.equals(other) && other instanceof Video)
            return pixels.equals(((Video) other).pixels) && fps == ((Video) other).fps;
        return false;
    }

}
