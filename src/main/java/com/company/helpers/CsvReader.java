package com.company.helpers;

import com.company.services.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class CsvReader {
    static ReadService<String> readService = new ReadService<>();
    static EventService eventService;

    static {
        try {
            eventService = EventService.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ClientService clientService;

    static {
        try {
            clientService = ClientService.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static SponsorService sponsorService;

    static {
        try {
            sponsorService = SponsorService.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    LocationService locationService = LocationService.getInstance();
    TicketService ticketService = TicketService.getInstance();

    public static void readClientsFromCsv() throws FileNotFoundException {
        List<String[]> parametersCsv = readService.read("src\\main\\java\\com\\company\\resources\\client.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                clientService.createClient(parametersCsv, true, false);
            } catch (Exception e) {
                System.out.println("Something didn't work while reading clients from csv file..");
            }
        }
    }

    public static void readFootballGamesFromCsv() throws FileNotFoundException, ParseException {
        List<String[]> parametersCsv = readService.read("src\\main\\java\\com\\company\\resources\\footballgame.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                eventService.createFootballGameEvent(parametersCsv, true);
            } catch (Exception e) {
                System.out.println("Something didn't work while reading football games from csv file..");
            }
        }
    }

    public static void readConcertsFromCsv() throws FileNotFoundException, ParseException {
        List<String[]> parametersCsv = readService.read("src\\main\\java\\com\\company\\resources\\concert.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                eventService.createConcertEvent(parametersCsv, true);
            } catch (Exception e) {
                System.out.println("Something didn't work while reading concerts from csv file.");
            }
        }
    }
    public static void readMoviesFromCsv() throws FileNotFoundException, ParseException {
        List<String[]> parametersCsv = readService.read("src\\main\\java\\com\\company\\resources\\movie.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                eventService.createMovieEvent(parametersCsv, true);
            } catch (Exception e) {
                System.out.println("Something didn't work while reading movies from csv file..");
            }
        }
    }
    public static void readSponsorsFromCsv() throws FileNotFoundException, ParseException {
        List<String[]> parametersCsv = readService.read("src\\main\\java\\com\\company\\resources\\sponsor.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                sponsorService.createSponsor(parametersCsv, true);
            } catch (Exception e) {
                System.out.println("Something didn't work while reading sponsors from csv file.");
            }
        }
    }
}
