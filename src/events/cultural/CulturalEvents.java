package events.cultural;

import events.Event;
import locations.Locations;
import sponsor.Sponsor;

import java.util.Date;
import java.util.TreeSet;

public abstract class CulturalEvents extends Event {
    protected Integer timeLength;

    public CulturalEvents(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Locations location,
                          TreeSet<Sponsor> sponsors, Integer timeLength) {
        super(id, name, numberOfTickets, ticketPrice, date, location, sponsors);
        this.timeLength = timeLength;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }
}
