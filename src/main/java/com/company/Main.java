package com.company;

import com.company.config.DatabaseConfiguration;
import com.company.helpers.CsvReader;
import com.company.models.Client;
import com.company.models.Concert;
import com.company.models.FootballGame;
import com.company.repository.SponsorRepository;
import com.company.services.*;

import javax.xml.crypto.Data;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scanner = new Scanner(System.in);
        EventService eventService = EventService.getInstance();
        ClientService clientService = ClientService.getInstance();
        SponsorService sponsorService = SponsorService.getInstance();
        WriteService writeService = new WriteService();
        AuditService audit = AuditService.getInstance();
        String command, parameters;
        boolean admin = false;
        boolean client = false;
        boolean connected = true;
        CsvReader.readClientsFromCsv();
        CsvReader.readFootballGamesFromCsv();
        CsvReader.readConcertsFromCsv();
        CsvReader.readMoviesFromCsv();
        CsvReader.readSponsorsFromCsv();

        SponsorRepository sponsorRepository = new SponsorRepository();
        sponsorRepository.createTable();
        DatabaseConfiguration.closeDatabaseConnection();
        System.out.println("Please type client for client rights or admin for admin rights.");
        String choice = scanner.nextLine().toLowerCase();
        if (!choice.equals("admin") && !choice.equals("client"))
            System.out.println("Sorry. Invalid choice.");
        if (choice.equals("admin")) admin = true;
        else client = true;
        while (connected) {
            while (admin) {
                System.out.println("Please enter a command. Available commands: \nCREATE: createClient, createFootballGameEvent, createConcertEvent," +
                        " createMovieEvent, createSponsor, \nUPDATE: updateClient, updateFootballGameEvent, updateConcertEvent," +
                        " updateMovieEvent, updateSponsor, \nGET: getEvents, getClients, getSponsors, getSponsorsByType, \nDELETE: deleteEvent," +
                        " deleteClient, deleteSponsor,\naddSponsorToEvent, buyTicket, change, \nexit");
                command = scanner.nextLine();
                switch (command) {
                    case "createClient":
                        System.out.println("You're creating a client. Please enter the client's data in the following format: firstName, lastName");
                        parameters = scanner.nextLine();
                        try {
                            List<String[]> parametersArray = new ArrayList<>(Collections.singletonList(parameters.split(", ")));
                            clientService.createClient(parametersArray, false, true);
                            String[] temp = new String[3];
                            temp[0] = Client.getIdCount().toString();
                            for (int i = 0; i < parametersArray.get(0).length; i++) {
                                temp[i + 1] = parametersArray.get(0)[i];
                            }
                            parametersArray.set(0, temp);
                            writeService.writeToCsvFile(parametersArray, "src\\com\\company\\resources\\client.csv");
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "createFootballGameEvent":
                        System.out.println("You're creating a football game event. Please enter the event's data in the following format:" +
                                " name, numberOfTickets, ticketPrice, date(day/month/year) time(hh:mm), country, city, " +
                                "address, firstTeam, secondTeam, stadium, competition");
                        parameters = scanner.nextLine();
                        try {
                            List<String[]> parametersArray = new ArrayList<>(Collections.singletonList(parameters.split(", ")));
                            eventService.createFootballGameEvent(parametersArray, false);
                            String[] temp = new String[12];
                            temp[0] = FootballGame.getIdCount().toString();
                            for (int i = 0; i < parametersArray.get(0).length; i++) {
                                temp[i + 1] = parametersArray.get(0)[i];
                            }
                            parametersArray.set(0, temp);
                            writeService.writeToCsvFile(parametersArray, "src\\com\\company\\resources\\footballgame.csv");
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "createConcertEvent":
                        System.out.println("You're creating a concert event. Please enter the event's data in the following format:" +
                                " name, numberOfTickets, ticketPrice, date(day/month/year) time(hh:mm), country, city, " +
                                "address, genre, artist");
                        parameters = scanner.nextLine();
                        try {
                            List<String[]> parametersArray = new ArrayList<>(Collections.singletonList(parameters.split(", ")));
                            eventService.createConcertEvent(parametersArray, false);
                            String[] temp = new String[10];
                            temp[0] = Concert.getIdCount().toString();
                            for (int i = 0; i < parametersArray.get(0).length; i++) {
                                temp[i + 1] = parametersArray.get(0)[i];
                            }
                            parametersArray.set(0, temp);
                            writeService.writeToCsvFile(parametersArray, "src\\com\\company\\resources\\concert.csv");
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "createMovieEvent":
                        System.out.println("You're creating a movie event. Please enter the event's data in the following format:" +
                                " name, numberOfTickets, ticketPrice, date(day/month/year) time(HH:mm), country, city, " +
                                "address, genre, director, yearOfProduction");
                        parameters = scanner.nextLine();
                        try {
                            List<String[]> parametersArray = new ArrayList<>(Collections.singletonList(parameters.split(", ")));
                            eventService.createMovieEvent(parametersArray, false);
                            String[] temp = new String[11];
                            temp[0] = Concert.getIdCount().toString();
                            for (int i = 0; i < parametersArray.get(0).length; i++) {
                                temp[i + 1] = parametersArray.get(0)[i];
                            }
                            parametersArray.set(0, temp);
                            writeService.writeToCsvFile(parametersArray, "src\\com\\company\\resources\\movie.csv");
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "createSponsor":
                        System.out.println("You're creating a sponsor. Please enter the sponsor's data in the following format:" +
                                " name, type(gold/silver/bronze)");
                        parameters = scanner.nextLine();
                        try {
                            List<String[]> parametersArray = new ArrayList<>(Collections.singletonList(parameters.split(", ")));
                            sponsorService.createSponsor(parametersArray, false);
                            String[] temp = new String[4];
                            temp[0] = Concert.getIdCount().toString();
                            for (int i = 0; i < parametersArray.get(0).length; i++) {
                                temp[i + 1] = parametersArray.get(0)[i];
                            }
                            parametersArray.set(0, temp);
                            writeService.writeToCsvFile(parametersArray, "src\\com\\company\\resources\\sponsor.csv");
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "updateClient":
                        System.out.println("You're updating a client. Please enter the client's updated data in the following format:" +
                                " id, firstName, lastName\n If there is unchanged information, enter the old data for those fields. Note that the client's id cannot be changed.");
                        parameters = scanner.nextLine();
                        try {
                            clientService.updateClient(parameters);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "updateFootballGameEvent":
                        System.out.println("You're updating a football game event. Please enter the event's updated data in the following format:" +
                                " id, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
                                "newAddress, newStadium\n If there is unchanged information, " +
                                "enter the old data for those fields. Note that the event's name, teams and competition cannot be changed.");
                        parameters = scanner.nextLine();
                        try {
                            eventService.updateFootballGameEvent(parameters);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "updateConcertEvent":
                        System.out.println("You're updating a concert event. Please enter the event's updated data in the following format:" +
                                " id, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
                                "newAddress\n If there is unchanged information, " +
                                "enter the old data for those fields. Note that the event's name, artist and genre cannot be changed.");
                        parameters = scanner.nextLine();
                        try {
                            eventService.updateConcertEvent(parameters);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "updateMovieEvent":
                        System.out.println("You're updating a movie event. Please enter the event's updated data in the following format:" +
                                " id, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
                                "newAddress\n If there is unchanged information, " +
                                "enter the old data for those fields. Note that the event's name, movie, genre, director and year of production cannot be changed.");
                        parameters = scanner.nextLine();
                        try {
                            eventService.updateMovieEvent(parameters);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "updateSponsor":
                        System.out.println("You're updating a sponsor. Please enter the sponsor's updated data in the following format:" +
                                " id, name. Note that the sponsor's id and type cannot be changed.");
                        parameters = scanner.nextLine();
                        try {
                            sponsorService.updateSponsor(parameters);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "getEvents":
                        try {
                            eventService.getEvents();
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("getEvents returned an exception.");
                        }
                        break;
                    case "getClients":
                        try {
                            clientService.getClients();
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("getClients returned an exception.");
                        }

                        break;
                    case "getTicketsByClientId":
                        System.out.println("Please enter client's id");
                        parameters = scanner.nextLine();
                        try {
                            clientService.getTicketsByClientId(Integer.valueOf(parameters));
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "getSponsors":
                        try {
                            sponsorService.getSponsors();
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("getSponsors returned an exception.");
                        }
                        break;
                    case "getSponsorsByType":
                        System.out.println("Please enter the desired type(gold/silver/bronze).");
                        parameters = scanner.nextLine();
                        try {
                            sponsorService.getSponsorsByType(parameters);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "addSponsorToEvent":
                        System.out.println("Please enter event's id and the sponsor's id in the following format: eventId, sponsorId");
                        parameters = scanner.nextLine();
                        try {
                            eventService.addSponsorToEvent(parameters);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "deleteEvent":
                        System.out.println("You're deleting an event. Please enter the event's id.");
                        try {
                            Integer id = Integer.valueOf(scanner.nextLine());
                            eventService.deleteEventById(id);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "deleteClient":
                        System.out.println("You're deleting a client. Please enter the client's id.");
                        try {
                            Integer clientId = Integer.valueOf(scanner.nextLine());
                            clientService.deleteClientById(clientId);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "deleteSponsor":
                        System.out.println("You're deleting a sponsor. Please enter the sponsor's id.");
                        try {
                            Integer sponsorId = Integer.valueOf(scanner.nextLine());
                            sponsorService.deleteSponsorById(sponsorId);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "buyTicket":
                        System.out.println("You're buying a ticket. Please enter the client's id and the event's id in the following format: clientId, eventId");
                        parameters = scanner.nextLine();
                        try {
                            clientService.buyTicket(parameters);
                            audit.writeToAudit(command);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "change":
                        admin = false;
                        client = true;
                    case "exit":
                        System.out.println("Have a nice day! :D");
                        admin = false;
                        connected = false;
                        break;
                    default:
                        break;
                }
            }

            if (client) {
                boolean loggedIn = false;
                String clientId = null;
                while (!loggedIn) {
                    System.out.println("Hello! Please enter your id and password to log in in the following format: id, password\n");
                    try {
                        parameters = scanner.nextLine();
                        String[] parametersArray = parameters.split(", ");
                        loggedIn = clientService.logIn(parameters);
                        clientId = parametersArray[0];
                    } catch (Exception e) {
                        System.out.println("Wrong input.");
                    }
                }
                if (loggedIn) {
                    while (client) {
                        System.out.println("Please enter a command. Available commands: getInfo, changePassword, getEvents, getSponsors, getSponsorsByType, buyTicket, exit ");
                        command = scanner.nextLine();
                        switch (command) {
                            case "getInfo":
                                try {
                                    clientService.getInfo(Integer.valueOf(clientId));
                                    audit.writeToAudit(command);
                                } catch (Exception e) {
                                    System.out.println("Error. Please try again.");
                                }
                                break;
                            case "changePassword":
                                System.out.println("You're changing your password. Please write your information in the following format: oldPassword, newPassword");
                                parameters = clientId.trim() + ", " + scanner.nextLine();
                                try {
                                    clientService.changePassword(parameters);
                                    audit.writeToAudit(command);
                                } catch (Exception e) {
                                    System.out.println("Not a valid input. Please try again.");
                                }
                                break;
                            case "getEvents":
                                try {
                                    eventService.getEvents();
                                    audit.writeToAudit(command);
                                } catch (Exception e) {
                                    System.out.println("getEvents returned an exception.");
                                }
                                break;
                            case "getTickets":
                                parameters = clientId.trim();
                                try {
                                    clientService.getTicketsByClientId(Integer.valueOf(parameters));
                                    audit.writeToAudit(command);
                                } catch (Exception e) {
                                    System.out.println("Not a valid input. Please try again.");
                                }
                                break;
                            case "getSponsors":
                                try {
                                    sponsorService.getSponsors();
                                    audit.writeToAudit(command);
                                } catch (Exception e) {
                                    System.out.println("getSponsors returned an exception.");
                                }

                                break;
                            case "getSponsorsByType":
                                System.out.println("Please enter the desired type(gold/silver/bronze).");
                                parameters = scanner.nextLine();
                                try {
                                    sponsorService.getSponsorsByType(parameters);
                                    audit.writeToAudit(command);
                                } catch (Exception e) {
                                    System.out.println("Not a valid input. Please try again.");
                                }
                                break;
                            case "buyTicket":
                                System.out.println("You're buying a ticket. Please enter the recipient's id (can be yours or a friend's) and the event's id in the following format: clientId, eventId");

                                parameters = scanner.nextLine();
                                try {
                                    clientService.buyTicket(parameters);
                                    audit.writeToAudit(command);
                                } catch (Exception e) {
                                    System.out.println("Not a valid input. Please try again.");
                                }
                                break;
                            case "exit":
                                System.out.println("Have a nice day! :D");
                                client = false;
                                connected = false;
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
    }
}
