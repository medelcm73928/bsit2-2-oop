// Student.java
// A CHILD of User with course field.
public class Student extends User {

    // TODO 9(a): Extra field
    private String course;

    // TODO 9(b): Constructor
    public Student(int id, String name, String email, String course) {
        super(id, name, email);
        this.course = course;
    }

    // TODO 9(c): Getter
    public String getCourse() {
        return course;
    }

    // TODO 9(d): Override role()
    @Override
    public String role() {
        return "STUDENT";
    }

    // TODO 9(e): Override permissions()
    @Override
    public String permissions() {
        return "read only";
    }

    // TODO 9(f): Override toCsv() to append course
    @Override
    public String toCsv() {
        return super.toCsv() + "," + course;
    }
}