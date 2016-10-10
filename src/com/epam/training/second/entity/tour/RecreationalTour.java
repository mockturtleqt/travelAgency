package com.epam.training.second.entity.tour;

import com.epam.training.second.entity.type.RecreationalActivity;

public class RecreationalTour extends Tour {
    private RecreationalActivity recreationalActivity;

    public RecreationalTour() {
    }

    public RecreationalActivity getRecreationalActivity() {
        return recreationalActivity;
    }

    public void setRecreationalActivity(RecreationalActivity recreationalActivity) {
        this.recreationalActivity = recreationalActivity;
    }

    @Override
    public String toString() {
        return "Tour {" +
                "name = '" + tourName + '\'' +
                ", description = '" + description + '\'' +
                ", destination = " + destination +
                ", recreational activity = " + recreationalActivity +
                ", goal = " + goal +
                ", transportation = " + transportation +
                ", food = " + food +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                ", duration = " + duration.getDays() + " days" +
                ", price = " + price + " $" +
                '}';
    }
}

