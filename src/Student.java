public class Student {
    private final String studentId;
    private final String fullName;
    private final String program;
    private final int yearLevel;

    // Constructor: initialize all fields with 'this'
    public Student(String studentId, String fullName, String program, int yearLevel) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.program = program;
        this.yearLevel = yearLevel;
    }

    // Getters (one shown - add the rest)
    public String getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public String describe() {
        return studentId + " | " + fullName + " | " + program + " | Year " + yearLevel;
    }
}



