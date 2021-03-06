package com.company.models;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public abstract class CulturalEvent extends Event {
    final private String genre;

    public CulturalEvent(String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                         Set<Sponsor> sponsors, String genre) {
        super(name, numberOfTickets, ticketPrice, date, location, sponsors);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
