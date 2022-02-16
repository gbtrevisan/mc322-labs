package com.unicamp.mc322.lab02;

public class Musicfy {

    public static void main(String[] args) throws Exception {

        User user1 = new User("Marcos Paulo", "777.777.777-77", "24/03/2001", "Male");
        User user2 = new User("Cookiezi", "111.111.11-11");

        Song song1 = new Song("Seven Nation Army", "Rock", "The White Stripes",
                120);
        Song song2 = new Song("Crazy Train", "Rock", "Ozzy Osbourne", 90);
        Song song3 = new Song("Feels", "Pop", "Calvin Harris", 100);
        Song song4 = new Song("Roar", "Pop", "Katy Perry", 130);
        Song song5 = new Song("Anima", "Hardcore", "Xi", 80);
        Song song6 = new Song("Freedom Dive", "Hardcore", "Xi", 150);
        Song song7 = new Song("Teo", "Hardcore", "Omoi", 70);
        Song song8 = new Song("Sleepwalking", "Metalcore", "Bring Me The Horizon",
                85);

        Playlist rockPlaylist = new Playlist("Awesome Rock Songs", "Rock", user1);
        rockPlaylist.addSong(song1);
        rockPlaylist.addSong(song2);

        Playlist osuPlaylist = new Playlist("Osu Memories", "hardcore", user2);
        osuPlaylist.addSong(song5);
        osuPlaylist.addSong(song6);
        osuPlaylist.addSong(song7);

        Playlist metalcorePlaylist = new Playlist("Best of Metalcore", "Metalcore", user1);
        metalcorePlaylist.addSong(song8);

        user1.showPlaylists();
        System.out.println("");
        user2.showInformation();

        Song asong1 = osuPlaylist.play();
        Song asong2 = osuPlaylist.play();
        Song asong3 = osuPlaylist.play(true);
    }

}
