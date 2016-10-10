package com.epam.training.second.builder.tour;

import com.epam.training.second.entity.type.Destination;
import com.epam.training.second.entity.type.Food;
import com.epam.training.second.entity.type.Goal;
import com.epam.training.second.entity.type.Transportation;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;

import java.time.LocalDate;
import java.util.UUID;

public abstract class TourBuilder {
    protected final String DEFAULT_DATE = "2000-01-01";

    protected UUID tourId;
    protected String tourName;
    protected String description;
    protected Destination destination;
    protected Goal goal;
    protected Transportation transportation;
    protected Food food;
    protected LocalDate startDate = LocalDate.parse(DEFAULT_DATE);
    protected LocalDate endDate = LocalDate.parse(DEFAULT_DATE);
    protected float price;

    public abstract Tour build() throws WrongTourException;

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTourId(UUID tourId) {
        this.tourId = tourId;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public UUID getTourId() {
        return tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public String getDescription() {
        return description;
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

    public float getPrice() {
        return price;
    }
}
