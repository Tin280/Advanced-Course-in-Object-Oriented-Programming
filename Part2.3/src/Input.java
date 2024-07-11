import java.util.Scanner;

public class Input {
    private final LoanCalculator lCalculator;

    /*
     * @.pre: lCalculator!= null
     * 
     * @.post: object is constructed
     */
    public Input(LoanCalculator lCalculator) {
        this.lCalculator = lCalculator;
    }

    /*
     * Take the input from user ->calculate and display monthly installment
     * 
     * @.pre: true
     * 
     * @.post: print the monthly installment.
     */

    public void run() {
        while (true) {
            try {
                Loan loan = createUserInput();
                double monthlyInstallment = lCalculator.CalculateMonthlyInstallment(loan);
                displayMonthlyInstallment(monthlyInstallment);

                break;
            } catch (LoanCalculationException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private Loan createUserInput() {
        Loan loan;
        Scanner reader = new Scanner(System.in);
        while (true) {
            try {
                double principleAmount = getInputPrincipleAmount(reader);
                int loanTerm = getInputLoanTerm(reader);

                loan = new Loan(principleAmount, loanTerm);

                break;
            } catch (InvalidLoanTermException | InvalidPrincipleAmonountException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
        return loan;
    }

    private void displayMonthlyInstallment(double installment) {
        System.out.println("Monthly installment: " + installment);
    }

    private double getInputPrincipleAmount(Scanner reader) {
        double principleAmount;

        while (true) {
            try {
                System.out.print("Principle amount: ");
                principleAmount = Double.parseDouble(reader.next());

                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return principleAmount;
    }

    private int getInputLoanTerm(Scanner reader) {
        int loanTerm;

        while (true) {
            try {
                System.out.print("Loan Term in month: ");
                loanTerm = Integer.parseInt(reader.next());

                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return loanTerm;
    }

}
