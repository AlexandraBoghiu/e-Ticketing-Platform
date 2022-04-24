package com.company.models;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public abstract class SportsEvent extends Event {
    private final String firstTeam;
    private final String secondTeam;

    public SportsEvent(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                       Set<Sponsor> sponsors, String firstTeam, String secondTeam) {
        super(id, name, numberOfTickets, ticketPrice, date, location, sponsors);
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }
}
