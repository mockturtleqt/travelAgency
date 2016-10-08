package com.epam.training.second.factory;

import com.epam.training.second.builder.tour.AdventureTourBuilder;
import com.epam.training.second.builder.tour.FestivalTourBuilder;
import com.epam.training.second.builder.tour.RecreationalTourBuilder;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;

public class TourFactory {
    public Tour createTours(String[] params) throws WrongTourException {
        switch (params[0]) {
            case "recreational":
                return new RecreationalTourBuilder(params).build();
            case "adventure":
                return new AdventureTourBuilder(params).build();
            case "festival":
                return new FestivalTourBuilder(params).build();
            default:
                throw new WrongTourException("No such goal.");
        }
    }
}
