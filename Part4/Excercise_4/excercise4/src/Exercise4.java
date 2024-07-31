package fi.utu.tech.ooj.exercise4.exercise4;

import java.io.IOException;

public class Exercise4 {
    public Exercise4() {
        System.out.println("Exercise 4");

        System.out.println("Exercise 1");
        try (var zipper = new TestZipper("books.zip")) {
            zipper.run();
        } catch (IOException e) {
            System.err.println("Execution failed!");
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("Exercise 2");
        try (var zipper = new TestZipper2("books.zip")) {
            zipper.run();
        } catch (IOException e) {
            System.err.println("Execution failed!");
            e.printStackTrace();
        }
    }
}
