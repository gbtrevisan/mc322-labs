package com.unicamp.mc322.lab02;

import java.util.Random;

public class Playlist {
    final int DEFAULT_PLAYLIST_CAPACITY = 10;
    final int SUBSCRIBED_PLAYLIST_CAPACITY = 100;
    private String playlistName;
    private String playlistGenre;
    private final User playlistOwner;
    private final Song[] playlistSongs;
    private int numberOfSongs;
    private int currentSong;

    protected Playlist(String name, String genre, User owner) throws Exception {
        if (name == null || genre == null || owner == null)
            throw new Exception("Not a valid playlist ...");
        this.playlistName = name;
        this.playlistGenre = genre;
        this.playlistOwner = owner;
        this.playlistSongs = new Song[SUBSCRIBED_PLAYLIST_CAPACITY];
        this.numberOfSongs = 0;
        this.currentSong = -1;
        owner.addPlaylist(this);
    }

    public void addSong(Song music) throws Exception {
        if (music == null)
            throw  new Exception("Not a valid song ...");
        if (this.numberOfSongs < SUBSCRIBED_PLAYLIST_CAPACITY) {
            if (this.playlistOwner.isSubscriber())
                this.playlistSongs[this.numberOfSongs] = music;
            else if (this.numberOfSongs < DEFAULT_PLAYLIST_CAPACITY)
                this.playlistSongs[this.numberOfSongs] = music;
            else
                throw new Exception("Playlist capacity exceeded ...\n" +
                        "Owner must be subscriber to increase capacity!");
            this.numberOfSongs++;
        } else
            throw new Exception("Max capacity of songs exceeded ...");
        this.sortSongsByAlphabeticalOrder();
    }

    public void removeSong(String musicName) throws Exception {
        int songIndex;
        if (musicName == null)
            throw new Exception("Not a valid song ...");
        if (this.numberOfSongs > 0) {
            songIndex = searchSong(musicName);
            if (songIndex >= 0) {
                if (this.numberOfSongs - 1 - songIndex >= 0)
                    System.arraycopy(this.playlistSongs, songIndex + 1,
                            this.playlistSongs, songIndex, this.numberOfSongs - 1 - songIndex);
                this.numberOfSongs--;
            } else
                throw new Exception("The " + musicName + " song does not exist ...");
        } else
            throw new Exception("Playlist is empty ...");
    }

    public Song play() throws Exception {
        if (this.numberOfSongs >= 0) {
            if (this.numberOfSongs == this.currentSong)
                this.currentSong = 0;
            else
                this.currentSong++;
            return this.playlistSongs[this.currentSong];
        } else
            throw new Exception("Playlist is empty ...");
    }

    public Song play(boolean shuffle)  throws Exception {
        int randomIndex;
        Random random = new Random();
        if (this.numberOfSongs >= 0) {
            if (shuffle) {
                randomIndex = random.nextInt(this.numberOfSongs);
                if (randomIndex != this.currentSong)
                    this.currentSong = randomIndex;
                else
                    this.currentSong = randomIndex + 1;
                return this.playlistSongs[this.currentSong];
            } else
                return this.play();
        } else
            throw new Exception("Playlist is empty ...");
    }

    public void showInformation() {
        System.out.println("Name: " + this.playlistName + "\nGenre: " + this.playlistGenre
                + "\nNumber of songs: " + this.numberOfSongs + "\nOwner: " +
                this.playlistOwner.getUserName());
    }

    public void showSongs() {
        for (int i = 0; i < this.numberOfSongs; i++) {
            System.out.print("- ");
            this.playlistSongs[i].showInformation();
        }
    }

    public Song getShortestSong() throws Exception {
        Song shortestSong;
        if (this.numberOfSongs >= 0) {
            shortestSong = this.playlistSongs[0];
            for (int i = 1; i < this.numberOfSongs; i++)
                if (shortestSong.getMusicDuration() > this.playlistSongs[i].getMusicDuration())
                    shortestSong = this.playlistSongs[i];
        } else
            throw new Exception("Playlist is empty ...");
        return shortestSong;
    }

    public Song getMostDurableSong() throws Exception {
        Song mostDurableSong;
        if (this.numberOfSongs >= 0) {
            mostDurableSong = this.playlistSongs[0];
            for (int i = 1; i < this.numberOfSongs; i++)
                if (mostDurableSong.getMusicDuration() < this.playlistSongs[i].getMusicDuration())
                    mostDurableSong = this.playlistSongs[i];
        } else
            throw new Exception("Playlist is empty ...");
        return mostDurableSong;
    }

    public double getSongsAverageDuration() {
        int playlistDuration = this.getTotalDuration();
        return ((double) playlistDuration) / this.numberOfSongs;
    }

    public int getTotalDuration() {
        int playlistDuration = 0;
        for (int i = 0; i < this.numberOfSongs; i++)
            playlistDuration += this.playlistSongs[i].getMusicDuration();
        return playlistDuration;
    }

    public String getMostRepeatableArtist() throws Exception {
        if (this.numberOfSongs == 0)
            throw new Exception("Playlist is empty ...");
        int numberOfRepetitions = 0;
        int biggestNumberOfRepetitions = 0;
        String artist;
        String mostRepeatableArtist = this.playlistSongs[0].getMusicArtist();
        boolean[] visited = new boolean[this.numberOfSongs];
        for (int i = 1; i < this.numberOfSongs; i++)
            visited[i] = false;
        for (int i = 0; i < this.numberOfSongs; i++) {
            if (this.playlistSongs[i].getMusicArtist().equals(mostRepeatableArtist)) {
                visited[i] = true;
                biggestNumberOfRepetitions++;
            }
        }
        for (int i = 1; i < this.numberOfSongs; i++) {
            if (!visited[i]) {
                artist = this.playlistSongs[i].getMusicArtist();
                visited[i] = true;
                numberOfRepetitions = 1;
                for (int j = 2; j < this.numberOfSongs; j++) {
                    if (!visited[j] && this.playlistSongs[j].getMusicArtist().equals(artist)) {
                        visited[j] = true;
                        numberOfRepetitions++;
                    }
                }
                if (numberOfRepetitions > biggestNumberOfRepetitions) {
                    mostRepeatableArtist = artist;
                    biggestNumberOfRepetitions = numberOfRepetitions;
                }
            }
        }
        return mostRepeatableArtist;
    }

    private void sortSongsByAlphabeticalOrder() {
        int i, j;
        Song  song;
        for (i = 1; i < this.numberOfSongs; i++) {
            song = this.playlistSongs[i];
            for (j = i; j > 0 &&
                    song.getMusicName().compareTo(this.playlistSongs[j - 1].getMusicName()) < 0; j--)
                this.playlistSongs[j] = this.playlistSongs[j - 1];
            this.playlistSongs[j] = song;
        }
    }

    private int searchSong(String musicName) {
        int mid, left = 0, right = this.numberOfSongs;
        int comparisonResult;
        while (left <= right) {
            mid = (left + right) / 2;
            comparisonResult = this.playlistSongs[mid].getMusicName().compareTo(musicName);
            if (comparisonResult == 0)
                return mid;
            else if (comparisonResult == -1)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public void setPlaylistGenre(String playlistGenre) {
        this.playlistGenre = playlistGenre;
    }

    public String getPlaylistName() {
        return this.playlistName;
    }

    public String getPlaylistGenre() {
        return this.playlistGenre;
    }

    public User getPlaylistOwner() {
        return this.playlistOwner;
    }

    public int getNumberOfSongs() {
        return this.numberOfSongs;
    }

}
