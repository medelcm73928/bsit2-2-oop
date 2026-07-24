static Scanner sc = new Scanner(System.in);

void main() {

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    HashMap<String, ArrayList<String>> enrollments = new HashMap<>();

    String[] validPrograms = {"BSIT", "BSCS"};

    int choice = -1;
    while (choice != 0) {
        printMenu();
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            choice = -1;
        }

        switch (choice) {

            case 1: //Register Students

                IO.print("Student ID: ");
                String id = sc.nextLine();

                IO.print("Full Name: ");
                String name = sc.nextLine();

                IO.print("Program (BSIT/BSCS): ");
                String program = sc.nextLine().toUpperCase();

                boolean valid = false;
                for (String p : validPrograms) {
                    if (p.equals(program)) {
                        valid = true;
                        break;
                    }
                }

                if (!valid) {
                    IO.println("Invalid Program.");
                    break;
                }

                IO.print("Year Level: ");
                int year = Integer.parseInt(sc.nextLine());

                if (year < 1 || year > 4) {
                    IO.println("Year level must be 1-4.");
                    break;
                }

                students.add(new Student(id, name, program, year));

                IO.println("[OK] Student registered successfully!");
                break;

            case 2: // ADD COURSE

                IO.print("Course Code: ");
                String code = sc.nextLine();

                IO.print("Title: ");
                String title = sc.nextLine();

                IO.print("Units: ");
                int units = Integer.parseInt(sc.nextLine());

                IO.print("Capacity: ");
                int cap = Integer.parseInt(sc.nextLine());

                courses.add(new Course(code, title, units, cap));

                IO.println("[OK] Course added.");
                break;

            case 3: // ENROLLMENT STUDENTS

                IO.print("Student ID: ");
                String sid = sc.nextLine();

                Student student = findStudent(students, sid);

                if (student == null) {
                    IO.println("[ERROR] Student not found.");
                    break;
                }

                IO.print("Course Code: ");
                String ccode = sc.nextLine();

                Course course = findCourse(courses, ccode);

                if (course == null) {
                    IO.println("[ERROR] Course not found.");
                    break;
                }

                if (course.isFull()) {
                    IO.println("[ERROR] Course is full.");
                    break;
                }

                enrollments.putIfAbsent(sid, new ArrayList<>());

                if (enrollments.get(sid).contains(ccode)) {
                    IO.println("[ERROR] Student is already enrolled.");
                    break;
                }

                enrollments.get(sid).add(ccode);
                course.addOneEnrollee();

                IO.println("[OK] " + student.getFullName()
                        + " enrolled in " + course.getCourseCode()
                        + " (" + course.getTitle() + ")");
                break;

            case 4: // ALL STUDENTS

                if (students.isEmpty()) {
                    IO.println("No students yet.");
                } else {
                    for (Student s : students) {
                        IO.println(s.describe());
                    }
                }

                break;

            case 5: // ALL COURSES

                if (courses.isEmpty()) {
                    IO.println("No courses yet.");
                } else {
                    for (Course c : courses) {
                        IO.println(
                                c.getCourseCode() + " | "
                                        + c.getTitle() + " | "
                                        + c.getUnits() + " units | "
                                        + c.getEnrolledCount() + "/"
                                        + c.getCapacity());
                    }
                }

                break;

            case 6: // STUDENT LOAD

                IO.print("Student ID: ");
                String loadId = sc.nextLine();

                Student st = findStudent(students, loadId);

                if (st == null) {
                    IO.println("Student not found.");
                    break;
                }

                IO.println(st.getFullName());

                int total = 0;

                ArrayList<String> list = enrollments.get(loadId);

                if (list == null || list.isEmpty()) {
                    IO.println("No enrolled courses.");
                } else {

                    for (String courseCode : list) {

                        Course c = findCourse(courses, courseCode);

                        if (c != null) {
                            IO.println(c.getCourseCode()
                                    + " - "
                                    + c.getTitle()
                                    + " ("
                                    + c.getUnits()
                                    + " units)");

                            total += c.getUnits();
                        }
                    }

                    IO.println("----------------------");
                    IO.println("Total Units: " + total);
                }

                break;

            case 0:
                break;

            default:
                IO.println("Invalid choice.");
        }
    }

    sc.close();
}

static void printMenu() {
    IO.println("\n========================================");
    IO.println("LICEO ENROLLMENT SYSTEM (CLI)");
    IO.println("========================================");
    IO.println("[1] Register Student");
    IO.println("[2] Add Course Offering");
    IO.println("[3] Enroll Student to Course");
    IO.println("[4] View All Students");
    IO.println("[5] View All Courses");
    IO.println("[6] View Student Load");
    IO.println("[0] Exit");
    IO.print("Enter choice: ");
}

static Student findStudent(ArrayList<Student> students, String id) {
    for (Student s : students) {
        if (s.getStudentId().equals(id)) {
            return s;
        }
    }
    return null;
}

static Course findCourse(ArrayList<Course> courses, String code) {
    for (Course c : courses) {
        if (c.getCourseCode().equals(code)) {
            return c;
        }
    }
    return null;
}