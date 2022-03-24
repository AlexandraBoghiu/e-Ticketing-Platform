package events.cultural;

import events.Event;

public abstract class CulturalEvents extends Event {
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
