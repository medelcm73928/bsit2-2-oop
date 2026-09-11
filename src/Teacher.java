// Teacher.java
// A CHILD of User with department field.
public class Teacher extends User {

    // TODO 8(a): Extra field
    private String department;

    // TODO 8(b): Constructor
    public Teacher(int id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }

    // TODO 8(c): Getter
    public String getDepartment() {
        return department;
    }

    // TODO 8
    @Override
    public String role() {
        return "TEACHER";
    }

    // TODO 8)
    @Override
    public String permissions() {
        return "read, update grades";
    }

    // TODO 8
    @Override
    public String toCsv() {
        return super.toCsv() + "," + department;
    }
}