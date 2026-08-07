public class Car extends Vehicle {

    private final int numberOfDoors;

    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year); // reuse Vehicle's constructor
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car: " + brand + " (" + year + ") - " + numberOfDoors + " doors");
    }
}