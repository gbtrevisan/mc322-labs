package com.unicamp.mc322.lab03.utils;

import javax.management.BadAttributeValueExpException;

public class Address {

    private String district;
    private String street;
    private int number;
    private String city;
    private String state;
    private String cep;

    public Address
            (String district, String street, int number, String city, String state, String cep)
            throws Exception
    {
        if (district == null || street == null || city == null || state == null || cep == null)
            throw new BadAttributeValueExpException("Address can`t be null!");

        if (number <= 0)
            throw new BadAttributeValueExpException("Not a valid address number!");

        this.district = district;
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    public void changeDistrict(String newDistrict) throws Exception {
        if (newDistrict == null)
            throw new BadAttributeValueExpException("District address can`t be null!");

        this.district = newDistrict;
    }

    public void changeStreet(String newStreet) throws Exception {
        if (newStreet == null)
            throw new BadAttributeValueExpException("Street address can`t be null!");

        this.street = newStreet;
    }

    public void changeNumber(int newNumber) throws Exception {
        if (newNumber <= 0)
            throw new BadAttributeValueExpException("Not a valid address number!");

        this.number = newNumber;
    }

    public void changeCity(String newCity) throws Exception {
        if (newCity == null)
            throw new BadAttributeValueExpException("City address can`t be null!");

        this.city = newCity;
    }

    public void changeState(String newState) throws Exception {
        if (newState == null)
            throw new BadAttributeValueExpException("State address can`t be null!");

        this.state = newState;
    }

    public void changeCep(String newCep) throws Exception {
        if (cep == null)
            throw new BadAttributeValueExpException("CEP can`t be bull!");

        this.cep = newCep;
    }

    public String getAddressInformation() {
        final String NEXT_LINE = "\n";
        return "District: " + this.district +
                NEXT_LINE + "Street: " + this.street + ", " + this.number +
                NEXT_LINE + "City: " + this.city +
                NEXT_LINE + "State: " + this.state +
                NEXT_LINE + "CEP: " + this.cep;
    }

}
