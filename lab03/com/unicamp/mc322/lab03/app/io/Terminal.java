package com.unicamp.mc322.lab03.app.io;

import com.unicamp.mc322.lab03.app.BookingOperation;

import java.util.Scanner;

public class Terminal {

    private final Scanner input;

    public Terminal() {
        input = new Scanner(System.in);
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Java BookingApp!");
    }

    public void printGoodbyeMessage() {
        System.out.println("Closing app ... Goodbye!");
    }

    public void printDefaultFormMessage(String formName) {
        System.out.println("Please insert " + formName + " credentials below ...");
    }

    public void printWarningTryDeleteData(String dataName) {
        System.out.println("If you continue you will delete current " + dataName);
    }

    public String askConfirmation(String operationName) {
        System.out.print("Are you sure you want to continue to " + operationName + "?"
        + "\n[YES] or [NO]:");
        return input.nextLine();
    }

    public BookingOperation askOperation() {
        System.out.println("Please type a operation:\n" +
                "1 - Search a new Hotel\n" +
                "2 - Add a new user\n" +
                "3 - Make a reservation on current hotel\n" +
                "4 - Cancel a existing reservation\n" +
                "5 - See available rooms on current hotel\n" +
                "6 - See current hotel info\n" +
                "7 - See current user info\n" +
                "or any other number to leave the app ...");

        int selected = Integer.parseInt(input.nextLine());
        BookingOperation operation = BookingOperation.EXIT;

        switch (selected) {
            case 1:
                operation = BookingOperation.NEW_HOTEL;
                break;
            case 2:
                operation = BookingOperation.NEW_USER;
                break;
            case 3:
                operation = BookingOperation.MAKE_RESERVATION;
                break;
            case 4:
                operation = BookingOperation.CANCEL_RESERVATION;
                break;
            case 5:
                operation = BookingOperation.SHOW_HOTEL_AVAILABLE_ROOMS;
                break;
            case 6:
                operation = BookingOperation.SHOW_HOTEL_INFO;
                break;
            case 7:
                operation = BookingOperation.SHOW_USER_INFO;
                break;
        }

        return operation;
    }

    public String askStringCredential(String credential) {
        String answer;
        System.out.print(credential  + ": ");
        answer = input.nextLine();
        return answer;
    }

    public int askIntCredential(String credential) {
        String answer;
        System.out.print(credential  + ": ");
        answer = input.nextLine();
        return Integer.parseInt(answer);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printBlankLine() {
        System.out.println();
    }

    public int askInt() {
        return input.nextInt();
    }

    public String askString() {
        return input.nextLine();
    }

}
