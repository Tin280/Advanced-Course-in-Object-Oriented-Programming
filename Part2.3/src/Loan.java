/*
 * @.classInvariant:
 *      principleAmount > 0 && 0<=loanTerm <=300
 */
public record Loan(double principleAmount, int loanTerm) {
    /*
     * @.pre: true
     * 
     * @.post: Object is constructed
     * throw NonePrincipleAmonountException if principleAmount is less or equal to 0
     * throw InvalidLoanTermException if out of range from to 0 to 300
     * 
     */
    public Loan {
        if (principleAmount <= 0) {
            throw new InvalidPrincipleAmonountException("Principle amount must greater than zero");
        }

        if (loanTerm < 0 || loanTerm > 300) {
            throw new InvalidLoanTermException("Loan term need to be in range 0-300");
        }
    }
}

class InvalidPrincipleAmonountException extends RuntimeException {
    public InvalidPrincipleAmonountException(String message) {
        super(message);
    }
}

class InvalidLoanTermException extends RuntimeException {
    public InvalidLoanTermException(String message) {
        super(message);
    }
}
