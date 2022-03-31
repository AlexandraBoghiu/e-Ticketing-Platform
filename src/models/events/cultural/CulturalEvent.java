package models.events.cultural;

import models.events.Event;
import models.locations.Location;
import models.sponsor.Sponsor;

import java.util.Date;
import java.util.TreeSet;

public abstract class CulturalEvent extends Event {
    protected Integer timeLength;

    public CulturalEvent(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
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
