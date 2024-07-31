
import java.io.IOException;

public class Excercise2 {
    public Excercise2() {
        System.out.println("Excercise2");

        try (var zipper = new TestZipper2("books.zip")) {
            zipper.run();
        } catch (IOException e) {
            System.err.println("Execution failed!");
            e.printStackTrace();
        }
    }
}
