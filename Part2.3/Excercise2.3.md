1.Loan Class:
Terms:
principleAmount: The amount of money borrowed. Must be greater than zero.
loanTerm: The duration of the loan in months. Must be between 0 and 300 (inclusive).
Conditions:
Enforced through the constructor using exceptions:
InvalidPrincipleAmonountException: Thrown if principleAmount is less than or equal to zero.
InvalidLoanTermException: Thrown if loanTerm is outside the range of 0 to 300.

2.LoanCalculator Interface:
Purpose: This interface defines a contract for calculating the monthly installment of a loan.
Terms: No explicit terms defined in the interface itself.

3.LoanLogic Class (implements LoanCalculator):

Purpose: This class implements the LoanCalculator interface and provides the logic for calculating the monthly installment.
Conditions:
CalculateMonthlyInstallment method:
Throws ZeroLoanTermEx if the loanTerm is zero. This exception extends LoanCalculationException.

4.Purpose: This class handles user input for loan parameters and displays the calculated monthly installment.
Conditions:
The createUserInput method handles user input and catches exceptions thrown during loan creation:
InvalidLoanTermException and InvalidPrincipleAmonountException: These exceptions are caught and their error messages are displayed to the user. The user is prompted to re-enter the values.

5.Special Situations:

Invalid User Input: The Input class handles potential errors during user input for loan amount and term. If the user enters a non-numeric value, a NumberFormatException is thrown and caught. The user is prompted to re-enter the value.
Loan Term Zero: The LoanLogic class throws a ZeroLoanTermEx if the loan term is zero. This exception is caught in the Input class, and an error message is displayed to the user.