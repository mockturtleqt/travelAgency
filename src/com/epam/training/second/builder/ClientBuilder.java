package com.epam.training.second.builder;

import com.epam.training.second.entity.Client;

import java.util.UUID;

public class ClientBuilder {
    private UUID clientId;
    private String firstName;
    private String lastName;
    private String address;
    private int cardNumber;

    public ClientBuilder(String firstName, String lastName, int cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.clientId = UUID.randomUUID();
    }

    public ClientBuilder address(String address) {
        this.address = address;
        return this;
    }

    public Client build() {
        return new Client(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public UUID getClientId() {

        return clientId;
    }
}
