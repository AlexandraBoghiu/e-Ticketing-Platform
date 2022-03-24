package events.sports.football;

import events.sports.SportsEvents;

import java.time.LocalDate;

public class FootballGames extends SportsEvents {
    private String stadium;
    private String competition;

    public FootballGames(String name, Integer numberOfTickets, double ticketPrice, LocalDate date, String firstTeam, String secondTeam) {
        super(name, numberOfTickets, ticketPrice, date, firstTeam, secondTeam);
    }
}
