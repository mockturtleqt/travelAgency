package com.epam.training.second.factory;

import com.epam.training.second.builder.tour.AdventureTourBuilder;
import com.epam.training.second.builder.tour.FestivalTourBuilder;
import com.epam.training.second.builder.tour.RecreationalTourBuilder;
import com.epam.training.second.entity.Goal;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;

public class TourFactory {
    public Tour getGoal(Goal goal, String params) throws WrongTourException {
        switch (goal) {
            case RECREATION:
                return new RecreationalTourBuilder(params).build();
            case ADVENTURE:
                return new AdventureTourBuilder(params).build();
            case FESTIVAL:
                return new FestivalTourBuilder(params).build();
            default:
                throw new WrongTourException("No such goal.");
        }
    }
}
