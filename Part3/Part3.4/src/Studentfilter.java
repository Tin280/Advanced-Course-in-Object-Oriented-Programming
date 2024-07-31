public interface Studentfilter {
    boolean filter(StudentRows row);

}

record Studentfiltered() implements Studentfilter {
    @Override
    public boolean filter(StudentRows row) {
        return row.numberOfCredits() >= 280;
    }
}
