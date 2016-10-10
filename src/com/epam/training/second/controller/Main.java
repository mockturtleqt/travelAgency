package com.epam.training.second.controller;

import com.epam.training.second.action.TourCreatorFromFile;
import com.epam.training.second.action.TourFinder;
import com.epam.training.second.builder.ClientBuilder;
import com.epam.training.second.entity.Agency;
import com.epam.training.second.entity.Client;
import com.epam.training.second.entity.Goal;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.factory.TourFactory;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        TourFactory lavanda = new TourFactory();
        Agency lavandaLand = new Agency("Lavanda Land");
        TourCreatorFromFile.createToursFromFile("./data/tours.txt", lavanda, lavandaLand);

        Collections.sort(lavandaLand.getTours(), new Tour.TourComparator());

        Client galia = new ClientBuilder("Galia", "Semashko", 1234).build();
        galia.bookTour("c", lavandaLand);
        System.out.println(galia.getBookings());

        TourFinder.findTour(lavandaLand, Goal.FESTIVAL).forEach(System.out::println);
    }
}
