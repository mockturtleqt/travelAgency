package com.epam.training.second.builder.tour;

import com.epam.training.second.entity.AdventureActivity;
import com.epam.training.second.entity.Food;
import com.epam.training.second.entity.Transportation;
import com.epam.training.second.entity.tour.AdventureTour;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;

import java.time.LocalDate;
import java.util.UUID;

public class AdventureTourBuilder extends TourBuilder {
    private AdventureActivity adventureActivity;

    public AdventureTourBuilder(String params) {

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

        return new AdventureTour(this.tourId, this.tourName, this.destination, this.adventureActivity,
                this.transportation, this.food, this.startDate, this.endDate, this.price);
    }
}
