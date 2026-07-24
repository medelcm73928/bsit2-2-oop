public class Course {
    private final String courseCode;
    private final String title;
    private final int units;
    private final int capacity;
    private int enrolledCount;

    // Constructor
    public Course(String courseCode, String title, int units, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.units = units;
        this.capacity = capacity;
        this.enrolledCount = 0;
    }

      // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getUnits() {
        return units;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    public boolean isFull() {
        return enrolledCount >= capacity;
    }

    public void addOneEnrollee() {
        if (!isFull()) {

            enrolledCount++;
        }
    }
}
