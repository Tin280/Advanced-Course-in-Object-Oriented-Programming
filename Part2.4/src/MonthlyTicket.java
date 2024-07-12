public class MonthlyTicket extends Ticket {
    private static final double PRICE = 55.0;
    private static final long VALIDITY_DURATION = 30L * 24 * 60 * 60 * 1000; // 30 days in milliseconds

    public MonthlyTicket() {
        super(VALIDITY_DURATION);
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}
