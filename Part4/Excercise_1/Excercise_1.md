## a) Answer:

### 1. Class constructs in `Excercise1`:
   * Basic class: `Excercise1`.

### 2. Class constructs in `TestZipper`:
   * Basic class: `TestZipper`
   * Anonymous class: The `createHandler` method in `TestZipper` returns an instance of an anonymous subclass of `Handler`. This anonymous class provides an implementation for the abstract `handle` method of `Handler`.
   * Function literal: `s -> !s.isBlank()` - It represents a concise way to define an anonymous function.

### 3. Class constructs in `Zipper`:
   * Basic class: `Zipper`
   * Static inner class: `Handler` (defined as `protected abstract static class Handler` within `Zipper`).

## b) Answer:

### 1. Class constructs in `Exercise1`:
   * **Basic class:** `Excercise1`.
   * **Why Chosen:**
      + **Concrete Class:** `Exercise1` is a concrete class because it needs to be instantiated to perform a specific task—initializing and running the `TestZipper`.
   * **Features Used:**
      + **Constructor:** Initializes the class and contains the main logic to run the `TestZipper`.
   * **Why Not Others:**
      + **Static Inner Class / Nested Class:** Not suitable because `Exercise1` needs to be instantiated on its own and does not need to be part of another class.
      + **Anonymous Class:** Not suitable because `Exercise1` contains a substantial amount of logic and should not be defined in-line.
      + **Function Literals:** Not suitable because function literals are meant for single methods or short logic, not for entire classes.
      + **Interfaces:** Not suitable because `Exercise1` needs to implement actual logic, not just define a contract.
      + **Enum:** Not suitable because `Exercise1` is not representing a fixed set of constants.
      + **Record:** Not suitable because `Exercise1` is not a data carrier class; it has behavior and logic.

### 2. Class constructs in `TestZipper`:
   * **Basic class:** `TestZipper`.
   * **Why Chosen:**
      + **Concrete Class:** `TestZipper` provides specific implementations for the abstract methods defined in the `Zipper` class.
   * **Features Used:**
      + **Inheritance:** Inherits from the `Zipper` abstract class and provides concrete implementations for abstract methods.
   * **Why Not Others:**
      + **Static Inner Class / Nested Class:** Not suitable because `TestZipper` needs to be instantiated as an individual class and extend `Zipper`.
      + **Anonymous Class:** Not suitable for the whole `TestZipper` because it needs to be instantiated and managed separately.
      + **Function Literals:** Not suitable because function literals are meant for single methods or short logic.
      + **Interfaces:** Not suitable because `TestZipper` needs to inherit functionality from `Zipper` and provide specific implementations.
      + **Enum:** Not suitable because `TestZipper` is not representing a fixed set of constants.
      + **Record:** Not suitable because `TestZipper` has behavior and logic, not just data.

   * **Anonymous Class:** In the `TestZipper` class, an anonymous class is used to provide the implementation of the `Handler` class.
   * **Why Chosen:**
      + **Features:** Allows for defining a one-time use class that provides specific behavior for the handle method.
      + **Flexibility:** Can override methods and access final variables of the enclosing scope.
   * **Why Not Others:**
      + **Concrete Class:** Overkill for a one-time use class; anonymous classes are more concise.
      + **Static Nested Class / Inner Class:** Not suitable because they require separate definitions and are not as concise for one-time use.
      + **Function Literals (Lambdas):** Not suitable here because lambdas cannot directly define methods (like handle) that contain multiple lines of logic.

   * **Function literals:** `s -> !s.isBlank()` - It represents a concise way to define an anonymous function.
   * **Why Chosen:**
      + **Conciseness:** Lambdas provide a concise way to express simple operations such as filtering and mapping.
      + **Readability:** Makes the code more readable by reducing boilerplate code.
   * **Why Not Others:**
      + **Anonymous Class:** More verbose for simple operations like filtering or mapping in streams.
      + **Concrete Class / Static Nested Class / Inner Class:** Overkill for short, simple operations that can be expressed with lambdas.
      + **Function Literals (Lambdas) for Complex Logic:** Not suitable for defining methods with complex logic or multiple statements.

### 3. Class constructs in `Zipper`:
   * **Basic class:** `Zipper`.
   * **Why Chosen:**
      + **Abstract Class:** `Zipper` is designed to be a base class that provides a framework for unzipping files and handling the extracted files. It contains abstract methods that must be implemented by subclasses.
   * **Features Used:**
      + **Abstract Methods:** `createHandler` is an abstract method that must be implemented by subclasses to provide specific handling logic for files.
      + **Protected Fields:** `tempDirectory` is a protected field that is accessible to subclasses.
      + **AutoCloseable:** Implements the `AutoCloseable` interface to ensure resources are properly closed.
   * **Why Not Others:**
      + **Concrete Class:** Not suitable because `Zipper` is meant to be a base class that provides a structure for subclasses.
      + **Static Inner Class / Nested Class:** Not suitable because `Zipper` is a fundamental component designed to be extended and instantiated separately.
      + **Anonymous Class:** Not suitable because `Zipper` needs to define and share substantial functionality.
      + **Function Literals:** Not suitable because they are meant for single methods, not comprehensive class structures.
      + **Interfaces:** Not suitable because `Zipper` provides concrete methods and fields that share common functionality among subclasses.
      + **Enum:** Not suitable because `Zipper` is not representing a fixed set of constants.
      + **Record:** Not suitable because `Zipper` has behavior and logic, not just data.

   * **Static inner class:** `Handler`.
   * **Why Chosen:**
      + **Logical Grouping:** `Handler` is logically related to `Zipper` and is meant to handle files extracted by `Zipper`.
      + **No Access to Outer Class's Instance Variables:** `Handler` does not need direct access to `Zipper`'s instance variables. Thus, it can be static.
   * **Why not others:**
      + **Top-level Class:** Not suitable because `Handler` is conceptually and functionally tied to `Zipper`.
      + **Anonymous Class:** Not suitable for `Handler` itself because it is intended to be extended and used within `Zipper`.
      + **Function Literals (Lambdas):** Not suitable because they are meant for single methods or short operations, not for defining comprehensive class structures.
      + **Interfaces:** Not suitable because `Handler` needs to contain fields and partially implemented methods.
      + **Enum:** Not suitable because `Handler` is not representing a fixed set of constants.
      + **Record:** Not suitable because `Handler` has behavior and logic, not just data.

## c) Answer:
- The `close()` method is used by the `Zipper` to implement the interface `java.lang.AutoCloseable`. The `TestZipper` inherits the `close()` method from `Zipper` and extends `Zipper`. Therefore, `TestZipper` also implements `java.lang.AutoCloseable`. The directory and its contents are erased upon calling the `close()` method.
- An instance of `TestZipper` is created in the `Exercise1` constructor, and because it implements `java.lang.AutoCloseable`, it is also a resource of `try-with-resources`. At the conclusion of the statement, the `TestZipper::close()` method is called, `Zipper::close()` is called, and the temporary directory is erased. This is done to verify that every resource is closed by the `try-with-resources` statement.


## d) Answer:
- Protected: Ensures `Handler` is accessible within its package and by subclasses of `Zipper`, allowing for extensibility while maintaining encapsulation.
- Abstract: Indicates that `Handler` is a base class that cannot be instantiated directly and must be subclassed to provide specific implementations of the handle method.
- Static: Makes `Handler` a static nested class, meaning it does not need an instance of `Zipper` to be instantiated. This is appropriate because Handler does not require access to the instance-specific members of `Zipper`, improving memory efficiency and organizational clarity.
