package com.company.models;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Concert extends CulturalEvent {
    final private String artist;
    private static Integer idConcert = 0;

    public Concert(String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                   Set<Sponsor> sponsors, String genre, String artist) {
        super(name, numberOfTickets, ticketPrice, date, location, sponsors, genre);
        idConcert++;
        this.artist = artist;

    }

    public String getArtist() {
        return artist;
    }

    public static Integer getIdConcert() {
        return idConcert;
    }

    public static void setIdConcert(Integer idConcert) {
        Concert.idConcert = idConcert;
    }

    @Override
    public String toString() {
        return "Concerts{" +
                "id=" + id + '\'' +
                "name='" + getName() + '\'' +
                ", numberOfTickets=" + getNumberOfTickets() +
                ", ticketPrice=" + getTicketPrice() +
                ", date=" + getDate() +
                ", location=" + getLocation() +
                ", sponsors=" + getSponsors() +
                ", genre='" + getGenre() +
                ", artist='" + artist + '\'' +
                '}';
    }
}
