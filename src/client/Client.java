package client;

import ticket.Ticket;

import java.util.ArrayList;


public class Client {
    final private Integer id;
    private String firstName;
    private String lastName;
    private ArrayList<Ticket> tickets;

    public Client(Integer id, String firstName, String lastName, ArrayList<Ticket> tickets) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tickets = tickets;
    }

    public Integer getId() {
        return id;
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

    @Override
    public String toString() {
        return "Client{" +
                "id='" + this.id + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
