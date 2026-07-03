import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Parallel arrays to store up to 10 students
        int maxStudents = 10;
        int[] studentIDs = new int[maxStudents];
        String[] fullNames = new String[maxStudents];
        int[] ages = new int[maxStudents];
        String[] courses = new String[maxStudents];
        double[] grades = new double[maxStudents];
        boolean[] enrolledStatus = new boolean[maxStudents];

        int studentCount = 0; // Tracks how many students are added
        int choice = 0;

        // Loop for the main menu
        while (choice != 5) {
            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("[1] Add Student");
            System.out.println("[2] View All Students");
            System.out.println("[3] Search Student by ID");
            System.out.println("[4] View Statistics");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Option 1: Add Student
                    if (studentCount >= maxStudents) {
                        System.out.println("Error: Student list is full!");
                    } else {
                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Clear scanner buffer

                        System.out.print("Enter Full Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Course: ");
                        String course = scanner.nextLine();

                        System.out.print("Enter Grade: ");
                        double grade = scanner.nextDouble();

                        System.out.print("Is enrolled? (true/false): ");
                        boolean status = scanner.nextBoolean();

                        // Simple Input Validation
                        if (age <= 0 || grade < 0 || grade > 100) {
                            System.out.println("Invalid input! Age must be positive and grade must be 0-100. Student not added.");
                        } else {
                            // Store data in arrays
                            studentIDs[studentCount] = id;
                            fullNames[studentCount] = name;
                            ages[studentCount] = age;
                            courses[studentCount] = course;
                            grades[studentCount] = grade;
                            enrolledStatus[studentCount] = status;

                            studentCount++;
                            System.out.println("Student added successfully!");
                        }
                    }
                    break;

                case 2:
                    // Option 2: View All Students
                    if (studentCount == 0) {
                        System.out.println("No student records found.");
                    } else {
                        System.out.println("\n--- Student List ---");
                        for (int i = 0; i < studentCount; i++) {
                            // Find standing based on grade
                            String standing;
                            if (grades[i] >= 90) {
                                standing = "Dean's Lister";
                            } else if (grades[i] >= 75) {
                                standing = "Passed";
                            } else {
                                standing = "Failed";
                            }

                            System.out.println("ID: " + studentIDs[i] + " | Name: " + fullNames[i] +
                                    " | Age: " + ages[i] + " | Course: " + courses[i] +
                                    " | Grade: " + grades[i] + " | Status: " + (enrolledStatus[i] ? "Enrolled" : "Not Enrolled") +
                                    " | Standing: " + standing);
                        }
                    }
                    break;

                case 3:
                    // Option 3: Search Student by ID
                    if (studentCount == 0) {
                        System.out.println("No records to search.");
                    } else {
                        System.out.print("Enter Student ID to search: ");
                        int searchID = scanner.nextInt();
                        boolean found = false;

                        for (int i = 0; i < studentCount; i++) {
                            if (studentIDs[i] == searchID) {
                                System.out.println("Student Found: " + fullNames[i] + " (" + courses[i] + "), Grade: " + grades[i]);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Student ID not found.");
                        }
                    }
                    break;

                case 4:
                    // Option 4: View Statistics
                    if (studentCount == 0) {
                        System.out.println("No statistics available. Add students first.");
                    } else {
                        double sum = 0;
                        double highestGrade = grades[0];
                        String topStudent = fullNames[0];

                        for (int i = 0; i < studentCount; i++) {
                            sum += grades[i]; // Calculate total for average

                            // Check for top student
                            if (grades[i] > highestGrade) {
                                highestGrade = grades[i];
                                topStudent = fullNames[i];
                            }
                        }

                        double average = sum / studentCount;
                        System.out.println("\n--- Statistics ---");
                        System.out.println("Total Students: " + studentCount);
                        System.out.println("Average Grade: " + average);
                        System.out.println("Top Student: " + topStudent + " (Grade: " + highestGrade + ")");
                    }
                    break;

                case 5:
                    // Option 5: Exit
                    System.out.println("Thank you for using the Student Information System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select from 1 to 5.");
            }
        }

        scanner.close();
    }
}