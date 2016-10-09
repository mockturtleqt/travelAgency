package com.epam.training.second.action;

import com.epam.training.second.entity.Goal;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;

import java.util.List;
import java.util.stream.Collectors;

public class TourChooser {
    public static List<Tour> getToursByGoal(String goal, List<Tour> tourList) {

        return tourList
                .stream()
                .filter(tour -> tour.getGoal() == Goal.valueOf(goal.toUpperCase()))
                .collect(Collectors.toList());
    }

    public static Tour chooseTourByName(String tourName, List<Tour> tourList) throws WrongTourException {
        return tourList
                .stream()
                .filter(tour -> tour.getTourName().equalsIgnoreCase(tourName))
                .findAny()
                .orElse(null);
    }
}
