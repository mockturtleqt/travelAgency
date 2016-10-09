package com.epam.training.second.action;

import com.epam.training.second.entity.Goal;
import com.epam.training.second.entity.tour.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TourChooser {
    public static List<Tour> chooseToursByGoal(String goal, List<Tour> tourList) {
        List<Tour> filteredTourList = new ArrayList<>();
        filteredTourList = tourList
                .stream()
                .filter(tour -> tour.getGoal() == Goal.valueOf(goal.toUpperCase()))
                .collect(Collectors.toList());
        return filteredTourList;
    }
}
