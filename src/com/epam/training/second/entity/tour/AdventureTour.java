package com.epam.training.second.entity.tour;


import com.epam.training.second.entity.type.AdventureActivity;

public class AdventureTour extends Tour {
    private AdventureActivity adventureActivity;

    public AdventureTour() {
    }

    public AdventureActivity getAdventureActivity() {
        return adventureActivity;
    }

    public void setAdventureActivity(AdventureActivity adventureActivity) {
        this.adventureActivity = adventureActivity;
    }

    @Override
    public String toString() {
        return "Tour {" +
                "name = '" + tourName + '\'' +
                ", description = '" + description + '\'' +
                ", destination = " + destination +
                ", adventure activity = " + adventureActivity +
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
