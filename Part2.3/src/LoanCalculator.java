public interface LoanCalculator {
    /*
     * Calculate monthly installment
     * 
     * @.pre: loan !=null
     * 
     * @.post: Result >=0
     * throw LoanCalculateException if there is an error when it calculate.
     *
     */
    double CalculateMonthlyInstallment(Loan loan) throws LoanCalculationException;

}

class LoanCalculationException extends RuntimeException {
    public LoanCalculationException(String message) {
        super(message);
    }
}
