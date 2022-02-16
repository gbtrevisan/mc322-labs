package com.unicamp.mc322.lab08.twittery.tweet;

public class Retweet extends Publication {

    private final Publication tweet;

    public Retweet(Publication tweet) {
        this.tweet = tweet;
    }

    @Override
    public boolean comment(String authorNickname, String comment) {
        return tweet.comment(authorNickname, comment);
    }

    @Override
    public boolean like(String authorNickname) {
        return tweet.like(authorNickname);
    }

    @Override
    public String show() {
        return "#Retweet\n" + tweet.show();
    }

    @Override
    public void publish() {

    }

    @Override
    public Retweet retweet() {
        return new Retweet(tweet);
    }

    @Override
    public boolean matchTitle(String publicationTitle) {
        return tweet.matchTitle(publicationTitle);
    }

}
