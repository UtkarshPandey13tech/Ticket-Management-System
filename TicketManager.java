import java.util.*;

public class TicketManager {
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private int maxSeats = 10;
    private int nextTicketId;

    public TicketManager() {
        tickets = DataHandler.loadTickets();
        nextTicketId = tickets.stream().mapToInt(Ticket::getTicketId).max().orElse(0) + 1;
    }

    public void bookTicket(String passengername, int age, String from, String to) {
        if (tickets.size() >= maxSeats) {
            System.out.println("No Seat Available");
            return;
        }
        int seatno = tickets.size() + 1;
        Ticket ticket = new Ticket(nextTicketId++, passengername, age, from, to, seatno);
        tickets.add(ticket);
        DataHandler.saveTickets(tickets);
        System.out.println("Ticket Booked Successfully " + ticket);
    }

    public void cancelTicket(int ticketid) {
        Ticket t = tickets.stream().filter(ticket -> ticket.getTicketId() == ticketid).findFirst().orElse(null);
        if (t != null) {
            tickets.remove(t);
            DataHandler.saveTickets(tickets);
            System.out.println("Ticket Cancelled Successfully");
        } else {
            System.out.println("Not found");
        }
    }

    public void viewTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No Tickets booked Yet");
            return;
        }
        tickets.forEach((ticket) -> {
            System.out.println(ticket);
        });
    }

    public void viewAvailableSeats() {
        System.out.println("Available Seats: " + (maxSeats - tickets.size()));
    }
}