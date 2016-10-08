package com.epam.training.second.comparator;

import com.epam.training.second.entity.tour.Tour;

import java.util.Comparator;

public class TourComparator{// implements Comparator<Tour> {
    public void compare(Tour t1, Tour t2) {
        Comparator<Tour> tourComparator = Comparator.comparing(Tour::getGoal);
    }
}
