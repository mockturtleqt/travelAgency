package com.epam.training.second.builder.tour;

import com.epam.training.second.entity.Food;
import com.epam.training.second.entity.MusicGenre;
import com.epam.training.second.entity.Transportation;
import com.epam.training.second.entity.tour.FestivalTour;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;

import java.util.UUID;

public class FestivalTourBuilder extends TourBuilder {
    private MusicGenre musicGenre = MusicGenre.ROCK;

    public FestivalTourBuilder(String params) {
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public Tour build() throws WrongTourException {
        this.tourId = UUID.randomUUID();

        if (this.tourName.isEmpty() || this.destination == null || this.startDate == null ||
                this.endDate == null || this.price == 0) {
            throw new WrongTourException("Can't create such tour.");
        }

        if (this.musicGenre == null) {
            this.musicGenre = MusicGenre.ROCK;
        }

        if (this.transportation == null) {
            this.transportation = Transportation.BUS;
        }

        if (this.food == null) {
            this.food = Food.NONE;
        }

        return new FestivalTour(this.tourId, this.tourName, this.destination, this.musicGenre,
                this.transportation, this.food, this.startDate, this.endDate, this.price);
    }
}