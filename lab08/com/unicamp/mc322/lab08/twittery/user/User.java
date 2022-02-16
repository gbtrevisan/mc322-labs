package com.unicamp.mc322.lab08.twittery.user;

import com.unicamp.mc322.lab08.twittery.event.*;
import com.unicamp.mc322.lab08.twittery.tweet.Publication;
import com.unicamp.mc322.lab08.twittery.tweet.Tweet;
import com.unicamp.mc322.lab08.twittery.tweet.content.Content;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class User {

    private final String name;
    private final String email;
    private final String password;
    private final Genre genre;
    private final String country;
    private final LocalDate birthDate;
    private final String nickname;
    private final ArrayList<Follow> followers;
    private final ArrayList<Follow> following;
    private final ArrayList<Publication> publications;
    private final ArrayList<Event> notifications;
    private boolean logged;

    public User (String name, String email, String password, Genre genre, String country, LocalDate birthDate, String nickname) {
        Objects.requireNonNull(name, "name");
        Objects.requireNonNull(email, "email");
        Objects.requireNonNull(password, "password");
        Objects.requireNonNull(country, "country");
        Objects.requireNonNull(birthDate, "birthDate");
        Objects.requireNonNull(nickname, "nickname");

        this.name = name;
        this.email = email;
        this.password = password;
        this.genre = genre;
        this.country = country;
        this.birthDate = birthDate;
        this.nickname = nickname;
        followers = new ArrayList<>();
        following = new ArrayList<>();
        publications = new ArrayList<>();
        notifications = new ArrayList<>();
        logged = false;
    }

    public boolean login(String nickname, String password) {
        if (nickname.equals(this.nickname) && password.equals(this.password)) {
            logged = true;
            return true;
        }
        return false;
    }

    public boolean isLogged() {
        return logged;
    }

    public void logout() {
        logged = false;
    }

    public void follow(User user) {
        if (logged && !following.contains(new Follow(nickname, user))) {
            following.add(new Follow(nickname, user));
            user.followers.add(new Follow(nickname, user));
            user.notifications.add(new Follow(nickname, user));
        }
    }

    public void publish(Content content, String title) {
        if (logged) {
            Tweet tweet = new Tweet(nickname, title, content);
            publications.add(tweet);
            tweet.publish();
        }
    }

    public boolean matchNickname(String otherNickname) {
        return otherNickname.equals(nickname);
    }

    public boolean matchEmail(String otherEmail) {
        return otherEmail.equals(email);
    }

    private User searchOnFollowing(String nickname) {
        for (Follow follow : following) {
            if (follow.follows(nickname)) {
                return follow.getTarget();
            }
        }
        return null;
    }

    private Publication searchPublicationOnFollowing(User user, String publicationTitle) {
        for (Publication publication : user.publications) {
                if (publication.matchTitle(publicationTitle))
                    return publication;
        }
        return null;
    }

    public boolean like(String authorNickname, String publicationTitle) {
        User userFollowing = searchOnFollowing(authorNickname);
        if (logged && userFollowing != null) {
            Publication publication = searchPublicationOnFollowing(userFollowing, publicationTitle);
            if (publication != null) {
                publication.like(nickname);
                userFollowing.notifications.add(new Like(nickname, publicationTitle));
                return true;
            }
        }
        return false;
    }

    public boolean comment(String authorNickname, String publicationTitle, String comment) {
        User userFollowing = searchOnFollowing(authorNickname);
        if (logged && userFollowing != null) {
            Publication publication = searchPublicationOnFollowing(userFollowing, publicationTitle);
            if (publication != null) {
                publication.comment(nickname, comment);
                userFollowing.notifications.add(new Comment(nickname, comment, publicationTitle));
                return true;
            }
        }
        return false;
    }

    public boolean retweet(String authorNickname, String publicationTitle) {
        User userFollowing = searchOnFollowing(authorNickname);
        if (logged && userFollowing != null) {
            Publication publication = searchPublicationOnFollowing(userFollowing, publicationTitle);
            if (publication != null) {
                Publication retweet = publication.retweet();
                publications.add(retweet);
                userFollowing.notifications.add(new RetweetEvent(nickname, publicationTitle));
                return true;
            }
        }
        return false;
    }

    public String showPublications() {
        StringBuilder formattedPublications = new StringBuilder();
        for (Publication publication : publications)
            formattedPublications.append(publication.show()).append("\n\n");
        return formattedPublications.toString();
    }

    public String showNotifications() {
        StringBuilder formattedNotifications = new StringBuilder("YOU HAVE " + notifications.size() + " NEW NOTIFICATIONS:\n");
        for (Event notification : notifications)
            formattedNotifications.append(notification.show()).append("\n");
        notifications.clear();
        return formattedNotifications.toString();
    }

    public String showInformation() {
        StringBuilder info = new StringBuilder("Name: " + name + "\nEmail: " + email + "\nGenre: ");
        if (!genre.equals(Genre.NOT_SPECIFIED))
            info.append(genre);
        info.append("\nCountry: ").append(country).append("\nBirth Date: ").append(birthDate).append("\nNickname: ").append(nickname);
        return info.toString();
    }

    public String showFollowing() {
        StringBuilder formattedFollowing = new StringBuilder("YOU ARE FOLLOWING:\n");
        for (Follow follow : following)
            formattedFollowing.append(follow.show()).append("\n");
        return formattedFollowing.toString();
    }

    public String showFollowers() {
        StringBuilder formattedFollowers = new StringBuilder("YOU HAVE " + followers.size() + " FOLLOWERS\n");
        for (Follow follower : followers)
            formattedFollowers.append(follower.show()).append("\n");
        return formattedFollowers.toString();
    }

    @Override
    public String toString() {
        return nickname;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other instanceof User)
            return ((User) other).nickname.equals(nickname) || ((User) other).email.equals(email);
        return false;
    }

}
