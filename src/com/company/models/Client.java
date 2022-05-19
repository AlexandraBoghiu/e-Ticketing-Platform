package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    static private Integer idCount = 0;
    final private Integer id;
    private String firstName;
    private String lastName;
    private String password;
    private List<Ticket> tickets = new ArrayList<>();

    public Client(String firstName, String lastName, List<Ticket> tickets) {
        idCount++;
        this.id = idCount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tickets = tickets;
        this.password = "tempPassword";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static Integer getIdCount() {
        return idCount;
    }

    public static void setIdCount(Integer idCreator) {
        Client.idCount = idCreator;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + this.id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tickets=" + tickets +
                '}';
    }
}
