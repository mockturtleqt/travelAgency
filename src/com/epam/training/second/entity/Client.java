package com.epam.training.second.entity;

import com.epam.training.second.entity.tour.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    private UUID clientId;
    private String firstName;
    private String lastName;
    private String address;
    private long cardNumber;
    private List<Booking> bookings = new ArrayList<>();

    public Client(UUID clientId, String firstName, String lastName, String address, long cardNumber) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cardNumber = cardNumber;
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

    public long getCardNumber() {

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
