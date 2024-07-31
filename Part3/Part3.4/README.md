a) Answer: 

- In this situation the temperature has value semantics and behaves differently than a double, but it also contains information that it is a temperature. So it should be imutalbe and ``Record`` should be the best choice for this case.
-  There are 3 parts of temperature: Value, Scale, Unit. For instance: `0°C`: value is `0`,scale is `Celsius` and unit is `C`.
-  For the Scale, because it has limited number of scales and the unit is depend on the scale.So, it can use `Enum` with 2 properties inside: `type`and `unit` 
#### Why not other options: 
- `Enum`: In this case, it will have unlimited values can be created. But `Enum` is limited and it suitable for present `Scale` only.
- There is no relation between object so `Static Inner Class`,`Nested class`, `Anonymous class`, `Sealed class` is not a good choice in this case.
- We will have multiple functions so `Function literals and interfaces` is also not a good choice in this case.

### Implementation:

```java
import java.text.DecimalFormat;
import java.util.Objects;

public record Temperature(double value, Scale scale) {

    public enum Scale {
        CELSIUS("Celsius", 'C'), FAHRENHEIT("Fahrenheit", 'F'), KELVIN("Kelvin", 'K');

        final String type;
        final char unit;

        Scale(String type, char unit) {
            this.type = type;
            this.unit = unit;
        }
    }

    public Temperature {
        Objects.requireNonNull(scale, "Missing Scale");
    }

    @Override
    public String toString() {
        return value + "°" + scale.unit;
    }

    public Temperature converter(Scale toScale) {
        double convertedValue = switch (scale) {
            case CELSIUS -> switch (toScale) {
                case CELSIUS -> value;
                case FAHRENHEIT -> value * (9 / 5.0) + 32;
                case KELVIN -> value + 273.15;
            };
            case FAHRENHEIT -> switch (toScale) {
                case CELSIUS -> (value - 32) * 5 / 9.0;
                case FAHRENHEIT -> value;
                case KELVIN -> (value - 32) * 5 / 9.0 + 273.15;
            };
            case KELVIN -> switch (toScale) {
                case CELSIUS -> value - 273.15;
                case FAHRENHEIT -> (value - 273.15) * 9 / 5.0 + 32;
                case KELVIN -> value;
            };
        };
        return new Temperature(convertedValue, toScale);
    }

    public Temperature add(Temperature other) {
        if (other.scale() != this.scale) {
            return converter(other.scale()).add(other);
        }

        double result = this.value + other.value();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedResult = decimalFormat.format(result);
        return new Temperature(Double.parseDouble(formattedResult), other.scale);
    }

    public Temperature minus(Temperature other) {
        if (other.scale() != this.scale) {
            return converter(other.scale()).minus(other);
        }

        double result = this.value - other.value();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedResult = decimalFormat.format(result);
        return new Temperature(Double.parseDouble(formattedResult), other.scale);
    }

    public Temperature multi(Temperature other) {
        if (other.scale() != this.scale) {
            return converter(other.scale()).multi(other);
        }

        double result = this.value * other.value();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedResult = decimalFormat.format(result);
        return new Temperature(Double.parseDouble(formattedResult), other.scale);
    }

    public Temperature divide(Temperature other) {
        if (other.scale() != this.scale) {
            return converter(other.scale()).divide(other);
        }

        double result = this.value / other.value();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedResult = decimalFormat.format(result);
        return new Temperature(Double.parseDouble(formattedResult), other.scale);
    }
}
```

b) Answer:
 I choose the ``Static Innecr Class`` in this case because there is a relation between `Symptom` and `Disease`. So it will need the `Symptom`class inside of `Disease` class.


#### Why not other options: 

- `Enum`: Because the new disease can be discovered every year and since `Enum` can only create imited list so it not suitable.
- `Record`: Since the data of disease can be changed such as the symtom.
-`Function literals and interfaces` : Since we don't need the `Polymorphism` so it's not need to use it in thís case.
- `Nested class`: Although the `Symtom` is a inner class of `Disease` but `Human` can have many `Symtom` with unknown `Disease` or many`Disease` can have the `Symtom`.

### Implementation:

```java
import java.util.List;
import java.util.HashSet;

public class Diseases {
    public String name;
    public List<Symptom> symtoms;

    static class Symptom {
        public String description;

        public Symptom(String description) {
            this.description = description;
        }
    }

    public Diseases(String name, List<Symptom> symptoms) {
        this.name = name;
        this.symtoms = symptoms;
    }
}

class Human {
    public String name;
    public HashSet<Diseases.Symptom> symptoms;

    public Human(String name, List<Diseases.Symptom> symptoms) {
        this.name = name;
        this.symptoms = new HashSet<>(symptoms);
    }

    public boolean mayHaveDisease(Diseases disease) {
        return symptoms.containsAll(disease.symtoms);
    }
}
```

c) Answer:
- We can choose `Record` for returns a list of rows because it is immutable and only used for searching. 

### Why not other options:
- `Enum`: Best suited for defining aggregate values, given constraints such as states or categories with fixed limits. For example, you can use enums to represent student statuses such as REGISTERED, GRADUATED, or DROPPED_OUT, but without having to select detailed data records as in this case.
- `Static Inner Class`, `Nested Class`, `Anonymous class` or `Sealed class`: There is no Inheriting classes either closed (recursively), non-sealed, or final so it not suitable.
- There might be one operation or several operations => Additionally, `Function literals and interfaces` is inappropriate.

### Implementation:

```java
public record StudentRows(String name, String postalAddress, String emailAddress, String degreeProgram,
        int numberOfCredits) {

}
```

d) Answer:

- We use the `Record` in this case because it require to not repeat the filter and reusable the item from question C.

### Why not other options:
- `Static Inner Class`, `Nested Class`, or `Sealed class` are not appropriate because there is no relationship with other objects in this scenario.
In this instance, `Enum` is inappropriate because there are no predefined values (objects).
It is not appropriate to use `Anonymous class`, `Function literals and interfaces`, as we need to repeat the logic every time we wish to filter.

#### Implementation:

```java
public interface Studentfilter {
    boolean filter(StudentRows row);

}

record Studentfiltered() implements Studentfilter {
    @Override
    public boolean filter(StudentRows row) {
        return row.numberOfCredits() >= 280;
    }
}
```

e)Answer:
- Modifications performed by the `Point` class to one of the coordinates (X, Y) also impact the values of the reference objects.
- The only thing that the `RecordPoint` class: can do is read coordinates.
- The `Number` class can read coordinates and change the value of X, Y (number instances), but it can only change the value (integer type) of X, Y (e.g., change the value (integer type) of the {value} property of the `Number` class). When the integer value changes, the values of the reference objects—which are also integers—also change. 