package com.epam.training.second.action;

import com.epam.training.second.entity.Agency;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.entity.type.Destination;
import com.epam.training.second.entity.type.Food;
import com.epam.training.second.entity.type.Goal;
import com.epam.training.second.entity.type.Transportation;
import com.epam.training.second.exception.WrongTourException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TourFinder {
    public static Tour findTour(Agency agency, String tourName) throws WrongTourException {
        return agency.getTours()
                .stream()
                .filter(tour -> tour.getTourName().equalsIgnoreCase(tourName))
                .findAny()
                .orElseThrow(() -> new WrongTourException("There's no tour with this name - '" + tourName + "'"));
    }

    public static List<Tour> findTour(Agency agency, Goal goal) {
        return agency.getTours()
                .stream()
                .filter(tour -> tour.getGoal().equals(goal))
                .collect(Collectors.toList());
    }

    public static List<Tour> findTour(Agency agency, String startDate, Destination destination) throws WrongTourException {
        Predicate<Tour> condition = tour -> tour.getStartDate().isAfter(LocalDate.parse(startDate)) &&
                tour.getDestination().equals(destination);

        return agency.getTours()
                .stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    public static List<Tour> findTour(Agency agency, int numberOfDays, Food food, Transportation transportation) throws WrongTourException {
        Predicate<Tour> condition = tour -> tour.getDuration().equals(Period.ofDays(numberOfDays)) &&
                tour.getFood().equals(food) &&
                tour.getTransportation().equals(transportation);
        return agency.getTours()
                .stream()
                .filter(condition)
                .collect(Collectors.toList());
    }
}
