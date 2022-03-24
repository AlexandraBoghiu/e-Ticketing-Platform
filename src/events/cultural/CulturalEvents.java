package events.cultural;

import events.Events;
import locations.Locations;

import java.time.LocalDate;

public abstract class CulturalEvents extends Events {
    protected Integer timeLength;

    public CulturalEvents() {

    }
    public CulturalEvents(Integer timeLength) {
        super();
        this.timeLength = timeLength;
    }

    public Integer getTimeLength() {
        return timeLength;
    }

    public void setTimeLength(Integer timeLength) {
        this.timeLength = timeLength;
    }
}
