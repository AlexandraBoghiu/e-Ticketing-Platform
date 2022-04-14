package models.events.cultural.movies;

import models.events.cultural.CulturalEvent;
import models.locations.Location;
import models.sponsor.Sponsor;

import java.util.Date;
import java.util.TreeSet;

public class Movie extends CulturalEvent {
    final private String director;
    final private Integer yearOfProduction;

    public Movie(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                 TreeSet<Sponsor> sponsors, String genre, String director, Integer yearOfProduction) {
        super(id, name, numberOfTickets, ticketPrice, date, location, sponsors, genre);
        this.director = director;
        this.yearOfProduction = yearOfProduction;
    }

    public String getDirector() {
        return director;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", name='" + getName() + '\'' +
                ", numberOfTickets=" + getNumberOfTickets() +
                ", ticketPrice=" + getTicketPrice() +
                ", date=" + getDate() +
                ", location=" + getLocation() +
                ", sponsors=" + getSponsors() +
                ", genre=" + getGenre() +
                ", director='" + director + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
