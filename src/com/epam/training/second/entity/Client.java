package com.epam.training.second.entity;

import com.epam.training.second.builder.ClientBuilder;
import com.epam.training.second.entity.tour.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private UUID clientId;
    private String firstName;
    private String lastName;
    private String address;
    private int cardNumber;
    private List<Booking> bookings = new ArrayList<>();

    public Client(ClientBuilder clientBuilder) {
        this.clientId = clientBuilder.getClientId();
        this.firstName = clientBuilder.getFirstName();
        this.lastName = clientBuilder.getLastName();
        this.address = clientBuilder.getAddress();
        this.cardNumber = clientBuilder.getCardNumber();
    }

    public boolean bookTour(Tour tour) {
        Booking booking = new Booking(this, tour);
        bookings.add(booking);
        return true;
    }

    public UUID getClientId() {
        return clientId;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public int getCardNumber() {

        return cardNumber;
    }

    public String getAddress() {

        return address;
    }

    public String getLastName() {

        return lastName;
    }

    public String getFirstName() {

        return firstName;
    }
}
