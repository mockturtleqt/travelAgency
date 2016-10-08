package com.epam.training.second.builder.tour;

import com.epam.training.second.entity.Food;
import com.epam.training.second.entity.RecreationalActivity;
import com.epam.training.second.entity.Transportation;
import com.epam.training.second.entity.tour.RecreationalTour;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;

import java.util.UUID;

public class RecreationalTourBuilder extends TourBuilder {
    private RecreationalActivity recreationalActivity = RecreationalActivity.SEASIDE_REST;

    public RecreationalTourBuilder(String params) {
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

        return new RecreationalTour(this.tourId, this.tourName, this.destination, this.recreationalActivity,
                this.transportation, this.food, this.startDate, this.endDate, this.price);
    }
}
