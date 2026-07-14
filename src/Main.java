import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Welcome to the CIT Grade Tracker Application ===");

        while (running) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Class Average");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name (one word): ");
                    String name = sc.next();
                    System.out.print("Enter grade: ");
                    double grade = sc.nextDouble();

                    manager.addStudent(name, grade);
                    System.out.println("Student successfully recorded!");
                    break;

                case 2:
                    if (manager.isEmpty()) {
                        System.out.println("The roster is currently empty.");
                    } else {
                        System.out.println("\n--- Current Class Roster ---");
                        for (Student s : manager.getRoster()) {
                            System.out.printf("%s - %.1f (%s)%n", s.getName(), s.getGrade(), manager.letterFor(s.getGrade()));
                        }
                    }
                    break;

                case 3:
                    if (manager.isEmpty()) {
                        System.out.println("Cannot calculate average. The roster contains 0 students.");
                    } else {
                        System.out.printf("Class Average: %.2f%n", manager.calculateAverage());
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Happy Coding!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid entry. Please select an option from 1 to 4.");
            }
        }
        sc.close();
    }
}