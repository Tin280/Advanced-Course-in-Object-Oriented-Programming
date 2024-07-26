## a) What form of inheritance is involved in the following case? Background theory: inheritance and polymorphism.
``` java
abstract class CommandLineApp {
    String ask(String prompt) {
        System.out.print(prompt + ": ");
        return new java.util.Scanner(System.in).next();
    }
}

class LoginScreen extends CommandLineApp {
    void lock() {
        while(true) {
            var id = ask("Username");
            var pw = ask("Passoword");

            if (id.equals("root") && pw.equals("root"))
                return;

            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {}
        }
    }
}
```

### Answer: This form is ``Implementation Inheritance``

## b) Comment on and evaluate the following code. Why does it work / not work? What are the benefits and drawbacks associated with it? Background theory and context of the task: inheritance and polymorphism.

```java
interface NaturalResource {
    // How much of the natural resources are left?
    // @.pre true
    // @.post RESULT == (amount let)
    float amountLeft();

    // Spend x percent
    // @.pre amount >= 0
    // @.post amountLeft() == amount + OLD(amountLeft())
    void spend(float amount);
}

class Coal implements NaturalResource {
    private float left;

    Coal(float amount) {
        left = amount;
    }

    @Override
    public float amountLeft() {
        return left;
    }

    @Override
    public void spend(float amount) {
        left -= amount;
    }
}

class Hydroelectric implements NaturalResource {
    private float left = 100;

    @Override
    public float amountLeft() {
        return left;
    }

    // @.pre cant be called
    // @.post throws Exception
    private void spend(float amount) throws Exception {
        throw new Exception("Renewable is limitless!");
    }
}
```

### Answer: 

* The code do not work because 
The expected post condition: `amountLeft() == amount + OLD(amountLeft())`.
But in `Coal` class, the actual result: `amountLeft() == OLD(amountLeft()) - amount`.


**Code Evaluation**

```
Interface `NaturalResource`
The interface NaturalResource defines two methods:

float amountLeft(): This method is supposed to return the amount of natural resource left.
void spend(float amount): This method is supposed to spend a given amount of the resource.
Class Coal
The Coal class implements the NaturalResource interface and provides concrete implementations for the methods:

float amountLeft(): Returns the amount of coal left.
void spend(float amount): Reduces the amount of coal left by the specified amount.
Class Hydroelectric
The Hydroelectric class also implements the NaturalResource interface but has a distinct approach:

float amountLeft(): Returns a constant value representing the hydroelectric power resource.
private void spend(float amount) throws Exception: This method is marked as private and throws an exception if called,

```
**Benefits**

```
Abstraction: The NaturalResource interface provides a clear abstraction for different types of natural resources, defining essential methods that all resources should have.

Encapsulation: Both Coal and Hydroelectric encapsulate their specific behaviors and data, adhering to the principle of encapsulation.

Polymorphism: By implementing the NaturalResource interface, both classes can be used polymorphically, allowing the same code to work with different types of natural resources.
```

**Drawbacks and Issues**


``Interface Contract Violation:``

* The spend method in the Hydroelectric class is private, which violates the interface contract. Interfaces require that all implemented methods must be public. This will cause a compile-time error since Hydroelectric does not properly implement the NaturalResource interface.

* The spend method in Hydroelectric also throws an exception, which is not specified in the interface contract. This can lead to unexpected behavior and violates the principle of substitutability, where any implementation of the interface should be usable interchangeably.




``Handling of Hydroelectric Resources:``

* The Hydroelectric class should provide a meaningful implementation of the spend method rather than making it private and throwing an exception. If the intention is to indicate that hydroelectric resources are limitless, it should be clearly documented and handled appropriately in the method implementation.


## c) Comment on and evaluate the following code. Why does it work / not work? What are the benefits and drawbacks associated with it? Background theory and context of the task: inheritance and polymorphism.
``` java
class RandomGenerator {
    Object generate() {
        var random = new java.util.Random();
        return switch (random.nextInt(4)) {
            case 1 -> 1;
            case 2 -> 2;
            case 3 -> "three";
            default -> new Object();
        };
    }
}

class RandomIntegerGenerator extends RandomGenerator {
    @Override
    Integer generate() {
        return new java.util.Random().nextInt(64);
    }
}
```

### Answer: 
It work because `Integer` is a subclass of `Object`.

**Benefit**

* Polymorphism: By using the RandomGenerator superclass, we can write code that works with any subclass of RandomGenerator. This is beneficial for flexibility and extensibility.

* Inheritance: The subclass RandomIntegerGenerator can reuse the structure of RandomGenerator and provide a specific implementation for generating integers.

**Drawbacks**

* Mixing return types (integers, strings, and objects) in RandomGenerator can be confusing and makes it hard to understand what the method is supposed to do. It violates the single responsibility principle.
