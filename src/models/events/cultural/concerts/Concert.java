package models.events.cultural.concerts;

import models.events.cultural.CulturalEvent;
import models.locations.Location;
import models.sponsor.Sponsor;

import java.util.Date;
import java.util.TreeSet;

public class Concert extends CulturalEvent {
    final private String artist;
    final private String genre;

    public Concert(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                   TreeSet<Sponsor> sponsors, Integer timeLength, String artist, String genre) {
        super(id, name, numberOfTickets, ticketPrice, date, location, sponsors, timeLength);
        this.artist = artist;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }


    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Concerts{" +
                "id=" + id + '\'' +
                "name='" + name + '\'' +
                ", numberOfTickets=" + numberOfTickets +
                ", ticketPrice=" + ticketPrice +
                ", date=" + date +
                ", location=" + location +
                ", sponsors=" + sponsors +
                ", timeLength=" + timeLength +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
