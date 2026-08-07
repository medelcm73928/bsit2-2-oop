void main() {
    // ONE list holds Cars AND Motorcycles,
    // because both ARE Vehicles (inheritance).
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int choice = 0;

    while (choice != 5) {
        IO.println();
        IO.println("===== VEHICLE MANAGER =====");
        IO.println("1 - Add Car");
        IO.println("2 - Add Motorcycle");
        IO.println("3 - Remove a Vehicle");
        IO.println("4 - Display All Vehicles");
        IO.println("5 - Exit");
        IO.print("Choose an option: ");
        choice = input.nextInt();
        input.nextLine(); // clear the leftover newline

        if (choice == 1) {
            IO.print("Brand: ");
            String brand = input.nextLine();
            IO.print("Year: ");
            int year = input.nextInt();
            IO.print("Number of doors: ");
            int doors = input.nextInt();

            // TODO 7: make a Car and add it to the list
            vehicles.add(new Car(brand, year, doors));
            IO.println(">> Car added!");

        } else if (choice == 2) {
            IO.print("Brand: ");
            String brand = input.nextLine();
            IO.print("Year: ");
            int year = input.nextInt();
            IO.print("Has sidecar? (true/false): ");
            boolean sidecar = input.nextBoolean();

            // TODO 8: make a Motorcycle and add it to the list
            vehicles.add(new Motorcycle(brand, year, sidecar));
            IO.println(">> Motorcycle added!");

        } else if (choice == 3) {
            IO.print("Enter the number to remove: ");
            int number = input.nextInt();

            // TODO 9: if the number is valid, remove that vehicle
            if (number >= 1 && number <= vehicles.size()) {
                vehicles.remove(number - 1);
                IO.println(">> Removed!");
            } else {
                IO.println(">> Invalid number.");
            }

        } else if (choice == 4) {
            IO.println("--- All Vehicles ---");
            if (vehicles.isEmpty()) {
                IO.println("(none yet)");
            }

            // TODO 10: loop the list and show each vehicle
            for (int i = 0; i < vehicles.size(); i++) {
                IO.print((i + 1) + ". ");
                vehicles.get(i).displayInfo();
            }
        }
    }

    IO.println("Goodbye!");
    input.close();
}