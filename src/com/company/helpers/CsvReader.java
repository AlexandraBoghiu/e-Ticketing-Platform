package com.company.helpers;

import com.company.services.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;

public class CsvReader {
    static ReadService<String> readService = new ReadService<>();
    static EventService eventService = EventService.getInstance();
    static ClientService clientService = ClientService.getInstance();
    static SponsorService sponsorService = SponsorService.getInstance();
    LocationService locationService = LocationService.getInstance();
    TicketService ticketService = TicketService.getInstance();

    public static void readClientsFromCsv() throws FileNotFoundException {
        List<String[]> parametersCsv = readService.read("src\\com\\company\\csv\\client.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                clientService.createClient(parametersCsv, true, false);
            } catch (Exception e) {
                System.out.println("Something didn't work.");
            }
        }
    }

    public static void readFootballGamesFromCsv() throws FileNotFoundException, ParseException {
        List<String[]> parametersCsv = readService.read("src\\com\\company\\csv\\footballgame.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                eventService.createFootballGameEvent(parametersCsv, true);
            } catch (Exception e) {
                System.out.println("Something didn't work.");
            }
        }
    }

    public static void readConcertsFromCsv() throws FileNotFoundException, ParseException {
        List<String[]> parametersCsv = readService.read("src\\com\\company\\csv\\concert.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                eventService.createConcertEvent(parametersCsv, true);
            } catch (Exception e) {
                System.out.println("Something didn't work.");
            }
        }
    }
    public static void readMoviesFromCsv() throws FileNotFoundException, ParseException {
        List<String[]> parametersCsv = readService.read("src\\com\\company\\csv\\movie.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                eventService.createMovieEvent(parametersCsv, true);
            } catch (Exception e) {
                System.out.println("Something didn't work.");
            }
        }
    }
    public static void readSponsorsFromCsv() throws FileNotFoundException, ParseException {
        List<String[]> parametersCsv = readService.read("src\\com\\company\\csv\\sponsor.csv");
        for (int k = 0; k < parametersCsv.size() - 1; k++) {
            try {
                sponsorService.createSponsor(parametersCsv, true);
            } catch (Exception e) {
                System.out.println("Something didn't work.");
            }
        }
    }
}
