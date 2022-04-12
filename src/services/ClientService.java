package services;

import models.client.Client;
import models.events.Event;
import models.ticket.Ticket;

import java.util.ArrayList;
import java.util.Arrays;

public class ClientService {
    static private ArrayList<Client> clients = new ArrayList<Client>();
    static private Integer id = 0;

    public void createClient(String parameters) {
        id++;
        String[] parametersArray = parameters.split(", ");
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Client client = new Client(id, parametersArray[0].trim(), parametersArray[1].trim(), tickets);
        clients.add(client);
        System.out.println("Client added succesfully. Id: " + id.toString() + "\n");
    }

    public void updateClient(String parameters) {
        String[] parametersArray = parameters.split(", ");
        System.out.println(Arrays.toString(parametersArray));
        Client client = getClientById(Integer.parseInt(parametersArray[0]));
        client.setFirstName(parametersArray[1].trim());
        client.setLastName(parametersArray[2].trim());
        System.out.println("Client updated succesfully.\n");
    }

    private Client getClientById(Integer clientId) {
        for (Client client : clients) {
            if (client.getId().equals(clientId))
                return client;
        }
        return null;
    }
    public void getInfo(Integer clientId) {
        for (Client client : clients) {
            if (client.getId().equals(clientId)) {
                System.out.println(client);
                break;
            }
        }
    }

    public void getClients() {
        if (clients.size() == 0) {
            System.out.println("There are 0 clients :(.");
        } else for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void deleteClientById(Integer id) {
        boolean ok = false;
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                clients.remove(client);
                System.out.println(client + " has been successfully removed.");
                ok = true;
                break;
            }
        }
        if (!ok) System.out.println("Client " + id + " does not exist.");
    }

    public void changePassword(String parameters) {
        String[] parametersArray = parameters.split(", ");
        Integer clientId = Integer.valueOf(parametersArray[0]);
        if (parametersArray[2].length() < 8) System.out.println("Password is too short. (at least 8 characters)");
        else {
            Client client = this.getClientById(clientId);
            if (client != null)
                client.setPassword(parametersArray[1]);
        }
    }
    public boolean logIn(String parameters) {
        String[] parametersArray = parameters.split(", ");
        Integer clientId = Integer.valueOf(parametersArray[0]);
        String password = parametersArray[1];
        Client client = this.getClientById(clientId);
        if (client != null)
        {
            if (!client.getPassword().equals(password)) {
                System.out.println("Wrong password.");
                return false;
            }
            else return true;
        }
        return false;
    }
    public void buyTicket(String parameters) {
        String[] parametersArray = parameters.split(", ");
        Integer clientId = Integer.valueOf(parametersArray[0]);
        Integer eventId = Integer.valueOf(parametersArray[1]);
        EventService eventService = new EventService();
        Event event = eventService.getEventById(eventId);
        Client client = this.getClientById(clientId);
        if (client != null) {
            if (event != null) {
                if (event.getNumberOfTickets() > 0) {
                    Ticket ticket = new Ticket(event);
                    event.setNumberOfTickets(event.getNumberOfTickets() - 1);
                    client.getTickets().add(ticket);

                } else System.out.println("No more tickets available for this event.");
            } else System.out.println("The event " + eventId + " does not exist.");
        } else System.out.println("The client " + clientId + " does not exist.");
    }

    public void getTicketsByClientId(Integer clientId) {
        Client client = this.getClientById(clientId);
        if (client != null) {
            System.out.println(client.getTickets());
        } else System.out.println("The client " + clientId + " does not exist.");
    }
}
