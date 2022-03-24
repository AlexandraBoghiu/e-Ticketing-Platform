package events;


import java.util.Date;
import java.util.PriorityQueue;

import locations.Locations;
import sponsor.*;

public abstract class Event {
    protected String name;
    protected Integer numberOfTickets;
    protected double ticketPrice;
    protected Date date;
    protected Locations location;
    protected PriorityQueue<Sponsor> sponsors = new PriorityQueue<Sponsor>(1, new SponsorComparator());

    protected Event(String name, Integer numberOfTickets, double ticketPrice, Date date, Locations location, PriorityQueue<Sponsor> sponsors) {
        this.name = name;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
        this.date = date;
        this.location = location;
        this.sponsors = sponsors;
    }

    public Event() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Locations getLocation() {
        return location;
    }

    public void setLocation(Locations location) {
        this.location = location;
    }

    public void addSponsor(Sponsor sponsor) {
        this.sponsors.add(sponsor);
    }
}
