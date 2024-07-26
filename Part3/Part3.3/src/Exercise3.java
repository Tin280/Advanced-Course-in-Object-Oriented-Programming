import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise3 {

    public Exercise3() {
        System.out.println("Exercise 3");
    }

    static String readType() {
        System.out.print("Enter the pattern type (triangle, quadrilateral, circle): ");
        return new Scanner(System.in).next();
    }

    static Point readPoint() {
        System.out.print("Enter the x-coordinate of the point: ");
        var x = new Scanner(System.in).nextInt();
        System.out.print("Enter the y-coordinate of the point: ");
        var y = new Scanner(System.in).nextInt();
        return new Point(x, y);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("A circle is defined by a centre and a perimeter point, the others by corner points");

        List<Shape> shapes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Do you want to add a shape (yes/no)? ");
            if (!scanner.next().equalsIgnoreCase("yes"))
                break;

            String type = readType();
            switch (type) {
                case "triangle" -> shapes.add(new Triangle(readPoint(), readPoint(), readPoint()));
                case "quadrilateral" -> shapes.add(new Quadrilateral(readPoint(), readPoint()));
                case "circle" -> shapes.add(new Circle(readPoint(), readPoint()));
                default -> throw new Exception("Unfamiliar pattern!");
            }
        }

        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.area();
        }
        System.out.printf("Sum of area covered by the patterns: %f\n\n", totalArea);

        int x1 = Integer.MIN_VALUE, y1 = Integer.MIN_VALUE;
        int x2 = Integer.MAX_VALUE, y2 = Integer.MAX_VALUE;
        for (Shape shape : shapes) {
            Point[] bounds = shape.boundaries();
            x1 = Math.max(x1, bounds[1].x());
            y1 = Math.max(y1, bounds[1].y());
            x2 = Math.min(x2, bounds[0].x());
            y2 = Math.min(y2, bounds[0].y());
        }

        System.out.printf("The common boundaries of the patterns: (%d, %d) x (%d, %d)\n\n", x2, y2, x1, y1);
    }
}
