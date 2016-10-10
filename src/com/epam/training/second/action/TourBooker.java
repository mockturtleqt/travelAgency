package com.epam.training.second.action;

import com.epam.training.second.entity.Agency;
import com.epam.training.second.entity.Booking;
import com.epam.training.second.entity.Client;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;
import org.apache.log4j.Logger;

public class TourBooker {
    private static Logger logger = Logger.getLogger(TourBooker.class);

    public static void bookTour(Agency agency, Client client, String tourName) {
        try {
            Tour tour = TourFinder.findTour(agency, tourName);
            Booking booking = new Booking(client, tour);
            client.getBookings().add(booking);
        } catch (WrongTourException e) {
            logger.error(e, e);
        }
    }
}
