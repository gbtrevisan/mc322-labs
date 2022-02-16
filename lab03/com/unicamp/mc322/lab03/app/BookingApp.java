package com.unicamp.mc322.lab03.app;

import com.unicamp.mc322.lab03.app.io.Terminal;
import com.unicamp.mc322.lab03.hotel.*;
import com.unicamp.mc322.lab03.utils.Address;

public class BookingApp {

    private final Terminal terminal;
    private Hotel currentHotel;
    private User currentUser;

    public BookingApp() {
        terminal = new Terminal();
        currentHotel = null;
        currentUser = null;
    }

    public void start() throws Exception {
        terminal.printWelcomeMessage();
        terminal.printMessage(">> Please, start by adding a user. <<");
        chooseNewUser();
        terminal.printMessage(">> Now please choose a hotel. <<");
        chooseNewHotel();

        BookingOperation operation = terminal.askOperation();

        while (operation != BookingOperation.EXIT) {
            processOperation(operation);
            operation = terminal.askOperation();
        }

        terminal.printGoodbyeMessage();
    }

    private void processOperation(BookingOperation operation) throws Exception {
        switch (operation) {
            case NEW_HOTEL:
                chooseNewHotel();
                break;
            case NEW_USER:
                chooseNewUser();
                break;
            case MAKE_RESERVATION:
                makeReservation();
                break;
            case CANCEL_RESERVATION:
                cancelReservation();
                break;
            case SHOW_HOTEL_AVAILABLE_ROOMS:
                showCurrentHotelAvailableRooms();
                break;
            case SHOW_HOTEL_INFO:
                showHotelInformation();
                break;
            case SHOW_USER_INFO:
                showUserInformation();
                break;
            case EXIT:
                break;
        }
    }

    private void chooseNewHotel() throws  Exception {
        if (currentHotel == null)
            currentHotel = getHotelData();
        else {
            terminal.printWarningTryDeleteData("HOTEL");
            String confirmation = terminal.askConfirmation("choose new hotel");
            if (confirmation.equalsIgnoreCase("YES"))
                currentHotel = getHotelData();
        }
    }

    private void chooseNewUser() throws Exception {
        if (currentUser == null)
            currentUser = getUserData();
        else {
            terminal.printWarningTryDeleteData("USER");
            String confirmation = terminal.askConfirmation("choose new user");
            if (confirmation.equalsIgnoreCase("YES"))
                currentUser = getUserData();
        }
    }

    private void makeReservation() {
        int roomNumber = terminal.askIntCredential("Room number");
        int days = terminal.askIntCredential("Stay days");
        int amount = currentHotel.calculateStayPrice(roomNumber, days);
        if (currentHotel.checkRoomIsAvailable(roomNumber)) {
            if (currentHotel.clientMatchRoom(roomNumber, currentUser.isSmoker()))
                if (currentUser.pay(amount)) {
                    currentHotel.reserveRoom(roomNumber, days);
                    terminal.printMessage("Reserve was successfully created!");
                }
                else terminal.printMessage("Current user can`t afford room " + roomNumber + " ...");
            else terminal.printMessage("Room " + roomNumber + "do not allow smokers!");
        } else terminal.printMessage("Room " + roomNumber + "is already reserved ...");
    }

    private void cancelReservation() {
        final double CASH_BACK_RATE = 0.7;
        int roomNumber = terminal.askIntCredential("Room number");
        int timeReservedInDays = currentHotel.getTimeRoomIsReserved(roomNumber);
        if (!currentHotel.checkRoomIsAvailable(roomNumber)) {
            currentHotel.finishReserve(roomNumber);
            currentUser.receiveBalance((int) (CASH_BACK_RATE * timeReservedInDays));
            terminal.printMessage("Reserve was successfully canceled!");
        } else terminal.printMessage("Reserve does not exist!");
    }

    private void showCurrentHotelAvailableRooms() {
        terminal.printMessage(currentHotel.getRoomsInformation());
        terminal.printMessage(currentHotel.getAvailableRoomsInfo());
        terminal.printBlankLine();
    }

    private void showHotelInformation() {
        terminal.printMessage(currentHotel.getHotelInformation());
        terminal.printBlankLine();
    }

    private void showUserInformation() {
        terminal.printMessage(currentUser.getUserInformation());
        terminal.printBlankLine();
    }

    private Address getAddressData() throws Exception {
        String district = terminal.askStringCredential("District");
        String street = terminal.askStringCredential("Street");
        int number = terminal.askIntCredential("Number");
        String city = terminal.askStringCredential("City");
        String state = terminal.askStringCredential("State");
        String cep = terminal.askStringCredential("CEP");

        return new Address(district, street, number, city, state, cep);
    }

    private Hotel getHotelData() throws Exception {
        terminal.printDefaultFormMessage("HOTEL");
        String name = terminal.askStringCredential("Name");
        String phone = terminal.askStringCredential("Phone");
        int commonDaily = terminal.askIntCredential("Daily (Common)");
        int vipDaily = terminal.askIntCredential("Daily (VIP)");
        Address address = getAddressData();

        return  new Hotel(name, phone, address, commonDaily, vipDaily);
    }

    private User getUserData() throws Exception {
        boolean smoker;
        terminal.printDefaultFormMessage("USER");
        String name = terminal.askStringCredential("Name");
        String cpf = terminal.askStringCredential("CPF");
        String birthDate = terminal.askStringCredential("Birth-date");
        String genre = terminal.askStringCredential("Genre");
        int balance = terminal.askIntCredential("Balance");
        String smokes = terminal.askStringCredential("Smoker ([YES] or [NO])");
        smoker = smokes.equalsIgnoreCase("YES");

        return new User(name, cpf, birthDate, genre, balance, smoker);
    }

    public static void main(String[] args) throws Exception {
        BookingApp app = new BookingApp();
        app.start();
    }

}
