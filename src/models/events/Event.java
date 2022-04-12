package models.events;


import java.util.Date;
import java.util.TreeSet;

import models.locations.Location;
import models.sponsor.*;

public abstract class Event {
    final protected Integer id;
    private String name;
    private Integer numberOfTickets;
    private double ticketPrice;
    private Date date;
    private Location location;
    private TreeSet<Sponsor> sponsors = new TreeSet<Sponsor>(new SponsorComparator());

    protected Event(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Location location, TreeSet<Sponsor> sponsors) {
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public TreeSet<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsors.add(sponsor);
    }

    public void setSponsors(TreeSet<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }
}
