package com.company.models;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public abstract class Event {
    static private Integer idCount = 0;
    final protected Integer id;
    private String name;
    private Integer numberOfTickets;
    private double ticketPrice;
    private Date date;
    private Location location;
    private Set<Sponsor> sponsors = new TreeSet<Sponsor>(new SponsorComparator());

    protected Event(String name, Integer numberOfTickets, double ticketPrice, Date date, Location location, Set<Sponsor> sponsors) {
        idCount++;
        this.id = idCount;
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

    public static Integer getIdCount() {
        return idCount;
    }

    public static void setIdCount(Integer idCount) {
        Event.idCount = idCount;
    }

    public void setSponsors(Set<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsors.add(sponsor);
    }

    public void setSponsors(TreeSet<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }
}
