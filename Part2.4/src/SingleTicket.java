public class SingleTicket extends Ticket {
    private static final double PRICE = 3.0;
    private static final long VALIDITY_DURATION = 2 * 60 * 60 * 1000; // 2 hours in milliseconds

    public SingleTicket() {
        super(VALIDITY_DURATION);
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}
