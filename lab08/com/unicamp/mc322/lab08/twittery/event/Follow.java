package com.unicamp.mc322.lab08.twittery.event;

import com.unicamp.mc322.lab08.twittery.tweet.Publication;
import com.unicamp.mc322.lab08.twittery.user.User;

import java.util.Objects;

public class Follow extends Event {

    private final User target;

    public Follow(String authorNickname, User target) {
        super(authorNickname);
        Objects.requireNonNull(target, "target");
        this.target = target;
    }

    public User getTarget() {
        return target;
    }

    public boolean follows(String targetNickname) {
        return target.matchNickname(targetNickname);
    }

    @Override
    public String show() {
        return super.show() + " : followed " + target;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other instanceof Follow)
            return target.equals(((Follow) other).target);
        return false;
    }

}
