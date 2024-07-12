import java.util.ArrayList;
import java.util.List;

public class Card {
    private double balance;
    private List<Ticket> tickets;

    public Card(double initialBalance) {
        this.balance = initialBalance;
        this.tickets = new ArrayList<>();
    }

    public boolean addTicket(Ticket ticket) {
        if (this.balance >= ticket.getPrice()) {
            this.balance -= ticket.getPrice();
            this.tickets.add(ticket);
            return true;
        }
        return false;
    }

    public Ticket getValidTicket() {
        for (Ticket ticket : tickets) {
            if (ticket.isValid()) {
                return ticket;
            }
        }
        return null;
    }

    public double getBalance() {
        return balance;
    }
}
