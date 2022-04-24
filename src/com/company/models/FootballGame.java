package com.company.models;

import java.util.Date;
import java.util.TreeSet;

public class FootballGame extends SportsEvent {
    private String stadium;
    private final String competition;

    public FootballGame(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                        TreeSet<Sponsor> sponsors, String firstTeam, String secondTeam, String stadium, String competition) {
        super(id, name, numberOfTickets, ticketPrice, date, location, sponsors, firstTeam, secondTeam);
        this.competition = competition;
        this.stadium = stadium;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCompetition() {
        return competition;
    }

    @Override
    public String toString() {
        return "FootballGames{" +
                "id=" + id +
                "name='" + getName() + '\'' +
                ", numberOfTickets=" + getNumberOfTickets() +
                ", ticketPrice=" + getTicketPrice() +
                ", date=" + getDate() +
                ", location=" + getLocation() +
                ", sponsors=" + getSponsors() +
                ", firstTeam='" + getFirstTeam() + '\'' +
                ", secondTeam='" + getSecondTeam() + '\'' +
                ", stadium='" + stadium + '\'' +
                ", competition='" + competition + '\'' +
                '}';
    }
}
