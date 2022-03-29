package events.sports.football;

import events.sports.SportsEvents;
import locations.Locations;
import sponsor.Sponsor;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class FootballGames extends SportsEvents {
    private String stadium;
    private final String competition;

    public FootballGames(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Locations location,
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
