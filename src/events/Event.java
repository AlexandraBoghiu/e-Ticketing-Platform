package events;


import java.util.Date;
import java.util.PriorityQueue;

import locations.Locations;
import sponsor.*;

public abstract class Event {
    final protected Integer id;
    protected String name;
    protected Integer numberOfTickets;
    protected double ticketPrice;
    protected Date date;
    protected Locations location;
    protected PriorityQueue<Sponsor> sponsors = new PriorityQueue<Sponsor>(1, new SponsorComparator());

    protected Event(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Locations location, PriorityQueue<Sponsor> sponsors) {
        this.id = id;
        this.name = name;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
        this.date = date;
        this.location = location;
        this.sponsors = sponsors;
    }

    public Event(Integer id) {

        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public PriorityQueue<Sponsor> getSponsors() {
        return sponsors;
    }
    public void setSponsor(Sponsor sponsor) {
        this.sponsors.add(sponsor);
    }
    public void setSponsors(PriorityQueue<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }
}
