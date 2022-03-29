package services;

import client.Client;
import events.Event;
import ticket.Ticket;

import java.util.ArrayList;
import java.util.Arrays;

public class ClientService {
    static ArrayList<Client> clients = new ArrayList<Client>();
    static Integer id = 0;

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

    public void getClients() { //works
        if (clients.size() == 0) {
            System.out.println("There are 0 clients :(.");
        } else for (Client client : clients) {
            System.out.println(client);
        }
    }

    public void deleteClientById(Integer id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                clients.remove(client);
                System.out.println(client + " has been successfully removed.");
                break;
            }
        }
    }

    public void buyTicket(String parameters) {
        String[] parametersArray = parameters.split(", ");
        Integer clientId = Integer.valueOf(parametersArray[0]);
        Integer eventId = Integer.valueOf(parametersArray[1]);
        EventsService eventsService = new EventsService();
        Event event = eventsService.getEventById(eventId);
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
