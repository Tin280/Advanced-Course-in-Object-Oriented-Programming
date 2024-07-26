public class Quadrilateral extends Shape {
    private final Point p1, p2;

    public Quadrilateral(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    double area() {
        int x1 = Math.max(p1.x(), p2.x());
        int y1 = Math.max(p1.y(), p2.y());
        int x2 = Math.min(p1.x(), p2.x());
        int y2 = Math.min(p1.y(), p2.y());
        return (x1 - x2) * (y1 - y2);
    }

    @Override
    Point[] boundaries() {
        int x1 = Math.max(p1.x(), p2.x());
        int y1 = Math.max(p1.y(), p2.y());
        int x2 = Math.min(p1.x(), p2.x());
        int y2 = Math.min(p1.y(), p2.y());
        return new Point[] { new Point(x2, y2), new Point(x1, y1) };
    }
}
