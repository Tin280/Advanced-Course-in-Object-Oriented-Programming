You have been tasked to create a radio show database system called WappuRadio. This database stores information about radio show hosts and their respective shows. Assume that a host has typical fields such as name, show name, airtime, and genre.

WappuRadio's hosts and administrative staff can make queries in the show host database to search for specific show host records. Additionally, the database supports administrative staff updates to the data. Why is this? For example, there may have been initial errors in the data, or it might be necessary to update a show's airtime, change a host's show, mark a host as inactive, etc.

(In reality, the database would likely be stored on disk and use some type of database engine, but let's assume here that the database is always entirely in the memory of a Java process as simple objects, and the state of the objects is saved back to a file at the end of the day and reloaded into memory at the beginning of the next day. All data processing would thus simply take place with objects in the memory of the Java process.)

What principle of data protection would you choose in the case of the ShowHost type when you want to serve the two different roles mentioned:

A host makes a search query and you want to offer the host a view that only supports reading the show host records.
Administrative staff want to permanently edit the information of a specific host.

## Answer : Encapsulation and Integrity.

Describe the mechanisms you choose and their consequences for class features, class invariant, and usage.

Answer: 


## ShowHost Class Design
### Attributes:
- `name`: String
- `showName`: String
- `airtime`: String
- `genre`: String
- `isActive`: boolean (to mark if the host is currently active or not)

### Methods:
- Getter methods for each attribute (`getName()`, `getShowName()`, `getAirtime()`, `getGenre()`, `isActive()`)
- Setter methods for each attribute (`setName()`, `setShowName()`, `setAirtime()`, `setGenre()`, `setActive()`)

## Role-Based Access Control (RBAC)
We will define two roles: `Host` and `Admin`.
- `Host` can only view the data (read-only access).
- `Admin` can both view and update the data (read-write access).

## Access Control Mechanisms
- Create a base interface or abstract class `User` with common methods for both roles.
- Implement two concrete classes `HostUser` and `AdminUser` that extend the `User` class. These classes will control the access permissions.

## Implementation Sketch

```java
import java.util.List;

class ShowHost {
    private String name;
    private String showName;
    private String airtime;
    private String genre;
    private boolean isActive;

    // Constructor
    public ShowHost(String name, String showName, String airtime, String genre, boolean isActive) {
        this.name = name;
        this.showName = showName;
        this.airtime = airtime;
        this.genre = genre;
        this.isActive = isActive;
    }

    // Getters
    public String getName() { return name; }
    public String getShowName() { return showName; }
    public String getAirtime() { return airtime; }
    public String getGenre() { return genre; }
    public boolean isActive() { return isActive; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setShowName(String showName) { this.showName = showName; }
    public void setAirtime(String airtime) { this.airtime = airtime; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setActive(boolean isActive) { this.isActive = isActive; }
}

// Abstract User class
abstract class User {
    protected List<ShowHost> showHosts;

    public User(List<ShowHost> showHosts) {
        this.showHosts = showHosts;
    }

    public abstract ShowHost searchShowHost(String name);
}

// HostUser class with read-only access
class HostUser extends User {

    public HostUser(List<ShowHost> showHosts) {
        super(showHosts);
    }

    @Override
    public ShowHost searchShowHost(String name) {
        for (ShowHost host : showHosts) {
            if (host.getName().equalsIgnoreCase(name)) {
                return host;
            }
        }
        return null;
    }

    // No setters or mutator methods allowed
}

// AdminUser class with read-write access
class AdminUser extends User {

    public AdminUser(List<ShowHost> showHosts) {
        super(showHosts);
    }

    @Override
    public ShowHost searchShowHost(String name) {
        for (ShowHost host : showHosts) {
            if (host.getName().equalsIgnoreCase(name)) {
                return host;
            }
        }
        return null;
    }

    // Admin can update the ShowHost details
    public void updateShowHost(ShowHost host, String showName, String airtime, String genre, boolean isActive) {
        host.setShowName(showName);
        host.setAirtime(airtime);
        host.setGenre(genre);
        host.setActive(isActive);
    }
}
```
## Consequences for Class Features, Class Invariant, and Usage:

### Class Features:
- The `ShowHost` class encapsulates all the necessary details about a show host.
- The `User` abstract class ensures that both `HostUser` and `AdminUser` have a common method for searching show hosts.

### Class Invariant:
- For `HostUser`, the invariant is that it cannot modify any `ShowHost` attributes. This ensures read-only access.
- For `AdminUser`, the invariant is that it can modify `ShowHost` attributes. This ensures that only admin users can make changes, maintaining data integrity.

### Usage:
- `HostUser` can search and view details but cannot alter any information. This is useful for hosts to check their own or others' show details without the risk of unintentional changes.
- `AdminUser` can search, view, and update details. This is useful for administrative tasks such as correcting errors, updating airtime, changing show details, and managing host activity status.
