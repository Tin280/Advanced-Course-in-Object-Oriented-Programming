# Abstract Functional Model of the Bus Ticket System

## 1. Ticket Class (Abstract)

**Responsibilities**:
- Represent general characteristics of a ticket.
- Provide a method to check if the ticket is still valid.
- Provide a method to get the price of the ticket.
- Provide a method to calculate the remaining validity time.

**Member Variables**:
- `protected long purchaseTime`: Stores the time when the ticket was purchased (in milliseconds).
- `protected long validityDuration`: Stores the duration for which the ticket is valid (in milliseconds).

**Methods**:
- `public Ticket(long validityDuration)`: Constructor to initialize purchaseTime and validityDuration.
- `public boolean isValid()`: Checks if the ticket is still valid based on the current time.
- `public long getRemainingTime()`: Calculates and returns the remaining validity time in milliseconds.
- `public abstract double getPrice()`: Abstract method to get the price of the ticket.

**Justification**: This class provides the common attributes and behaviors of all ticket types, ensuring that subclasses implement specific details like pricing.

## 2. SingleTicket Class (Concrete)

**Responsibilities**:
- Represent a single-use ticket.

**Member Variables**:
- `private static final double PRICE`: Price of the single ticket.
- `private static final long VALIDITY_DURATION`: Validity duration of the single ticket (in milliseconds).

**Methods**:
- `public SingleTicket()`: Constructor to initialize the validity duration.
- `public double getPrice()`: Returns the price of the single ticket.

**Justification**: This class encapsulates the specific details of a single-use ticket, including its price and validity duration.

## 3. DayTicket Class (Concrete)

**Responsibilities**:
- Represent a day ticket.

**Member Variables**:
- `private static final double PRICE`: Price of the day ticket.
- `private static final long VALIDITY_DURATION`: Validity duration of the day ticket (in milliseconds).

**Methods**:
- `public DayTicket()`: Constructor to initialize the validity duration.
- `public double getPrice()`: Returns the price of the day ticket.

**Justification**: This class encapsulates the specific details of a day ticket, including its price and validity duration.

## 4. MonthlyTicket Class (Concrete)

**Responsibilities**:
- Represent a monthly ticket.

**Member Variables**:
- `private static final double PRICE`: Price of the monthly ticket.
- `private static final long VALIDITY_DURATION`: Validity duration of the monthly ticket (in milliseconds).

**Methods**:
- `public MonthlyTicket()`: Constructor to initialize the validity duration.
- `public double getPrice()`: Returns the price of the monthly ticket.

**Justification**: This class encapsulates the specific details of a monthly ticket, including its price and validity duration.

## 5. Card Class

**Responsibilities**:
- Manage the balance of a user's card.
- Manage the tickets purchased by the user.
- Allow adding tickets if the balance is sufficient.
- Check if there are any valid tickets.

**Member Variables**:
- `private double balance`: Stores the current balance of the card.
- `private List<Ticket> tickets`: Stores the list of tickets purchased by the cardholder.

**Methods**:
- `public Card(double initialBalance)`: Constructor to initialize the balance and tickets list.
- `public boolean addTicket(Ticket ticket)`: Adds a ticket to the card if the balance is sufficient and deducts the price from the balance.
- `public Ticket getValidTicket()`: Returns the first valid ticket found in the tickets list.
- `public double getBalance()`: Returns the current balance of the card.

**Justification**: This class encapsulates the management of the card's balance and tickets, ensuring that ticket purchases are only allowed if there are sufficient funds.

## 6. BusTicketSystem Class

**Responsibilities**:
- Provide a user interface to interact with the card system.
- Handle user input to buy tickets, check balance, and exit the system.

**Methods**:
- `public static void main(String[] args)`: Main method to run the system, providing options to the user and handling their input.
- `private static String formatTime(long millis)`: Helper method to format milliseconds into hours, minutes, and seconds.

**Justification**: This class serves as the entry point for the system, handling user interactions and coordinating the operations of other classes.

## Communication and Data Types

- **Ticket Classes** communicate with the **Card Class** by being added to the card's tickets list when purchased.
- The **Card Class** checks the validity of tickets and manages the balance, ensuring encapsulation by keeping these operations internal.
- **BusTicketSystem Class** interacts with the **Card Class** to perform actions based on user input, ensuring user interactions are processed and relevant feedback is provided.

## Encapsulation and Invariants

- Each ticket type encapsulates its price and validity duration, ensuring these values remain constant and cannot be altered.
- The **Card Class** encapsulates the balance and tickets list, only allowing modifications through controlled methods (`addTicket` and `getValidTicket`).
- The **BusTicketSystem Class** provides a clear interface for user interactions, ensuring the internal workings of the system remain hidden from the user.
