package com.epam.training.second.entity;

import com.epam.training.second.action.TourBooker;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    Logger logger = Logger.getLogger(Client.class);

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

    public void bookTour(String tourName, Agency agency) {
        TourBooker.bookTour(agency, this, tourName);
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

    @Override
    public String toString() {
        return "Client { " +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                '}';
    }
}
