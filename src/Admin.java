// Admin.java
// A CHILD of User. An Admin IS-A User.
public class Admin extends User {

    // TODO 7
    public Admin(int id, String name, String email) {
        super(id, name, email);
    }

    // TODO 7
    @Override
    public String role() {
        return "ADMIN";
    }

    // TODO 7
    @Override
    public String permissions() {
        return "create, read, update, delete";
    }
}