package com.epam.training.second.entity.tour;

import com.epam.training.second.entity.*;

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
        this.duration = Period.between(startDate, endDate);
        this.price = price;
        this.goal = Goal.FESTIVAL;
    }

    @Override
    public String toString() {
        return "Tour {" +
                "tour name = '" + tourName + '\'' +
                ", description = '" + description + '\'' +
                ", destination = " + destination +
                ", music genre = " + musicGenre +
                ", goal = " + goal +
                ", transportation = " + transportation +
                ", food = " + food +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                ", duration = " + duration.getDays() + " days" +
                ", price = " + price +
                '}';
    }
}
