package org.example.booking;

public class MovieTicketClient extends Thread {
    private String customerName;
    private int numberOfSeats;
    private MovieTicketServer server;

    public MovieTicketClient(MovieTicketServer movieTicketServer, String customerName, int numberOfSeats) {
        this.customerName = customerName;
        this.numberOfSeats = numberOfSeats;
        this.server = movieTicketServer;
    }

    public void run() {
        server.bookTicket(numberOfSeats, customerName);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public MovieTicketServer getServer() {
        return server;
    }

    public void setServer(MovieTicketServer server) {
        this.server = server;
    }
}