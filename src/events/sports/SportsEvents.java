package events.sports;

import events.Event;
import locations.Locations;
import sponsor.Sponsor;
import java.util.Date;
import java.util.PriorityQueue;

public abstract class SportsEvents extends Event {
    protected final String firstTeam;
    protected final String secondTeam;

    public SportsEvents(String name, Integer numberOfTickets, double ticketPrice, Date date, Locations location,
                        PriorityQueue<Sponsor> sponsors, String firstTeam, String secondTeam) {
        super(name, numberOfTickets, ticketPrice, date, location, sponsors);
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

}
