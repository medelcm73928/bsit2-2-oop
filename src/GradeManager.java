import java.util.ArrayList;

public class GradeManager {
    private final ArrayList<Student> roster = new ArrayList<>();
    private static final double[] cutoffs = {90.0, 80.0, 70.0, 60.0};
    private static final String[] letters = {"A", "B", "C", "D", "F"};

    public void addStudent(String name, double grade) {
        roster.add(new Student(name, grade));
    }

    public ArrayList<Student> getRoster() {
        return roster;
    }

    public boolean isEmpty() {
        return roster.isEmpty();
    }

    public double calculateAverage() {
        if (roster.isEmpty()) {
            return 0.0;
        }
        double total = 0;
        for (Student s : roster) {
            total += s.getGrade();
        }
        return total / roster.size();
    }

    public String letterFor(double grade) {
        for (int i = 0; i < cutoffs.length; i++) {
            if (grade >= cutoffs[i]) {
                return letters[i];
            }
        }
        return letters[letters.length - 1];
    }
}