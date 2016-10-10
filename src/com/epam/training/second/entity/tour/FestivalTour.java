package com.epam.training.second.entity.tour;

import com.epam.training.second.entity.type.MusicGenre;

public class FestivalTour extends Tour {
    private MusicGenre musicGenre;

    public FestivalTour() {
    }

    public MusicGenre getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(MusicGenre musicGenre) {
        this.musicGenre = musicGenre;
    }

    @Override
    public String toString() {
        return "Tour {" +
                "name = '" + tourName + '\'' +
                ", description = '" + description + '\'' +
                ", destination = " + destination +
                ", music genre = " + musicGenre +
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
