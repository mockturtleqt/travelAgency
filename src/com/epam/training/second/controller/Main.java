package com.epam.training.second.controller;

import com.epam.training.second.action.TourBooker;
import com.epam.training.second.action.TourCreatorFromFile;
import com.epam.training.second.action.TourFinder;
import com.epam.training.second.builder.ClientBuilder;
import com.epam.training.second.entity.Agency;
import com.epam.training.second.entity.Client;
import com.epam.training.second.entity.type.Goal;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.factory.TourFactory;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        TourFactory lavanda = new TourFactory();
        Agency lavandaLand = new Agency("Lavanda Land");
        lavandaLand.getTours().addAll(TourCreatorFromFile.createToursFromFile("./data/tours.txt", lavanda));

        Client galia = new ClientBuilder("Galia", "Semashko", 1234).build();

        List<Tour> acceptibleTours = TourFinder.findTour(lavandaLand, Goal.FESTIVAL);
        Collections.sort(acceptibleTours, new Tour.TourComparator());
        acceptibleTours.forEach(logger::info);

        TourBooker.bookTour(lavandaLand, galia, "coldplay");
        logger.info(galia.getBookings());
    }
}
