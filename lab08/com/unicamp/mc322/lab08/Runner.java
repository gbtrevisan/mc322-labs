package com.unicamp.mc322.lab08;

import com.unicamp.mc322.lab08.twittery.Twittery;
import com.unicamp.mc322.lab08.twittery.tweet.content.Image;
import com.unicamp.mc322.lab08.twittery.tweet.content.Video;
import com.unicamp.mc322.lab08.twittery.tweet.content.extension.ImageExtension;
import com.unicamp.mc322.lab08.twittery.tweet.content.extension.VideoExtension;
import com.unicamp.mc322.lab08.twittery.user.Genre;

import java.time.LocalDate;

public class Runner {

    public static void main(String[] args) {

        Twittery twittery = new Twittery();

        twittery.subscribe("Joao Costa", "joaoc@gmail.com", "jo@o12345", Genre.MALE, "Brasil", LocalDate.of(1986, 5, 2), "joaoc");
        twittery.subscribe("Maria Silva", "msilva@outlook.com", "m@ria@", Genre.FEMALE, "Argentina", LocalDate.of(1975, 4, 6), "msilva");
        twittery.subscribe("Carlos Vargas", "carlos.vargas@gmail.com", "carlos123", Genre.MALE, "Brasileiro", LocalDate.of(2001, 12, 21), "varguinhas");

        if (twittery.authenticate("joaoc", "jo@o12345")) {
            twittery.follow("joaoc", "msilva");
            twittery.follow("joaoc", "varguinhas");
        }

        if (twittery.authenticate("msilva", "m@ria@")) {
            twittery.follow("msilva", "joaoc");
            twittery.follow("msilva", "varguinhas");
        }

        if (twittery.authenticate("varguinhas", "carlos123")) {
            twittery.follow("varguinhas", "joaoc");
        }

        twittery.publish("joaoc", "Primeiro dia na praia", new Video("Praia", 20 * 60, VideoExtension.AVI));
        twittery.like("varguinhas", "joaoc", "Primeiro dia na praia");
        twittery.comment("varguinhas", "joaoc", "Primeiro dia na pria", "Parabens pelo passeio");

        twittery.publish("varguinhas", "Cachorro dormindo", new Image("Cachorro", 1080, ImageExtension.GIF,"Cachorro de medio porte, peludinho e vira lata. Cachorro esta dormindo na grama em frente a sua casinha."));
        twittery.like("joaoc", "varguinhas", "Cachorro dormindo");
        twittery.like("msilva", "varguinhas", "Cachorro dormindo");
        twittery.retweet("joaoc", "varguinhas", "Cachorro dormindo");
        twittery.comment("msilva", "varguinhas", "Cachorro dormindo", "Como cresceu seu cachorro");

        twittery.showUserInfo("joaoc");
        twittery.showPublications("joaoc");
        twittery.showFollowing("joaoc");
        twittery.showFollowers("joaoc");
        twittery.showNotifications("joaoc");

        twittery.showUserInfo("msilva");
        twittery.showPublications("msilva");
        twittery.showFollowing("msilva");
        twittery.showFollowers("msilva");
        twittery.showNotifications("msilva");

        twittery.showUserInfo("varguinhas");
        twittery.showPublications("varguinhas");
        twittery.showFollowing("varguinhas");
        twittery.showFollowers("varguinhas");
        twittery.showNotifications("varguinhas");
    }

}
