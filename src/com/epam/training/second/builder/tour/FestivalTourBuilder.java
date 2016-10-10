package com.epam.training.second.builder.tour;

import com.epam.training.second.entity.tour.FestivalTour;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.entity.type.Destination;
import com.epam.training.second.entity.type.Food;
import com.epam.training.second.entity.type.MusicGenre;
import com.epam.training.second.entity.type.Transportation;
import com.epam.training.second.exception.WrongTourException;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.UUID;

public class FestivalTourBuilder extends TourBuilder {
    private final int MUSIC_GENRE = 6;

    private static Logger logger = Logger.getLogger(AdventureTourBuilder.class);

    private MusicGenre musicGenre = MusicGenre.ROCK;

    public FestivalTourBuilder(String[] params) {
        try {
            this.tourName = params[ConstantHolder.TOUR_NAME];
            this.destination = Destination.valueOf(params[ConstantHolder.TOUR_DESTINATION].toUpperCase());
            this.startDate = LocalDate.parse(params[ConstantHolder.TOUR_START_DATE]);
            this.endDate = LocalDate.parse(params[ConstantHolder.TOUR_END_DATE]);
            this.price = Float.parseFloat(params[ConstantHolder.TOUR_PRICE]);
            this.musicGenre = MusicGenre.valueOf(params[MUSIC_GENRE].toUpperCase());
            this.description = params[ConstantHolder.TOUR_DESCRIPTION];
            this.transportation = Transportation.valueOf(params[ConstantHolder.TOUR_TRANSPORTATION].toUpperCase());
            this.food = Food.valueOf(params[ConstantHolder.TOUR_FOOD].toUpperCase());
        } catch (DateTimeParseException | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            logger.error(e);
        }
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

        FestivalTour festivalTour = new FestivalTour();
        festivalTour.setTourId(this.tourId);
        festivalTour.setTourName(this.tourName);
        festivalTour.setDestination(this.destination);
        festivalTour.setMusicGenre(this.musicGenre);
        festivalTour.setDescription(this.description);
        festivalTour.setTransportation(this.transportation);
        festivalTour.setFood(this.food);
        festivalTour.setStartDate(this.startDate);
        festivalTour.setEndDate(this.endDate);
        festivalTour.setPrice(this.price);

        return festivalTour;
    }
}
