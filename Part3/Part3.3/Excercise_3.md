
## Justification of Choices

### 1. **Abstract `Shape` Class**
The `Shape` class is defined as an abstract class to serve as a blueprint for all shape types. This approach leverages polymorphism and ensures that each specific shape implements the `area()` and `boundaries()` methods according to its characteristics.

**Benefits:**
- **Extensibility:** New shapes can be added by extending the `Shape` class and providing implementations for the abstract methods.
- **Code Reusability:** Common behaviors or properties of shapes can be defined in the `Shape` class, reducing code duplication.

### 2. **`Point` Record**
The `Point` class is defined as a `record` to encapsulate the coordinates of a point. Records in Java provide a concise syntax for creating data classes with automatic generation of getters, `toString()`, `equals()`, and `hashCode()` methods.

**Benefits:**
- **Immutability:** Records are inherently immutable, which makes it easier to reason about the code and avoid unintended side effects.
- **Simplicity:** The concise syntax improves readability and reduces boilerplate code.

### 3. **Specific Shape Classes (`Triangle`, `Quadrilateral`, `Circle`)**
Each specific shape class (e.g., `Triangle`, `Quadrilateral`, `Circle`) extends the `Shape` class and provides implementations for the `area()` and `boundaries()` methods.

**Benefits:**
- **Encapsulation:** Each shape class encapsulates its own logic for calculating the area and boundaries, adhering to the single responsibility principle.
- **Flexibility:** Different shapes can have different implementations for their behavior, making the code more flexible and easier to maintain.

### 4. **Main Program (`Exercise3` Class)**
The main program logic is encapsulated in the `Exercise3` class. It handles user input, creates shape objects, calculates the total area, and determines the boundaries of all shapes combined.

**Benefits:**
- **Separation of Concerns:** The main program logic is separated from the shape definitions, making the code more modular and easier to understand.
- **Scalability:** The program can handle an arbitrary number of shapes and can be easily extended to include new shapes or operations.



### Interaction
* The program will prompt you to enter the type of shape (triangle, quadrilateral, circle).
* For each shape, you will be prompted to enter the coordinates of the relevant points.
* You can continue adding shapes until you choose to stop.
The program will then calculate and display the total area covered by the shapes and their common boundaries.

### Example Session

```
A circle is defined by a centre and a perimeter point, the others by corner points
Do you want to add a shape (yes/no)? yes
Enter the pattern type (triangle, quadrilateral, circle): triangle
Enter the x-coordinate of the point: 0
Enter the y-coordinate of the point: 0
Enter the x-coordinate of the point: 1
Enter the y-coordinate of the point: 0
Enter the x-coordinate of the point: 0
Enter the y-coordinate of the point: 1
Do you want to add a shape (yes/no)? no
Sum of area covered by the patterns: 0.500000

The common boundaries of the patterns: (0, 0) x (1, 1)
```