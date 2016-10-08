package com.epam.training.second.entity.tour;

import com.epam.training.second.entity.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class RecreationalTour extends Tour {
    private RecreationalActivity recreationalActivity;

    public RecreationalTour(UUID tourId, String tourName, Destination destination, RecreationalActivity recreationalActivity,
                            String description, Transportation transportation, Food food,
                            LocalDate startDate, LocalDate endDate, double price) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.destination = destination;
        this.recreationalActivity = recreationalActivity;
        this.description = description;
        this.transportation = transportation;
        this.food = food;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = Period.between(startDate, endDate);
        this.price = price;
        this.goal = Goal.RECREATION;
    }

    @Override
    public String toString() {
        return "Tour {" +
                "tour name = '" + tourName + '\'' +
                ", description = '" + description + '\'' +
                ", destination = " + destination +
                ", recreational activity = " + recreationalActivity +
                ", goal = " + goal +
                ", transportation = " + transportation +
                ", food = " + food +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                ", duration = " + duration.getDays() + " days" +
                ", price = " + price + " $" +
                '}';
    }
}

