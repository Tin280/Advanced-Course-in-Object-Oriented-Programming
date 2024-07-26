public class Circle extends Shape {
    private final Point center, perimeter;

    public Circle(Point center, Point perimeter) {
        this.center = center;
        this.perimeter = perimeter;
    }

    @Override
    double area() {
        int dx = center.x() - perimeter.x();
        int dy = center.y() - perimeter.y();
        return Math.PI * (dx * dx + dy * dy);
    }

    @Override
    Point[] boundaries() {
        int dx = Math.abs(center.x() - perimeter.x());
        int dy = Math.abs(center.y() - perimeter.y());
        return new Point[] { new Point(center.x() - dx, center.y() - dy), new Point(center.x() + dx, center.y() + dy) };
    }
}
