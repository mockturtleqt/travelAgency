package com.epam.training.second.builder.tour;

import com.epam.training.second.entity.type.*;
import com.epam.training.second.entity.tour.RecreationalTour;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.UUID;

public class RecreationalTourBuilder extends TourBuilder {
    private final int RECREATIONAL_ACTIVITY = 6;

    private static Logger logger = Logger.getLogger(RecreationalTourBuilder.class);

    private RecreationalActivity recreationalActivity = RecreationalActivity.SEASIDE_REST;

    public RecreationalTourBuilder(String[] params) {
        try {
            this.tourName = params[ConstantHolder.TOUR_NAME];
            this.destination = Destination.valueOf(params[ConstantHolder.TOUR_DESTINATION].toUpperCase());
            this.startDate = LocalDate.parse(params[ConstantHolder.TOUR_START_DATE]);
            this.endDate = LocalDate.parse(params[ConstantHolder.TOUR_END_DATE]);
            this.price = Float.parseFloat(params[ConstantHolder.TOUR_PRICE]);
            this.recreationalActivity = RecreationalActivity.valueOf(params[RECREATIONAL_ACTIVITY].toUpperCase());
            this.description = params[ConstantHolder.TOUR_DESCRIPTION];
            this.transportation = Transportation.valueOf(params[ConstantHolder.TOUR_TRANSPORTATION].toUpperCase());
            this.food = Food.valueOf(params[ConstantHolder.TOUR_FOOD].toUpperCase());
        } catch (DateTimeParseException | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            logger.error(e);
        }
    }

    public void setRecreationalActivity(RecreationalActivity recreationalActivity) {
        this.recreationalActivity = recreationalActivity;
    }

    public RecreationalActivity getRecreationalActivity() {
        return recreationalActivity;
    }

    public Tour build() throws WrongTourException {
        this.tourId = UUID.randomUUID();

        if (this.tourName.isEmpty() || this.destination == null || this.startDate == null ||
                this.endDate == null || this.price == 0) {
            throw new WrongTourException("Can't create such tour.");
        }

        if (this.recreationalActivity == null) {
            this.recreationalActivity = RecreationalActivity.SEASIDE_REST;
        }

        if (this.transportation == null) {
            this.transportation = Transportation.BUS;
        }

        if (this.food == null) {
            this.food = Food.NONE;
        }

        this.duration = Period.between(endDate, startDate);

        RecreationalTour recreationalTour = new RecreationalTour();
        recreationalTour.setGoal(Goal.RECREATION);
        recreationalTour.setTourId(this.tourId);
        recreationalTour.setTourName(this.tourName);
        recreationalTour.setDestination(this.destination);
        recreationalTour.setRecreationalActivity(this.recreationalActivity);
        recreationalTour.setDescription(this.description);
        recreationalTour.setTransportation(this.transportation);
        recreationalTour.setFood(this.food);
        recreationalTour.setStartDate(this.startDate);
        recreationalTour.setEndDate(this.endDate);
        recreationalTour.setDuration(this.duration);
        recreationalTour.setPrice(this.price);

        return recreationalTour;
    }
}
