package com.epam.training.second.comparator;

import com.epam.training.second.entity.tour.Tour;

import java.util.Comparator;

public class TourComparator implements Comparator<Tour> {
    public int compare(Tour t1, Tour t2) {
        return (int) (t1.getPrice() - t2.getPrice());
    }
}
