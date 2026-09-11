// User.java
// The ABSTRACTION. Holds attributes common to all users.
// TODO 3: Added 'abstract' keyword and implemented Exportable
public abstract class User implements Exportable {
    private final int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    // TODO 4: Abstract methods with no body
    public abstract String role();
    public abstract String permissions();

    // TODO 5: Formatted display output calling abstract methods polymorphically
    public void display() {
        System.out.printf("[%d] %-12s %-24s %-8s %s%n", id, name, email, role(), permissions());
    }

    // TODO 6: Base CSV string representation
    @Override
    public String toCsv() {
        return id + "," + name + "," + email + "," + role();
    }
}