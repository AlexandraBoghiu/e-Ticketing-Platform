package events.cultural.movies;

import events.cultural.CulturalEvents;
import locations.Locations;
import sponsor.Sponsor;

import java.util.Date;
import java.util.TreeSet;

public class Movies extends CulturalEvents {
    final private String genre;
    final private String director;
    final private Integer yearOfProduction;

    public Movies(Integer id, String name, Integer numberOfTickets, double ticketPrice, Date date, Locations location,
                  TreeSet<Sponsor> sponsors, Integer timeLength, String genre, String director, Integer yearOfProduction) {
        super(id, name, numberOfTickets, ticketPrice, date, location, sponsors, timeLength);
        this.genre = genre;
        this.director = director;
        this.yearOfProduction = yearOfProduction;
    }

    public String getGenre() {
        return genre;
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
                ", name='" + name + '\'' +
                ", numberOfTickets=" + numberOfTickets +
                ", ticketPrice=" + ticketPrice +
                ", date=" + date +
                ", location=" + location +
                ", sponsors=" + sponsors +
                ", timeLength=" + timeLength +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
