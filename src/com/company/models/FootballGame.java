package com.company.models;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class FootballGame extends SportsEvent {
    private String stadium;
    private final String competition;
    private static Integer idFootballGame = 0;

    public FootballGame(String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                        Set<Sponsor> sponsors, String firstTeam, String secondTeam, String stadium, String competition) {
        super(name, numberOfTickets, ticketPrice, date, location, sponsors, firstTeam, secondTeam);
        idFootballGame++;
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

    public static Integer getIdFootballGame() {
        return idFootballGame;
    }

    public static void setIdFootballGame(Integer idFootballGame) {
        FootballGame.idFootballGame = idFootballGame;
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
