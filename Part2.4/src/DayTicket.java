public class DayTicket extends Ticket {
    private static final double PRICE = 8.0;
    private static final long VALIDITY_DURATION = 24 * 60 * 60 * 1000; // 24 hours in milliseconds

    public DayTicket() {
        super(VALIDITY_DURATION);
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}
