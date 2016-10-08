package com.epam.training.second.entity.tour;

import com.epam.training.second.entity.Destination;
import com.epam.training.second.entity.Food;
import com.epam.training.second.entity.RecreationalActivity;
import com.epam.training.second.entity.Transportation;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class RecreationalTour extends Tour {
    private RecreationalActivity recreationalActivity;

    public RecreationalTour(UUID tourId, String tourName, Destination destination,
                            RecreationalActivity recreationalActivity, Transportation transportation, Food food,
                            LocalDate startDate, LocalDate endDate, double price) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.destination = destination;
        this.recreationalActivity = recreationalActivity;
        this.transportation = transportation;
        this.food = food;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = Period.between(endDate, startDate);
        this.price = price;
    }
}

