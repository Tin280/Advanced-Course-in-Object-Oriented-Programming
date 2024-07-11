public class Main {
    public static void main(String[] args) {
        LoanCalculator calculator = new LoanLogic();
        Input app = new Input(calculator);
        app.run();
    }
}