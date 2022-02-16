package com.unicamp.mc322.lab08.twittery.tweet.content;

import java.util.Objects;

public class Text extends Content {

    public final int MAX_WORDS = 1200;

    private final String text;
    private final String language;

    public Text(String text, String language) {
        Objects.requireNonNull(text, "text");
        Objects.requireNonNull(language, "language");

        if (countWords(text) > MAX_WORDS) throw new RuntimeException("Text max words exceeded!");

        this.text = text;
        this.language = language;
    }

    private int countWords(String text) {
        int words = 1;

        char[] chars = text.toCharArray();

        for (char aChar : chars)
            if (aChar == ' ')
                words++;

        return words;
    }

    @Override
    public String show() {
        return text;
    }

    @Override
    public String toString() {
        return "Content: " + text + "- Language: " + language;
    }

}
