package events.cultural.movies;

import events.cultural.CulturalEvents;

public class Movies extends CulturalEvents {
    private String genre;
    final private String director;
    final private Integer yearOfProduction;

    public Movies(String genre, String director, Integer yearOfProduction) {
        super();
        this.genre = genre;
        this.director = director;
        this.yearOfProduction = yearOfProduction;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }
}
