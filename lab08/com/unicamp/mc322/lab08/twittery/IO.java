package com.unicamp.mc322.lab08.twittery;

import java.util.Scanner;

public class IO {

    private final Scanner input = new Scanner(System.in);

    public static void display(String text) {
        System.out.println(text);
    }

    public static void displayBlankLine() {
        System.out.println();
    }

}
