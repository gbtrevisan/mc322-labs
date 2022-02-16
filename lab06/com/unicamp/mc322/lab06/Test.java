package com.unicamp.mc322.lab06;

import com.unicamp.mc322.lab06.musicfy.Playlist;
import com.unicamp.mc322.lab06.musicfy.User;
import com.unicamp.mc322.lab06.musicfy.media.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        User user = new User("Gabriel Luiz Trevisan", "098317123-00", LocalDate.of(2002, 2, 25), true);
        Playlist playlist1 = new Playlist("2000");
        Playlist playlist2 = new Playlist("One Piece");

        Media media;

        media = new Song("Lie Lie Lie", "Serj Tankian", 3 * 60 + 35);
        playlist1.add(media);

        ArrayList<Song> songs = new ArrayList<>();
        Song song;
        song = new Song("Dreaming", "System of a down", 4 * 60);
        songs.add(song);
        song = new Song("Tentative", "System of a down", (3 * 60) + 37);
        songs.add(song);
        song = new Song("Metro", "System of a down", 3 * 60);
        songs.add(song);
        song = new Song("Genocidal Humanoidz", "System of a down", 2 * 60 + 34);
        songs.add(song);
        media = new Album("Soad", songs);
        playlist1.add(media);

        media = new Song("Bink`s sake", "Brook", 3 * 60);
        playlist2.add(media);
        media = new Video("Zoro Enma", "AMV", 2 * 60, 1080, 60);
        playlist2.add(media);
        media = new Podcast("Usopp", "Quadro em Branco",60 * 60 + 30 * 60, 3);
        playlist2.add(media);
        media = new Video("Chopper Ending", "Fish", 4 * 60, 1080, 60);
        playlist2.add(media);

        user.add(playlist1);
        user.add(playlist2);

        System.out.println(user.showPlaylists());
    }

}
