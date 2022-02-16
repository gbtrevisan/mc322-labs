package com.unicamp.mc322.lab07.frogy;

import java.util.Scanner;

public class GameIO {

    private static final Scanner input = new Scanner(System.in);

    protected static void display(String text) {
        System.out.println(text);
    }

    protected static void displayBlankLine() {
        System.out.println();
    }

    protected static void displayWelcomeMessage() {
        display("* Welcome to Frogy! *");
        displayBlankLine();
    }

    protected static void displayGoodbyeMessage() {
        display("Leaving Frogy...Goodbye!");
        displayBlankLine();
    }

    protected static void displayTutorialMessage() {
        display("To move, type: W, A, S or D\n" + "To leave: any");
        displayBlankLine();
    }

    protected static Command nextCommand() {
        System.out.print("Command: ");
        String command = input.nextLine();
        displayBlankLine();

        switch (command.toUpperCase()) {
            case "W":
                return Command.MOVE_FORWARD;
            case "A":
                return Command.MOVE_LEFT;
            case "S":
                return Command.MOVE_BACKWARDS;
            case "D":
                return Command.MOVE_RIGHT;
            default:
                return Command.EXIT;
        }
    }

}
