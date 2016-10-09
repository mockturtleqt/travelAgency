package com.epam.training.second.controller;

import com.epam.training.second.action.TourChooser;
import com.epam.training.second.action.TourCreatorFromFile;
import com.epam.training.second.builder.ClientBuilder;
import com.epam.training.second.entity.Agency;
import com.epam.training.second.entity.Client;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.factory.TourFactory;
import org.apache.log4j.Logger;

import java.util.Collections;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        TourFactory lavanda = new TourFactory();
        Agency lavandaLand = new Agency("Lavanda Land");
        TourCreatorFromFile.createToursFromFile("./data/tours.txt", lavanda, lavandaLand);

        Collections.sort(lavandaLand.getTours(), new Tour.TourComparator());
        //lavandaLand.getTours().forEach(System.out::println);

        Client galia = new ClientBuilder("Galia", "Semashko", 1234).build();
        galia.bookTour("coldplay", lavandaLand.getTours());
        System.out.println(galia.getBookings());

        TourChooser.getToursByGoal("festival", lavandaLand.getTours()).forEach(System.out::println);

    }
}
