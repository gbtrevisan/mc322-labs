package com.unicamp.mc322.lab08.twittery.tweet;

import com.unicamp.mc322.lab08.twittery.event.Comment;
import com.unicamp.mc322.lab08.twittery.event.Like;
import com.unicamp.mc322.lab08.twittery.tweet.content.Content;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Tweet extends Publication {

    private final String authorNickname;
    private final Title title;
    private final Content content;
    private LocalDate publishDate;
    private final ArrayList<Like> likes;
    private final ArrayList<Comment> comments;

    public Tweet(String authorNickname, String title, Content content) {
        Objects.requireNonNull(authorNickname, "authorNickname");
        Objects.requireNonNull(title, "publication title");
        Objects.requireNonNull(content, "publication content");

        this.authorNickname = authorNickname;
        this.title = new Title(title);
        this.content = content;
        likes = new ArrayList<>();
        comments = new ArrayList<>();
    }

    @Override
    public boolean comment(String authorNickname, String comment) {
        if (isPublished()) {
            comments.add(new Comment(authorNickname, comment, title.toString()));
            return true;
        } else return false;
    }

    @Override
    public boolean like(String authorNickname) {
        if (isPublished()) {
            likes.add(new Like(authorNickname, title.toString()));
            return true;
        } else return false;
    }

    @Override
    public void publish() {
        publishDate = LocalDate.now();
    }

    @Override
    public Retweet retweet() {
        return new Retweet(this);
    }

    @Override
    public boolean matchTitle(String publicationTitle) {
        return title.equals(new Title(publicationTitle));
    }

    public boolean isPublished() {
        return publishDate != null;
    }

    public boolean matchDate(Tweet tweet) {
        return isPublished() && tweet.isPublished() && tweet.publishDate.equals(publishDate);
    }

    @Override
    public String show() {
        if (isPublished()) {
            StringBuilder tweet = new StringBuilder(
                    "@" + authorNickname + " - " + publishDate + "\n" + title + "\n\n" + content.show() +
                            "\n\nLikes: " + likes.size() + " Comments: " + comments.size() + "\n\n"
            );

            for (Comment comment : comments)
                tweet.append(comment).append("\n");

            return tweet.toString();
        } return "Publication was not published yet!";
    }

}
