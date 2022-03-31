import services.ClientService;
import services.EventsService;
import services.LocationService;
import services.SponsorService;

import java.text.ParseException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        EventsService eventsService = new EventsService();
        ClientService clientService = new ClientService();
        SponsorService sponsorService = new SponsorService();
        LocationService locationService = new LocationService();
        String command, parameters;
        boolean admin = false;
        boolean client = false;
        boolean connected = true;
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
                            clientService.createClient(parameters);
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
                            eventsService.createFootballGameEvent(parameters);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "createConcertEvent":
                        System.out.println("You're creating a concert event. Please enter the event's data in the following format:" +
                                " name, numberOfTickets, ticketPrice, date(day/month/year) time(hh:mm), country, city, " +
                                "address, timeLength, artist, genre");
                        parameters = scanner.nextLine();
                        try {
                            eventsService.createConcertEvent(parameters);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "createMovieEvent":
                        System.out.println("You're creating a movie event. Please enter the event's data in the following format:" +
                                " name, numberOfTickets, ticketPrice, date(day/month/year) time(HH:mm), country, city, " +
                                "address, timeLength, genre, director, yearOfProduction");
                        parameters = scanner.nextLine();
                        try {
                            eventsService.createMovieEvent(parameters);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "createSponsor":
                        System.out.println("You're creating a sponsor. Please enter the sponsor's data in the following format:" +
                                " name, type(gold/silver/bronze)");
                        parameters = scanner.nextLine();
                        try {
                            sponsorService.createSponsor(parameters);
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
                            eventsService.updateFootballGameEvent(parameters);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "updateConcertEvent":
                        System.out.println("You're updating a concert event. Please enter the event's updated data in the following format:" +
                                " id, newNumberOfTickets, newTicketPrice, newDate(day/month/year) newTime(hh:mm), newCountry, newCity, " +
                                "newAddress, newTimeLength\n If there is unchanged information, " +
                                "enter the old data for those fields. Note that the event's name, artist and genre cannot be changed.");
                        parameters = scanner.nextLine();
                        try {
                            eventsService.updateConcertEvent(parameters);
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
                            eventsService.updateMovieEvent(parameters);
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
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "getEvents":
                        eventsService.getEvents();
                        break;
                    case "getClients":
                        clientService.getClients();
                        break;
                    case "getTicketsByClientId":
                        System.out.println("Please enter client's id");
                        parameters = scanner.nextLine();
                        try {
                            clientService.getTicketsByClientId(Integer.valueOf(parameters));
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "getSponsors":
                        sponsorService.getSponsors();
                        break;
                    case "getSponsorsByType":
                        System.out.println("Please enter the desired type(gold/silver/bronze).");
                        parameters = scanner.nextLine();
                        try {
                            sponsorService.getSponsorsByType(parameters);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "addSponsorToEvent":
                        System.out.println("Please enter event's id and the sponsor's id in the following format: eventId, sponsorId");
                        parameters = scanner.nextLine();
                        try {
                            eventsService.addSponsorToEvent(parameters);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "deleteEvent":
                        System.out.println("You're deleting an event. Please enter the event's id.");
                        try {
                            Integer id = Integer.valueOf(scanner.nextLine());
                            eventsService.deleteEventById(id);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "deleteClient":
                        System.out.println("You're deleting a client. Please enter the client's id.");
                        try {
                            Integer clientId = Integer.valueOf(scanner.nextLine());
                            clientService.deleteClientById(clientId);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "deleteSponsor":
                        System.out.println("You're deleting a sponsor. Please enter the sponsor's id.");
                        try {
                            Integer sponsorId = Integer.valueOf(scanner.nextLine());
                            sponsorService.deleteSponsorById(sponsorId);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "buyTicket":
                        System.out.println("You're buying a ticket. Please enter the client's id and the event's id in the following format: clientId, eventId");
                        parameters = scanner.nextLine();
                        try {
                            clientService.buyTicket(parameters);
                        } catch (Exception e) {
                            System.out.println("Not a valid input. Please try again.");
                        }
                        break;
                    case "change":
                        System.out.println("okfrt");
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
                    } }
                    if (loggedIn) {
                        while (client) {
                            System.out.println("Please enter a command. Available commands: getInfo, changePassword, getEvents, getSponsors, getSponsorsByType, buyTicket, exit ");
                            command = scanner.nextLine();
                            switch (command) {
                                case "getInfo":
                                    try {
                                        clientService.getInfo(Integer.valueOf(clientId));
                                    } catch (Exception e) {
                                        System.out.println("Error. Please try again.");
                                    }
                                    break;
                                case "changePassword":
                                    System.out.println("You're changing your password. Please write your information in the following format: oldPassword, newPassword");
                                    parameters = clientId.trim() + ", " + scanner.nextLine();
                                    try {
                                        clientService.changePassword(parameters);
                                    } catch (Exception e) {
                                        System.out.println("Not a valid input. Please try again.");
                                    }
                                    break;
                                case "getEvents":
                                    eventsService.getEvents();
                                    break;
                                case "getTickets":
                                    parameters = clientId.trim();
                                    try {
                                        clientService.getTicketsByClientId(Integer.valueOf(parameters));
                                    } catch (Exception e) {
                                        System.out.println("Not a valid input. Please try again.");
                                    }
                                    break;
                                case "getSponsors":
                                    sponsorService.getSponsors();
                                    break;
                                case "getSponsorsByType":
                                    System.out.println("Please enter the desired type(gold/silver/bronze).");
                                    parameters = scanner.nextLine();
                                    try {
                                        sponsorService.getSponsorsByType(parameters);
                                    } catch (Exception e) {
                                        System.out.println("Not a valid input. Please try again.");
                                    }
                                    break;
                                case "buyTicket":
                                    System.out.println("You're buying a ticket. Please enter the recipient's id (can be yours or a friend's) and the event's id in the following format: clientId, eventId");

                                    parameters = scanner.nextLine();
                                    try {
                                        clientService.buyTicket(parameters);
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
