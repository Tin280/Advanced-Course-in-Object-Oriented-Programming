interface VolumeCalculation {
    double volume();
}

interface SurfaceAreaCalculation {
    double surfaceArea();
}

class Cube implements VolumeCalculation, SurfaceAreaCalculation {
    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    public double volume() {
        return side * side * side;
    }

    public double surfaceArea() {
        return 6 * side * side;
    }
}

class Sphere implements VolumeCalculation, SurfaceAreaCalculation {
    private final double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double volume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}

public class Exercise3 {
    public Exercise3() {
        System.out.println("Exercise 3");

        challenge1(new Cube(3.0));
        challenge2(new Sphere(3.0));
        // challenge1(new Sphere(3.0)); is not allowed,
        // but the code below can be run.
        challenge2(new Cube(3.0));
    }

    void challenge1(Cube shape) {
        System.out.println("Volume: " + shape.volume());
        System.out.println("Surface Area: " + shape.surfaceArea());
    }

    <X extends VolumeCalculation & SurfaceAreaCalculation> void challenge2(X shape) {
        System.out.println("Volume: " + shape.volume());
        System.out.println("Surface Area: " + shape.surfaceArea());
    }

    public static void main(String[] args) {
        new Exercise3();
    }
}