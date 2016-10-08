package com.epam.training.second.entity;

import com.epam.training.second.entity.tour.Tour;

public class Booking {
    private Client client;
    private Tour tour;

    public Booking(Client client, Tour tour) {
        this.client = client;
        this.tour = tour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (!client.equals(booking.client)) return false;
        return tour.equals(booking.tour);

    }

    @Override
    public int hashCode() {
        int result = client.hashCode();
        result = 31 * result + tour.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "client=" + client +
                ", tour=" + tour +
                '}';
    }

    public Tour getTour() {

        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Client getClient() {

        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
