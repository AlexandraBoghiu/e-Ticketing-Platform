package client;

import ticket.Ticket;

import java.util.ArrayList;


public class Client {
    private String firstName;
    private String lastName;
    private ArrayList<Ticket> tickets;

    public Client(String firstName, String lastName, ArrayList<Ticket> tickets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tickets = tickets;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
}
