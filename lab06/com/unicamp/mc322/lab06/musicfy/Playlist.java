package com.unicamp.mc322.lab06.musicfy;

import com.unicamp.mc322.lab06.musicfy.media.Media;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Playlist {

    private String name;
    private ArrayList<Media> medias;
    private int currentMedia;
    private boolean assigned;

    public Playlist(String name) {
        Objects.requireNonNull(name, " playlist name");

        this.name = name;
        medias = new ArrayList<>();
        currentMedia = 0;
        assigned = false;
    }

    private boolean isOnPlaylist(Media media) {
        for (Media playlistMedia : medias)
            if (playlistMedia.equals(media))
                return  true;
        return false;
    }

    boolean isAssigned() {
        return assigned;
    }

    void assign() {
        assigned = true;
    }

    void unAssign () {
        assigned = false;
    }

    public boolean isEmpty() {
        return medias.isEmpty();
    }

    public void add(Media media) {
        if (!isOnPlaylist(media) && !assigned) medias.add(media);
    }

    public void remove(Media media) {
        if (isOnPlaylist(media) && !assigned)
            medias.remove(media);
    }

    public double calculateStorage() {
        double storage = 0;

        for (Media media : medias)
            storage += media.calculateStorage();

        return storage;
    }

    public int calculateDuration () {
        int durationInSeconds = 0;

        for (Media media : medias)
            durationInSeconds += media.calculateDuration();

        return durationInSeconds;
    }

    public int calculateAverageDuration() {
        return calculateDuration() / medias.size();
    }

    private void next() {
        if (currentMedia == medias.size())
            currentMedia = 0;
        else
            currentMedia++;
    }

    private Media play(Media media) {
        currentMedia = medias.indexOf(media);
        next();
        return media;
    }

    public Media play(boolean shuffle) {
        if (isEmpty()) return null;

        if (shuffle) {
            Random random = new Random();
            return play(medias.get(random.nextInt(medias.size())));
        }

        return play(medias.get(currentMedia));
    }

    public Media play() {
        return play(false);
    }

    private Media searchMostDurable() {
        Media mostDurable = medias.remove(0);

        for (int i = 1; i < medias.size(); i++)
            if (mostDurable.compareDuration(medias.get(i)) == -1)
                mostDurable = medias.get(i);

        return mostDurable;
    }

    private Media searchLessDurable() {
        Media lessDurable = medias.remove(0);

        for (int i = 1; i < medias.size(); i++)
            if (lessDurable.compareDuration(medias.get(i)) == 1)
                lessDurable = medias.get(i);

        return lessDurable;
    }

    public Media playMostDurable() {
        if (isEmpty()) return  null;
        return play(searchMostDurable());
    }

    public Media playLessDurable() {
        if (isEmpty()) return  null;
        return play(searchLessDurable());
    }

    @Override
    public String toString() {
        int duration = calculateDuration();
        StringBuilder formattedString = new StringBuilder(
                "< PLAYLIST > Name: " + name + " - Duration: " + duration / 60 + ":" + duration % 60  +
                        " - Size: " + String.format("%, .1f", calculateStorage()) + "MB\n"
        );

        for (Media media : medias)
            formattedString.append("\n").append(media.toString()).append("\n");

        return formattedString.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof Playlist)
            return name.equals(((Playlist) other).name) && medias.equals(((Playlist) other).medias);
        return false;
    }

    public void changeName(String newName) {
        Objects.requireNonNull(newName, "playlist name");
        name = newName;
    }

    String getName() {
        return name;
    }

    public Playlist copy() {
        Playlist copy = new Playlist(name);
        copy.medias = medias;
        return copy;
    }

}
