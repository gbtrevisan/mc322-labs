package com.unicamp.mc322.lab08.twittery;

import com.unicamp.mc322.lab08.twittery.tweet.content.Content;
import com.unicamp.mc322.lab08.twittery.user.Genre;
import com.unicamp.mc322.lab08.twittery.user.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class Twittery {

    public final int ALLOWED_AGE = 18;

    private final ArrayList<User> users;

    public Twittery() {
        users = new ArrayList<>();
    }

    public boolean authenticate(String nickname, String password) {
        for (User user : users)
            if (user.matchNickname(nickname))
                return user.login(nickname, password);
        IO.display("Nickname does not exist.\n");
        return false;
     }

    private boolean isEighteen(LocalDate userBirthDate) {
        return LocalDate.now().getYear() - userBirthDate.getYear() >= ALLOWED_AGE;
    }

    private boolean nicknameIsTaken(String nickname) {
        for (User user : users)
            if (user.matchNickname(nickname))
                return true;
        return false;
    }

    private boolean emailIsTaken(String email) {
        for (User user : users)
            if (user.matchEmail(email))
                return true;
        return false;
    }

    public boolean subscribe(String name, String email, String password, Genre genre, String country, LocalDate birthDate, String nickname) {
        if (isEighteen(birthDate) && !nicknameIsTaken(nickname) && !emailIsTaken(email)) {
            users.add(new User(name, email, password, genre, country, birthDate, nickname));
            return true;
        } else return false;
    }

    private User searchUser(String nickname) {
        for (User user : users)
            if (user.matchNickname(nickname))
                return user;
        return null;
    }

    public boolean publish(String nickname, String title, Content content) {
        User user = searchUser(nickname);
        if (user != null) {
            user.publish(content, title);
            return true;
        } else return false;
    }

    public boolean comment(String commentAuthorNickname, String publicationAuthorNickname, String publicationTitle, String comment) {
        User commentAuthor = searchUser(commentAuthorNickname);
        User publicationAuthor = searchUser(publicationAuthorNickname);
        if (commentAuthor != null && publicationAuthor != null)
            return commentAuthor.comment(publicationAuthorNickname, publicationTitle, comment);
        return false;
    }

    public boolean like(String likeAuthorNickname, String publicationAuthorNickname, String publicationTitle) {
        User likeAuthor = searchUser(likeAuthorNickname);
        User publicationAuthor = searchUser(publicationAuthorNickname);
        if (likeAuthor != null && publicationAuthor != null)
            return likeAuthor.like(publicationAuthorNickname, publicationTitle);
        return false;
    }

    public boolean retweet(String userNickname, String authorNickname, String publicationTitle) {
        User user = searchUser(userNickname);
        User author = searchUser(authorNickname);
        if (user != null && author != null)
            return user.retweet(authorNickname, publicationTitle);
        return false;
    }

    public boolean follow(String userNickname, String targetNickname) {
        User user = searchUser(userNickname);
        User target = searchUser(targetNickname);
        if (user != null && target != null) {
            user.follow(target);
            return true;
        } else return false;
    }

    public void showPublications(String userNickname) {
        User user = searchUser(userNickname);
        if (user != null)
            IO.display(user.showPublications());
    }

    public void showNotifications(String userNickname) {
        User user = searchUser(userNickname);
        if (user != null)
            IO.display(user.showNotifications());
    }

    public void showFollowing(String userNickname) {
        User user = searchUser(userNickname);
        if (user != null)
            IO.display(user.showFollowing());
    }

    public void showFollowers(String userNickname) {
        User user = searchUser(userNickname);
        if (user != null)
            IO.display(user.showFollowers());
    }

    public void showUserInfo(String userNickname) {
        User user = searchUser(userNickname);
        if (user != null)
            IO.display(user.showInformation());
        IO.displayBlankLine();
    }

}
