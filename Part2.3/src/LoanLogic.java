public class LoanLogic implements LoanCalculator {
    /*
     * Calculate monthly installment
     *
     * @.pre: loan !=null
     * 
     * @.post: Result >=0
     * throw ZeroLoanTermEx when loan term is equal to zero.
     * 
     */
    @Override
    public double CalculateMonthlyInstallment(Loan loan) throws LoanCalculationException {
        if (loan.loanTerm() == 0) {
            throw new ZeroLoanTermEx("Loan term must be greter than zero");
        }
        return loan.principleAmount() / loan.loanTerm() + loan.principleAmount() / 240;
    }

}

class ZeroLoanTermEx extends LoanCalculationException {
    public ZeroLoanTermEx(String message) {
        super(message);
    }
}
