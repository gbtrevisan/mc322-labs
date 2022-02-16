package com.unicamp.mc322.lab04.pidao;


public class UserRecord {

    private User[] users;
    private int size;
    private int usersNumber;


    UserRecord() {
        size = 100;
        users = new User[size];
        usersNumber = 0;
    }

    private void increaseSize() {
        User[] usersCopy;
        if (usersNumber == size) {
            usersCopy = new User[size * 2];
            if (usersNumber >= 0)
                System.arraycopy(users, 0, usersCopy, 0, usersNumber);
            users = usersCopy;
            size = size * 2;
        }
    }

    boolean isNotOnRecord(User user) {
        for (int i = 0; i < usersNumber; i++)
            if (users[i].equals(user))
                return false;
        return true;
    }

    void registerUser(User user) throws Exception {
        if (user == null)
            throw new Exception("User cant be null!");
        if (isNotOnRecord(user)) {
            users[usersNumber] = user;
            usersNumber++;
            increaseSize();
        }
    }

}
