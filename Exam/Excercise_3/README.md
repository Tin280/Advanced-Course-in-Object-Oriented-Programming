## a) Answer: 
* As it a database query result, so it should be immutable and Record is suitable in this case.

### Why not other options:

* There are no relationship with other objects so these clase are not suitalbe : `Nested Class`, `Anonymous Class`, `Function literals and interfaces`, `Static Inner Class`.
* An `Enum`  is not suitable for this use case as it is intended for defining fixed sets of constants rather than structured data entities.

## Example implementation :

```java
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public record CustomerEntry(String name, String address, String emailAddress, String purchasedProduct, Date purchaseDate) {
    // Additional methods or validation can be added if needed
}

class CustomerDatabase {
    // Simulated database query method
    public List<CustomerEntry> getCustomersRegisteredIn2024() {
        List<CustomerEntry> customerEntries = new ArrayList<>();

        // Simulate some customer entries
        Calendar calendar = Calendar.getInstance();

        // Add customer entries with Purchase Date in 2024
        calendar.set(2024, Calendar.JANUARY, 15);
        customerEntries.add(new CustomerEntry("Alice", "123 Main St", "alice@example.com", "Product A", calendar.getTime()));

        calendar.set(2024, Calendar.FEBRUARY, 20);
        customerEntries.add(new CustomerEntry("Bob", "456 Elm St", "bob@example.com", "Product B", calendar.getTime()));

        // Add more entries as needed

        return customerEntries;
    }
}

public class Main {
    public static void main(String[] args) {
        CustomerDatabase database = new CustomerDatabase();
        List<CustomerEntry> customerEntries = database.getCustomersRegisteredIn2024();

        // Print customer entries
        for (CustomerEntry entry : customerEntries) {
            System.out.println(entry);
        }
    }
}

```
## b) Answer:

* Because of the require that filter is reusable so `Record` is the best choice.

### Why not other options:

* There are no relationship with other objects so these clase are not suitalbe : `Static Inner Class`, `Nested Class` .
* `Enum` is not suitable because there are no predefined  values.
* `Anonymous class`, `Function literals and interfaces` are not suitable because it need to repeat each time filter is called.

## Example implementation :

```java
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Calendar;

// Define the CustomerEntry record
public record CustomerEntry(String name, String address, String emailAddress, String purchasedProduct, Date purchaseDate) {
    // Additional methods or validation can be added if needed
}

// Class to filter customers based on certain criteria
class CustomerFilter {

    // Method to filter customers based on the provided predicate
    public static List<CustomerEntry> filterCustomers(List<CustomerEntry> customers, Predicate<CustomerEntry> predicate) {
        return customers.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
    }

    // Predicate to filter out customers whose purchase date is before January 2023
    public static Predicate<CustomerEntry> isEligibleForLoyaltyReward() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1);
        Date cutoffDate = calendar.getTime();

        return customer -> customer.purchaseDate().after(cutoffDate);
    }
}

// Main class to demonstrate the functionality
public class Main {
    public static void main(String[] args) {
        // Simulate some customer entries
        List<CustomerEntry> customerEntries = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();

        calendar.set(2024, Calendar.JANUARY, 15);
        customerEntries.add(new CustomerEntry("Alice", "123 Main St", "alice@example.com", "Product A", calendar.getTime()));

        calendar.set(2022, Calendar.DECEMBER, 20);
        customerEntries.add(new CustomerEntry("Bob", "456 Elm St", "bob@example.com", "Product B", calendar.getTime()));

        // Use the filter method to find eligible customers
        List<CustomerEntry> eligibleCustomers = CustomerFilter.filterCustomers(customerEntries, CustomerFilter.isEligibleForLoyaltyReward());

        // Print eligible customers
        for (CustomerEntry entry : eligibleCustomers) {
            System.out.println(entry);
        }
    }
}
```

## c) Answer:

* In this instance, we select the `Record` for the transaction as its value is not fixed and it possesses value semantics.
* We select `Enum` as the transaction type because there aren't many other options (Deposit, Withdrawal, Transfer). Additionally, the transaction is a `Static Inner Class` of `Record`.
* We return a new instance of this `Record` when we execute actions with various transaction types.

### Why not other options:
* `Enum` cannot be used for transactions, even if it may be used for transaction types, as there is no limit to the number of transactions that can be made.
* Since there is no relationship in this situation—neither a parent nor a `child—nested classes`, `sealed classes`, `anonymous classes`, or `static inner classes` are inappropriate.
* `Interfaces and function literals` are likewise inappropriate since there are several operations.

