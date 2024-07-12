public abstract class Ticket {
    protected long purchaseTime;
    protected long validityDuration; // in milliseconds

    public Ticket(long validityDuration) {
        this.purchaseTime = System.currentTimeMillis();
        this.validityDuration = validityDuration;
    }

    public boolean isValid() {
        return System.currentTimeMillis() < (purchaseTime + validityDuration);
    }

    public long getRemainingTime() {
        long currentTime = System.currentTimeMillis();
        long expirationTime = purchaseTime + validityDuration;
        return expirationTime - currentTime;
    }

    public abstract double getPrice();
}
