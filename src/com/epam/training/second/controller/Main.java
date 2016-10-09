package com.epam.training.second.controller;

import com.epam.training.second.action.TourChooser;
import com.epam.training.second.builder.ClientBuilder;
import com.epam.training.second.entity.Agency;
import com.epam.training.second.entity.Client;
import com.epam.training.second.exception.WrongTourException;
import com.epam.training.second.factory.TourFactory;
import com.epam.training.second.reader.ReadToursFromFile;
import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        TourFactory lavanda = new TourFactory();
        Agency lavandaLand = new Agency("Lavanda Land");

        ReadToursFromFile.readToursFromFile("./data/tours.txt").forEach(line -> {
            try {
                lavandaLand.addTour(lavanda.createTours(line));
            } catch (WrongTourException e) {
                logger.error(e, e);
            }
        });
        //lavandaLand.getTours().forEach(System.out::println);
        Client galia = new ClientBuilder("Galia", "Semashko", 1234).build();
        TourChooser.chooseToursByGoal("festival", lavandaLand.getTours()).forEach(System.out::println);

    }
}
