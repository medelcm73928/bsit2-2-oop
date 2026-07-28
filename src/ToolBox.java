// Save as: ToolBox.java

void main() {
    Scanner scanner = new Scanner(System.in);
    int choice = -1;

    while (choice != 0) {
        IO.println("===== JAVA TOOLBOX =====");
        IO.println("1 - Greet me");
        IO.println("2 - Area (square or rectangle)");
        IO.println("3 - Sum of numbers");
        IO.println("4 - Swap demo (pass-by-value)");
        IO.println("5 - Box demo (object mutation)");
        IO.println("0 - Exit");
        IO.print("Choose an option: ");

        try {
            choice = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            IO.println("Invalid input. Please enter a number.\n");
            continue;
        }

        switch (choice) {
            case 1:
                IO.print("Enter your name: ");
                String name = scanner.nextLine();
                IO.println(greet(name));
                break;

            case 2:
                IO.print("Sides (1 = square, 2 = rectangle): ");
                int sides = Integer.parseInt(scanner.nextLine().trim());
                if (sides == 1) {
                    IO.print("Enter side length: ");
                    double side = Double.parseDouble(scanner.nextLine().trim());
                    IO.println("\nArea of square = " + area(side));
                } else if (sides == 2) {
                    IO.print("Enter length: ");
                    double length = Double.parseDouble(scanner.nextLine().trim());
                    IO.print("Enter width: ");
                    double width = Double.parseDouble(scanner.nextLine().trim());
                    IO.println("\nArea of rectangle = " + area(length, width));
                } else {
                    IO.println("Invalid selection.");
                }
                break;

            case 3:
                IO.println("Sum of 4, 8, 15 = " + sum(4, 8, 15));
                IO.println("Sum of 2, 4, 6, 8, 10 = " + sum(2, 4, 6, 8, 10));
                break;

            case 4:
                int x = 5;
                int y = 9;
                IO.println("Before swap: x = " + x + ", y = " + y);
                swap(x, y);
                IO.println("After swap: x = " + x + ", y = " + y + " (unchanged - Java is pass-by-value)");
                break;

            case 5:
                Box box = new Box(10);
                IO.println("Before: box.value = " + box.value);
                addToBox(box);
                IO.println("After: box.value = " + box.value + " (changed - the object is shared)");
                break;

            case 0:
                IO.println("Goodbye!");
                break;

            default:
                IO.println("Invalid option. Please try again.");
                break;
        }

        if (choice != 0) {
            IO.println();
        }
    }

    scanner.close();
}

// Task 1 — greet (parameter + return)
static String greet(String name) {
    return "Hello, " + name + "! Welcome to my Java Toolbox.";
}

// Task 2 — area (overloading)
static double area(double side) { // square
    return side * side;
}

static double area(double length, double width) { // rectangle
    return length * width;
}

// Task 3 — sum (varargs)
static int sum(int... numbers) {
    int total = 0;
    for (int n : numbers) {
        total += n;
    }
    return total;
}

// Task 4 — swap (pass-by-value)
static void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
    IO.println(" (inside swap) a = " + a + ", b = " + b);
}

// Task 5 — addToBox (object mutation)
static void addToBox(Box box1
) {
    box.value = box.value + 25;
}