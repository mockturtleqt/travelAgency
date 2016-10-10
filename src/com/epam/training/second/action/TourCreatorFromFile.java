package com.epam.training.second.action;

import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;
import com.epam.training.second.factory.TourFactory;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TourCreatorFromFile {
    private static Logger logger = Logger.getLogger(TourCreatorFromFile.class);

    public static List<Tour> createToursFromFile(String filepath, TourFactory tourFactory) {
        List<Tour> tourList = new ArrayList<>();

        TourDataReaderFromFile.readTourDataFromFile(filepath).forEach(line -> {
            try {
                tourList.add(tourFactory.createTours(line));
            } catch (WrongTourException e) {
                logger.error(e, e);
            }
        });
        return tourList;
    }
}
