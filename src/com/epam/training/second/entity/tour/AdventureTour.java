package com.epam.training.second.entity.tour;

import com.epam.training.second.entity.AdventureActivity;
import com.epam.training.second.entity.Destination;
import com.epam.training.second.entity.Food;
import com.epam.training.second.entity.Transportation;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class AdventureTour extends Tour {
    private AdventureActivity adventureActivity;

    public AdventureTour(UUID tourId, String tourName, Destination destination,
                         AdventureActivity adventureActivity, Transportation transportation, Food food,
                         LocalDate startDate, LocalDate endDate, double price) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.destination = destination;
        this.adventureActivity = adventureActivity;
        this.transportation = transportation;
        this.food = food;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = Period.between(endDate, startDate);
        this.price = price;
    }
}
