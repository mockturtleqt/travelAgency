package com.epam.training.second.entity;

import com.epam.training.second.action.TourFinder;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.entity.type.Goal;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private String agencyName;
    private String agencyAddress;
    private List<Tour> tours = new ArrayList<>();

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

    public List<Tour> getToursByGoal(Goal goal) {
        return TourFinder.findTour(this, goal);
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
