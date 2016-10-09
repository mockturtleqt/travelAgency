package com.epam.training.second.builder;

import com.epam.training.second.entity.Client;

import java.util.UUID;

public class ClientBuilder {
    private UUID clientId;
    private String firstName;
    private String lastName;
    private String address;
    private long cardNumber;

    public ClientBuilder(String firstName, String lastName, long cardNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
    }

    public ClientBuilder address(String address) {
        this.address = address;
        return this;
    }

    public Client build() {
        this.clientId = UUID.randomUUID();

        return new Client(this.clientId, this.firstName, this.lastName, this.address, this.cardNumber);
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

    public long getCardNumber() {
        return cardNumber;
    }

    public UUID getClientId() {

        return clientId;
    }
}
