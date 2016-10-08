package com.epam.training.second.controller;

import com.epam.training.second.entity.Agency;
import com.epam.training.second.entity.Goal;
import com.epam.training.second.entity.tour.Tour;
import com.epam.training.second.exception.WrongTourException;
import com.epam.training.second.factory.TourFactory;
import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Agency lavandaLand = new Agency("LavandaLand");
        TourFactory kommunarka = new TourFactory();
        Tour tessTour = null;
        try {
            tessTour = kommunarka.getGoal(Goal.ADVENTURE, "galia");
        } catch (WrongTourException e) {
            logger.error(e, e);
        }
        System.out.println(tessTour);


    }
}
