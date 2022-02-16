package com.unicamp.mc322.lab02;

public class Song {
    private String musicName;
    private String musicGenre;
    private String musicArtist;
    private int musicDurationInSeconds;

    protected Song(String name, String genre, String artist, int musicDurationInSeconds) throws Exception {
        if (name == null || genre == null || artist == null)
            throw new Exception("Not a valid song ...");
        this.musicName = name;
        this.musicGenre = genre;
        this.musicArtist = artist;
        this.musicDurationInSeconds = musicDurationInSeconds;
    }

    public void showInformation() {
        System.out.println(this.musicName + " - " + this.musicArtist + " - " +
                this.musicGenre + " (" + (this.musicDurationInSeconds/60) +
                ":" + (this.musicDurationInSeconds%60) + ")");
    }

    public void setMusicName(String newName) throws Exception {
        if (newName == null)
            throw new Exception("Not a valid music name ...");
        this.musicName = newName;
    }

    public void setMusicGenre(String newGenre) throws Exception {
        if (newGenre == null)
            throw new Exception("Not a valid music genre ...");
        this.musicGenre = newGenre;
    }

    public void setMusicArtist(String newArtist) throws Exception {
        if (newArtist == null)
            throw new Exception("Not a valid music artist ...");
        this.musicArtist = newArtist;
    }

    public void setMusicDuration(int musicDurationInSeconds) {
        this.musicDurationInSeconds = musicDurationInSeconds;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public String getMusicGenre() {
        return this.musicGenre;
    }

    public String getMusicArtist() {
        return this.musicArtist;
    }

    public int getMusicDuration() {
        return musicDurationInSeconds;
    }

}
