import java.util.Scanner;

public class main {
    public main() {
        System.out.println("Exercise 3");
    }

    record Point(int x, int y) {
    }

    static String readType(Scanner scanner) {
        System.out.print("Enter the pattern type (triangle, quadrilateral, circle): ");
        return scanner.next();
    }

    static Point readPoint(Scanner scanner) {
        System.out.print("Enter the x-coordinate of the point: ");
        var x = scanner.nextInt();
        System.out.print("Enter the y-coordinate of the point: ");
        var y = scanner.nextInt();
        return new Point(x, y);
    }

    static Point[] boundaries(Object[] ps) {
        int x1 = Integer.MIN_VALUE, y1 = Integer.MIN_VALUE;
        int x2 = Integer.MAX_VALUE, y2 = Integer.MAX_VALUE;

        for (int i = 1; i < ps.length - (ps[0].equals("triangle") ? 0 : 1); i++) {
            x1 = Math.max(x1, ((Point) ps[i]).x);
            y1 = Math.max(y1, ((Point) ps[i]).y);
            x2 = Math.min(x2, ((Point) ps[i]).x);
            y2 = Math.min(y2, ((Point) ps[i]).y);
        }

        assert (x1 >= x2);
        assert (y1 >= y2);

        return new Point[] { new Point(x1, y1), new Point(x2, y2) };
    }

    static double area(Object[] ps) throws Exception {
        int x1 = Integer.MIN_VALUE, y1 = Integer.MIN_VALUE;
        int x2 = Integer.MAX_VALUE, y2 = Integer.MAX_VALUE;

        for (int i = 1; i < ps.length - (ps[0].equals("triangle") ? 0 : 1); i++) {
            x1 = Math.max(x1, ((Point) ps[i]).x);
            y1 = Math.max(y1, ((Point) ps[i]).y);
            x2 = Math.min(x2, ((Point) ps[i]).x);
            y2 = Math.min(y2, ((Point) ps[i]).y);
        }

        assert (x1 >= x2);
        assert (y1 >= y2);

        return switch ((String) ps[0]) {
            case "triangle" -> (x1 - x2) * (y1 - y2) / 2;
            case "quadrilateral" -> (x1 - x2) * (y1 - y2);
            case "circle" -> Math.PI * ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            default -> throw new Exception("Unfamiliar pattern!");
        };
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("A circle is defined by a centre and a perimeter point, the others by corner points");

        Object[] p1 = new Object[4];
        p1[0] = readType(scanner);
        p1[1] = readPoint(scanner);
        p1[2] = readPoint(scanner);
        if (p1[0].equals("triangle"))
            p1[3] = readPoint(scanner);

        Object[] p2 = new Object[4];
        p2[0] = readType(scanner);
        p2[1] = readPoint(scanner);
        p2[2] = readPoint(scanner);
        if (p2[0].equals("triangle"))
            p2[3] = readPoint(scanner);

        double areaSum = area(p1) + area(p2);
        System.out.printf("Sum of area covered by the patterns:\n%f\n\n", areaSum);

        int x1 = Integer.MIN_VALUE, y1 = Integer.MIN_VALUE;
        int x2 = Integer.MAX_VALUE, y2 = Integer.MAX_VALUE;

        Point[] b1 = boundaries(p1);
        x1 = Math.max(x1, b1[0].x);
        y1 = Math.max(y1, b1[0].y);
        x2 = Math.min(x2, b1[1].x);
        y2 = Math.min(y2, b1[1].y);

        Point[] b2 = boundaries(p2);
        x1 = Math.max(x1, b2[0].x);
        y1 = Math.max(y1, b2[0].y);
        x2 = Math.min(x2, b2[1].x);
        y2 = Math.min(y2, b2[1].y);

        assert (x1 >= x2);
        assert (y1 >= y2);

        System.out.printf("The common boundaries of the patterns:\n(%d, %d) x (%d, %d)\n\n", x2, y2, x1, y1);
    }
}
