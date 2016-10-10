package com.epam.training.second.entity;

import com.epam.training.second.entity.tour.Tour;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private String agencyName;
    private String agencyAddress;
    private List<Tour> tours = new ArrayList<>();

    public Agency() {}

    public Agency(String agencyName) {
        this.agencyName = agencyName;
    }

    public boolean addTour(Tour tour) {
        tours.add(tour);
        return true;
    }

    public List<Tour> getTours() {

        return tours;
    }

    public String getAgencyName() {

        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyAddress() {

        return agencyAddress;
    }

    public void setAgencyAddress(String agencyAddress) {
        this.agencyAddress = agencyAddress;
    }
}
