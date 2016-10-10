package com.epam.training.second.builder.tour;

import com.epam.training.second.entity.tour.AdventureTour;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.entity.type.*;
import com.epam.training.second.exception.WrongTourException;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.UUID;

public class AdventureTourBuilder extends TourBuilder {
    private final int ADVENTURE_ACTIVITY = 6;

    private static Logger logger = Logger.getLogger(AdventureTourBuilder.class);

    private AdventureActivity adventureActivity;

    public AdventureTourBuilder(String[] params) {
        try {
            this.tourName = params[ConstantHolder.TOUR_NAME];
            this.destination = Destination.valueOf(params[ConstantHolder.TOUR_DESTINATION].toUpperCase());
            this.startDate = LocalDate.parse(params[ConstantHolder.TOUR_START_DATE]);
            this.endDate = LocalDate.parse(params[ConstantHolder.TOUR_END_DATE]);
            this.price = Float.parseFloat(params[ConstantHolder.TOUR_PRICE]);
            this.adventureActivity = AdventureActivity.valueOf(params[ADVENTURE_ACTIVITY].toUpperCase());
            this.description = params[ConstantHolder.TOUR_DESCRIPTION];
            this.transportation = Transportation.valueOf(params[ConstantHolder.TOUR_TRANSPORTATION].toUpperCase());
            this.food = Food.valueOf(params[ConstantHolder.TOUR_FOOD].toUpperCase());
        } catch (DateTimeParseException | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            logger.error(e);
        }
    }

    public void setAdventureActivity(AdventureActivity adventureActivity) {
        this.adventureActivity = adventureActivity;
    }

    public AdventureActivity getAdventureActivity() {
        return adventureActivity;
    }

    public Tour build() throws WrongTourException {
        this.tourId = UUID.randomUUID();

        if (this.tourName == null || this.destination == null || this.startDate == LocalDate.parse(DEFAULT_DATE) ||
                this.endDate == LocalDate.parse(DEFAULT_DATE) || this.price == 0) {
            throw new WrongTourException("Can't create such tour.");
        }

        if (this.adventureActivity == null) {
            this.adventureActivity = AdventureActivity.BIKING;
        }

        if (this.transportation == null) {
            this.transportation = Transportation.BUS;
        }

        if (this.food == null) {
            this.food = Food.NONE;
        }

        this.duration = Period.between(endDate, startDate);

        AdventureTour adventureTour = new AdventureTour();
        adventureTour.setGoal(Goal.ADVENTURE);
        adventureTour.setTourId(this.tourId);
        adventureTour.setTourName(this.tourName);
        adventureTour.setDestination(this.destination);
        adventureTour.setAdventureActivity(this.adventureActivity);
        adventureTour.setDescription(this.description);
        adventureTour.setTransportation(this.transportation);
        adventureTour.setFood(this.food);
        adventureTour.setStartDate(this.startDate);
        adventureTour.setEndDate(this.endDate);
        adventureTour.setDuration(this.duration);
        adventureTour.setPrice(this.price);

        return adventureTour;
    }
}
