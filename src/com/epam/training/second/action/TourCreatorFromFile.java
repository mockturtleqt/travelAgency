package com.epam.training.second.action;

import com.epam.training.second.entity.Agency;
import com.epam.training.second.exception.WrongTourException;
import com.epam.training.second.factory.TourFactory;
import org.apache.log4j.Logger;

public class TourCreatorFromFile {
    private static Logger logger = Logger.getLogger(TourCreatorFromFile.class);

    public static void createToursFromFile(String filepath, TourFactory tourFactory, Agency agency) {

        TourDataReaderFromFile.readTourDataFromFile(filepath).forEach(line -> {
            try {
                agency.addTour(tourFactory.createTours(line));
            } catch (WrongTourException e) {
                logger.error(e, e);
            }
        });
    }
}
