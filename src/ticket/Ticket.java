package ticket;

import client.Client;
import events.Event;
public class Ticket {
    private Integer seatNumber;
    private double price;
    private Client client;
    private Event event;

    public Ticket(Integer seatNumber, double price, Client client, Event event) {
        this.seatNumber = seatNumber;
        this.price = price;
        this.client = client;
        this.event = event;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
