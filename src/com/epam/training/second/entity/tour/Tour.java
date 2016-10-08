package com.epam.training.second.entity.tour;

import com.epam.training.second.entity.Destination;
import com.epam.training.second.entity.Food;
import com.epam.training.second.entity.Goal;
import com.epam.training.second.entity.Transportation;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public abstract class Tour {
    protected UUID tourId;
    protected String tourName;
    protected String description;
    protected Destination destination;
    protected Goal goal;
    protected Transportation transportation;
    protected Food food;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected Period duration;
    protected double price;

    public String getTourName() {
        return tourName;
    }

    public UUID getTourId() {
        return tourId;
    }

    public Destination getDestination() {
        return destination;
    }

    public Goal getGoal() {
        return goal;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public Food getFood() {
        return food;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public Period getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }
}
