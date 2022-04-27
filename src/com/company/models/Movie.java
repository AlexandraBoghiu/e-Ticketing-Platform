package com.company.models;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Movie extends CulturalEvent {
    final private String director;
    final private Integer yearOfProduction;
    private static Integer idMovie = 0;

    public Movie(String name, Integer numberOfTickets, double ticketPrice, Date date, Location location,
                 Set<Sponsor> sponsors, String genre, String director, Integer yearOfProduction) {
        super(name, numberOfTickets, ticketPrice, date, location, sponsors, genre);
        idMovie++;
        this.director = director;
        this.yearOfProduction = yearOfProduction;
    }

    public static Integer getIdMovie() {
        return idMovie;
    }

    public static void setIdMovie(Integer idMovie) {
        Movie.idMovie = idMovie;
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
