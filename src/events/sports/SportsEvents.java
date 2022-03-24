package events.sports;

import events.Events;
import locations.Locations;

import java.time.LocalDate;

public abstract class SportsEvents extends Events {
    final protected String firstTeam;
    final protected String secondTeam;

    public SportsEvents(String name, Integer numberOfTickets, double ticketPrice, LocalDate date, String firstTeam, String secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

}
