### a) Language Feature in Methods `challenge1` and `challenge2`

The language feature involved in the methods `challenge1` and `challenge2` is **polymorphism**, specifically using interfaces and generics.

- **Polymorphism**: Both methods make use of polymorphism to handle objects that can perform multiple behaviors (flying and walking).
- **Generics**: The method `challenge2` uses generics with multiple bounds (`<X extends Winged & Bipedal>`) to enforce that the type must implement both `Winged` and `Bipedal` interfaces.

### b) Key Functional Differences Between `challenge1` and `challenge2`

Although the methods appear to perform the same actions based on their output, there are key functional differences:

1. **`challenge1`**:
   - This method accepts a parameter of type `Bird`, which is a concrete class that already implements both `Winged` and `Bipedal` interfaces.
   - It is less flexible as it only accepts objects that are instances of `Bird` or its subclasses.

2. **`challenge2`**:
   - This method uses generics with multiple bounds (`<X extends Winged & Bipedal>`), allowing it to accept any object that implements both `Winged` and `Bipedal` interfaces.
   - It is more flexible as it can accept a wider variety of objects, not limited to those that extend `Bird`.

### c) Demonstrating the Advantages of `challenge2`

To demonstrate the advantages of `challenge2`, let's create another class that implements both `VolumeCalculation ` and `SurfaceAreaCalculation ` but does not extend `Cube`. This will show how `challenge2` can handle a more diverse set of objects.

```java
package fi.utu.tech.ooj.exercise4.exercise3;

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
        return (4.0/3.0) * Math.PI * radius * radius * radius;
    }

    public double surfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
}

public class Exercise3 {
    public Exercise3() {
        System.out.println("Exercise 4");

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
```