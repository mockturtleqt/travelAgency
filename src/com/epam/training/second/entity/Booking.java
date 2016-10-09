package com.epam.training.second.entity;

import com.epam.training.second.entity.tour.Tour;

public class Booking {
    private Client client;
    private Tour tour;

    public Booking(Client client, Tour tour) {
        this.client = client;
        this.tour = tour;
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

    @Override
    public String toString() {
        return "Booking {" + client +
                ", Tour { tour name = " + tour.getTourName() + '}';
    }
}
