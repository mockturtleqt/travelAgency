package com.epam.training.second.builder.tour;

import com.epam.training.second.entity.Destination;
import com.epam.training.second.entity.Food;
import com.epam.training.second.entity.RecreationalActivity;
import com.epam.training.second.entity.Transportation;
import com.epam.training.second.entity.tour.RecreationalTour;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.UUID;

public class RecreationalTourBuilder extends TourBuilder {
    private final int TOUR_NAME = 1;
    private final int TOUR_DESTINATION = 2;
    private final int TOUR_START_DATE = 3;
    private final int TOUR_END_DATE = 4;
    private final int TOUR_PRICE = 5;
    private final int RECREATIONAL_ACTIVITY = 6;
    private final int TOUR_DESCRIPTION = 7;
    private final int TOUR_TRANSPORTATION = 8;
    private final int TOUR_FOOD = 9;

    private static Logger logger = Logger.getLogger(AdventureTourBuilder.class);

    private RecreationalActivity recreationalActivity = RecreationalActivity.SEASIDE_REST;

    public RecreationalTourBuilder(String[] params) {
        try {
            this.tourName = params[TOUR_NAME];
            this.destination = Destination.valueOf(params[TOUR_DESTINATION].toUpperCase());
            this.startDate = LocalDate.parse(params[TOUR_START_DATE]);
            this.endDate = LocalDate.parse(params[TOUR_END_DATE]);
            this.price = Float.parseFloat(params[TOUR_PRICE]);
            this.recreationalActivity = RecreationalActivity.valueOf(params[RECREATIONAL_ACTIVITY].toUpperCase());
            this.description = params[TOUR_DESCRIPTION];
            this.transportation = Transportation.valueOf(params[TOUR_TRANSPORTATION].toUpperCase());
            this.food = Food.valueOf(params[TOUR_FOOD].toUpperCase());
        } catch (DateTimeParseException | IllegalArgumentException e) {
            logger.error(e);
        } catch (ArrayIndexOutOfBoundsException e) {
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

        return new RecreationalTour(this.tourId, this.tourName, this.destination, this.recreationalActivity, this.description,
                this.transportation, this.food, this.startDate, this.endDate, this.price);
    }
}
