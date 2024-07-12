import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BusTicketSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Card card = new Card(100.0); // Example card with 100 euros balance

        while (true) {
            System.out.println("1. Buy Single Ticket (3 euros)");
            System.out.println("2. Buy Day Ticket (8 euros)");
            System.out.println("3. Buy Monthly Ticket (55 euros)");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();

            Ticket ticket = null;
            switch (choice) {
                case 1:
                    ticket = new SingleTicket();
                    break;
                case 2:
                    ticket = new DayTicket();
                    break;
                case 3:
                    ticket = new MonthlyTicket();
                    break;
                case 4:
                    System.out.println("Balance: " + card.getBalance() + " euros");
                    continue;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            if (ticket != null) {
                Ticket validTicket = card.getValidTicket();
                if (validTicket != null) {
                    long remainingTime = validTicket.getRemainingTime();
                    System.out.println("You already have a valid ticket. Time remaining: " +
                            formatTime(remainingTime));
                } else {
                    if (card.addTicket(ticket)) {
                        System.out.println("Ticket purchased successfully. Your new balance is " + card.getBalance() + " euros.");
                    } else {
                        System.out.println("Insufficient balance. Can't get on the bus.");
                    }
                }
            }
        }
    }

    private static String formatTime(long millis) {
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        return String.format("%02d hours %02d minutes %02d seconds", hours, minutes, seconds);
    }
}
