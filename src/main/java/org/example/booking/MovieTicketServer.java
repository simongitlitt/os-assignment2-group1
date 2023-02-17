package org.example.booking;

public class MovieTicketServer {
    private String movieName;
    private int availableSeats;

    public MovieTicketServer(String movieName, int availableSeats) {
       this.movieName = movieName;
       this.availableSeats = availableSeats;
    }

    public synchronized void bookTicket(int numberOfSeats, String customerName) {
        System.out.println("Hi," + customerName + " : " + availableSeats + " : Seats available for " + movieName);

        if ((availableSeats - numberOfSeats) < 0) {
            System.out.println("Hi," + customerName + " : Seats not available for " + movieName);
            return;
        }
            setAvailableSeats(availableSeats - numberOfSeats);
            System.out.println("Hi," + customerName + " : " + numberOfSeats + " Seats booked successfully for " + movieName);
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}