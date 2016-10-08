package com.epam.training.second.entity.tour;

import com.epam.training.second.entity.Destination;
import com.epam.training.second.entity.Food;
import com.epam.training.second.entity.MusicGenre;
import com.epam.training.second.entity.Transportation;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class FestivalTour extends Tour {
    private MusicGenre musicGenre;

    public FestivalTour(UUID tourId, String tourName, Destination destination,
                        MusicGenre musicGenre, Transportation transportation, Food food,
                        LocalDate startDate, LocalDate endDate, double price) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.destination = destination;
        this.musicGenre = musicGenre;
        this.transportation = transportation;
        this.food = food;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = Period.between(endDate, startDate);
        this.price = price;
    }
}
