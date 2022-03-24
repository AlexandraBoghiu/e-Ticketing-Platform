package events.sports.football;

import events.sports.SportsEvents;
import locations.Locations;
import sponsor.Sponsor;

import java.util.Date;
import java.util.PriorityQueue;

public class FootballGames extends SportsEvents {
    private String stadium;
    private final String competition;

    public FootballGames(String name, Integer numberOfTickets, double ticketPrice, Date date, Locations location,
                         PriorityQueue<Sponsor> sponsors, String firstTeam, String secondTeam, String stadium, String competition) {
        super(name, numberOfTickets, ticketPrice, date, location, sponsors, firstTeam, secondTeam);
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
                "name='" + name + '\'' +
                ", numberOfTickets=" + numberOfTickets +
                ", ticketPrice=" + ticketPrice +
                ", date=" + date +
                ", location=" + location +
                ", sponsors=" + sponsors +
                ", firstTeam='" + firstTeam + '\'' +
                ", secondTeam='" + secondTeam + '\'' +
                ", stadium='" + stadium + '\'' +
                ", competition='" + competition + '\'' +
                '}';
    }
}
