package models.events.cultural.concerts;

import models.events.cultural.CulturalEvent;
import models.locations.Location;
import models.sponsor.Sponsor;

import java.util.Date;
import java.util.TreeSet;

public class Concert extends CulturalEvent {
    final private String artist;


    public Concert(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                   TreeSet<Sponsor> sponsors, String genre, String artist) {
        super(id, name, numberOfTickets, ticketPrice, date, location, sponsors, genre);
        this.artist = artist;

    }

    public String getArtist() {
        return artist;
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
