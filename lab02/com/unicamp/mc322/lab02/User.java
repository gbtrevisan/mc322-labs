package com.unicamp.mc322.lab02;

public class User {
    final int DEFAULT_USER_CAPACITY = 3;
    final int SUBSCRIBED_USER_CAPACITY = 10;
    private String userName;
    private String userCpf;
    private String userBirthDate;
    private String userGenre;
    private boolean subscriber;
    private final Playlist[] userPlaylists;
    private int numberOfPlaylists;

    protected User(String name, String cpf) throws Exception {
        if (name == null || cpf == null)
            throw new Exception("Not a valid user ...");
        this.userName = name;
        this.userCpf = cpf;
        this.userBirthDate = null;
        this.userGenre = null;
        this.subscriber = false;
        this.userPlaylists = new Playlist[SUBSCRIBED_USER_CAPACITY];
        this.numberOfPlaylists = 0;

    }

    protected User(String name, String cpf, String birthDate, String genre) throws Exception {
        this(name , cpf);
        this.userBirthDate = birthDate;
        this.userGenre = genre;
    }

    protected User(String name, String cpf, String birthDate, String genre, boolean subscriber) throws Exception {
        this(name , cpf, birthDate, genre);
        this.subscriber = subscriber;
    }

    public void subscribe() throws Exception {
        if (!this.subscriber)
            this.changeSignature();
        else
            throw new Exception("User already a subscriber ...");
    }

    public void unSubscribe() throws Exception {
        if (this.subscriber) {
            if (this.numberOfPlaylists > DEFAULT_USER_CAPACITY)
                throw new Exception("User have " + this.numberOfPlaylists + " ...\n" +
                        "To unsubscribe, first remove " + (this.numberOfPlaylists - 3) +
                        " playlists!");
            else
                for (int i = 0; i < this.numberOfPlaylists; i++) {
                    if (this.userPlaylists[i].getNumberOfSongs() > this.userPlaylists[i].DEFAULT_PLAYLIST_CAPACITY)
                        throw new Exception("User have playlists that exceed the capacity of unsubscribed plan ...\n" +
                                "To unsubscribe, first remove the playlists with more than " +
                                this.userPlaylists[i].DEFAULT_PLAYLIST_CAPACITY + " songs!");
                }
            this.changeSignature();
        } else
            throw new Exception("User already unsubscribed ...");
    }

    private void changeSignature() {
        this.subscriber = !this.subscriber;
    }

    public void addPlaylist(Playlist playlist) throws Exception {
        if (playlist == null)
            throw new Exception("Not a valid playlist ...");
        if (this != playlist.getPlaylistOwner())
            throw new Exception("User must be playlist owner");
        if (this.numberOfPlaylists < SUBSCRIBED_USER_CAPACITY) {
            if (this.subscriber)
                this.userPlaylists[this.numberOfPlaylists] = playlist;
            else if (this.numberOfPlaylists < DEFAULT_USER_CAPACITY)
                this.userPlaylists[this.numberOfPlaylists] = playlist;
            else
                throw  new Exception("Capacity of playlists exceeded ...\n " +
                        "Be a subscriber to increase max capacity!");
            this.numberOfPlaylists++;
        } else
            throw new Exception("Max capacity of playlists exceeded ...");
        this.sortPlaylistsByAlphabeticalOrder();
    }

    public void removePlaylist(String playlistName) throws Exception {
        int playlistIndex;
        if (this.numberOfPlaylists > 0) {
            playlistIndex = searchPlaylistIndex(playlistName);
            if  (playlistIndex >= 0) {
                if (this.numberOfPlaylists - 1 - playlistIndex >= 0)
                    System.arraycopy(this.userPlaylists, playlistIndex + 1,
                            this.userPlaylists, playlistIndex, this.numberOfPlaylists - 1 - playlistIndex);
                this.numberOfPlaylists--;
            } else
                throw new Exception("Playlist " + playlistName + " playlist does not exist ...");
        } else
            throw new Exception("User playlists is empty ...");
    }

    public void sharePlaylist(User user, String playlistName) throws Exception {
        if (user == null)
            throw new Exception("Not a valid user ...");
        Playlist playlist, playlistCopy;
        int playlistIndex = this.searchPlaylistIndex(playlistName);
        if (playlistIndex >= 0) {
            playlist = this.userPlaylists[playlistIndex];
            playlistCopy = new Playlist(playlist.getPlaylistName(), playlist.getPlaylistGenre(), user);
            user.addPlaylist(playlistCopy);
        } else
            throw new Exception("The " + playlistName + " playlist does not exist ...");
    }

    public void showInformation() {
        System.out.println("Name: " + this.userName + "\nCPF: " + this.userCpf);
        if (this.userBirthDate != null)
            System.out.println("Birth date: " + this.userBirthDate);
        if (this.userGenre != null)
            System.out.println("Genre: " + this.userGenre);
        System.out.print("Signature: ");
        if (this.subscriber)
            System.out.println("subscriber");
        else
            System.out.println("unsubscribed");
    }

    public void showPlaylists() {
        System.out.println("User: " + this.userName + "\nNumber of playlists: " + this.numberOfPlaylists);
        if (this.numberOfPlaylists > 0) {
            for (int i = 0; i < this.numberOfPlaylists; i++) {
                System.out.println("Playlist " + (i + 1) + ": " + this.userPlaylists[i].getPlaylistName()
                + "\nNumber of songs: " + this.userPlaylists[i].getNumberOfSongs() + "\n" + "Songs:");
                this.userPlaylists[i].showSongs();
            }
        }
    }

    public boolean isSubscriber() {
        return this.subscriber;
    }

    private void sortPlaylistsByAlphabeticalOrder() {
        int i, j;
        Playlist  playlist;
        for (i = 1; i < this.numberOfPlaylists; i++) {
            playlist = this.userPlaylists[i];
            for (j = i; j > 0 &&
                    playlist.getPlaylistName().compareTo(this.userPlaylists[j - 1].getPlaylistName()) < 0; j--)
                this.userPlaylists[j] = this.userPlaylists[j - 1];
            this.userPlaylists[j] = playlist;
        }
    }

    private int searchPlaylistIndex(String playlistName) {
        int mid, left = 0, right = this.numberOfPlaylists;
        int comparisonResult;
        while(left <= right) {
             mid = (left + right) / 2;
             comparisonResult = this.userPlaylists[mid].getPlaylistName().compareTo(playlistName);
             if (comparisonResult == 0)
                 return mid;
             else if (comparisonResult == -1)
                 left = mid + 1;
             else
                 right = mid - 1;
        }
        return -1;
    }

    public Playlist searchPlaylist(String playlistName) throws Exception {
        int playlistIndex = this.searchPlaylistIndex(playlistName);
        if (playlistIndex == - 1)
            throw new Exception("Playlist does not exist ...");
        return this.userPlaylists[playlistIndex];
    }

    public String getUserName() {
        return userName;
    }

    public String getUserCpf() {
        return userCpf;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public String getUserGenre() {
        return userGenre;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserCpf(String userCpf) {
        this.userCpf = userCpf;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public void setUserGenre(String userGenre) {
        this.userGenre = userGenre;
    }

}
