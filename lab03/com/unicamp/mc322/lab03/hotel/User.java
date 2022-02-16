package com.unicamp.mc322.lab03.hotel;

public class User {

    private final String name;
    private final String cpf;
    private final String birthDate;
    private final String genre;
    private int balance;
    private final boolean smoker;

    public User(String name, String cpf, String birthDate, String genre, int balance, boolean smoker)
            throws Exception
    {
        if (name == null || cpf == null || birthDate == null || genre == null)
            throw new Exception("User fields can`t be null!");

        if (balance < 0)
            throw new Exception("User balance can`t be negative!");

        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.genre = genre;
        this.balance = balance;
        this.smoker = smoker;
    }

    public int checkBalance() {
        return balance;
    }

    public boolean pay(int amount) {
        if (balance < amount)
            return false;
        balance = balance - amount;
        return true;
    }

    public void receiveBalance(int amount) {
        balance = balance + amount;
    }

    public boolean isSmoker() {
        return smoker;
    }

    public String getUserInformation() {
        StringBuilder formattedString = new StringBuilder("Name: " + name +
                "\nCPF: " + cpf +
                "\nBirth date: " + birthDate +
                "\nGenre: " + genre +
                "\nSmoker: ");
        if (smoker)
            formattedString.append("YES");
        else
            formattedString.append("NO");
        return formattedString.toString();
    }

}
