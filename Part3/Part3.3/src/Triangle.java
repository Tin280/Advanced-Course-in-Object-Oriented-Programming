public class Triangle extends Shape {
    private final Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    double area() {
        int x1 = Math.max(p1.x(), Math.max(p2.x(), p3.x()));
        int y1 = Math.max(p1.y(), Math.max(p2.y(), p3.y()));
        int x2 = Math.min(p1.x(), Math.min(p2.x(), p3.x()));
        int y2 = Math.min(p1.y(), Math.min(p2.y(), p3.y()));
        return (x1 - x2) * (y1 - y2) / 2.0;
    }

    @Override
    Point[] boundaries() {
        int x1 = Math.max(p1.x(), Math.max(p2.x(), p3.x()));
        int y1 = Math.max(p1.y(), Math.max(p2.y(), p3.y()));
        int x2 = Math.min(p1.x(), Math.min(p2.x(), p3.x()));
        int y2 = Math.min(p1.y(), Math.min(p2.y(), p3.y()));
        return new Point[] { new Point(x2, y2), new Point(x1, y1) };
    }
}
