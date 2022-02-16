package com.unicamp.mc322.lab06.musicfy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class User {

    public final int UNSUBSCRIBED_CAPACITY = 200;
    public final int SUBSCRIBED_CAPACITY = 900;

    private String name;
    private final String cpf;
    private LocalDate birthDate;
    private Genre genre;
    private boolean subscriber;
    private final ArrayList<Playlist> playlists;
    private double freeStorage;

    public User(String name, String cpf, LocalDate date, Genre genre, boolean subscriber) {
        Objects.requireNonNull(name, "user name");
        Objects.requireNonNull(cpf, "user cpf");
        Objects.requireNonNull(date, "user birth date");

        this.name = name;
        this.cpf = cpf;
        birthDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
        this.genre = genre;
        this.subscriber = subscriber;
        playlists = new ArrayList<>();

        if (subscriber)
            freeStorage = SUBSCRIBED_CAPACITY;
        else
            freeStorage = UNSUBSCRIBED_CAPACITY;
    }

    public User(String name, String cpf, LocalDate date) {
        this(name, cpf, date, Genre.None, false);
    }

    public User(String name, String cpf, LocalDate date, Genre genre) {
        this(name, cpf, date, genre, false);
    }

    public User(String name, String cpf, LocalDate date, boolean subscriber) {
        this(name, cpf, date, Genre.None, subscriber);
    }

    private boolean supports(Playlist playlist) {
        return (freeStorage - playlist.calculateStorage() >= 0);
    }

    private Playlist searchByName(String name) {
        for (Playlist playlist : playlists)
            if (playlist.getName().equals(name))
                return playlist;
        return null;
    }

    public boolean add(Playlist playlist) {
        if (playlists.contains(playlist))
            return false;
        if (supports(playlist) && !playlist.isAssigned()) {
            playlists.add(playlist);
            freeStorage = freeStorage - playlist.calculateStorage();
            playlist.assign();
            return true;
        }
        return  false;
    }

    public boolean remove(Playlist playlist) {
        if (playlists.contains(playlist)) {
            playlists.remove(playlist);
            freeStorage = freeStorage + playlist.calculateStorage();
            playlist.unAssign();
            return true;
        }
        return false;
    }

    public boolean transfer(User otherUser, String playlistName) {
        Playlist playlist = searchByName(playlistName);
        if (playlist == null)
            return false;
        return otherUser.add(playlist.copy());
    }

    public boolean subscribe() {
        if (!subscriber) {
            freeStorage = freeStorage + (SUBSCRIBED_CAPACITY - UNSUBSCRIBED_CAPACITY);
            subscriber = true;
            return true;
        }
        return false;
    }

    public boolean unsubscribe() {
        if (subscriber && freeStorage - (SUBSCRIBED_CAPACITY - UNSUBSCRIBED_CAPACITY) >= 0) {
            freeStorage = freeStorage - (SUBSCRIBED_CAPACITY - UNSUBSCRIBED_CAPACITY);
            subscriber = false;
            return true;
        }
        return false;
    }

    public String showPlaylists() {
        StringBuilder formattedString = new StringBuilder();

        for (Playlist playlist : playlists)
            formattedString.append(playlist).append("\n");

        return formattedString.toString();
    }

    @Override
    public String toString() {
        return "User name: " + name + "\nCPF: " + cpf + "\nBirth date: " + birthDate + "\nGenre:" + genre;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof User)
            return cpf.equals(((User) other).cpf);
        return false;
    }

    public boolean changeName(String newName) {
        if (newName == null)
            return false;
        name = newName;
        return true;
    }

    public boolean changeBirthDate(LocalDate date) {
        if (date == null)
            return false;
        birthDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
        return true;
    }

    public void changeGenre(Genre newGenre) {
        genre = newGenre;
    }

}
