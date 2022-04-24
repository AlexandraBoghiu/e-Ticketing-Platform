package com.company.models;

import java.util.Date;
import java.util.TreeSet;

public abstract class CulturalEvent extends Event {
    final private String genre;

    public CulturalEvent(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                         TreeSet<Sponsor> sponsors, String genre) {
        super(id, name, numberOfTickets, ticketPrice, date, location, sponsors);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
