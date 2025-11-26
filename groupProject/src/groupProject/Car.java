package groupProject;

public class Car {

    private String company = "";
    private String model = "";
    private int year = 0;
    private double mileage = 0;

    // Getters and Setters
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getMileage(double distance) {
        return mileage + distance;
    }
    
 // Dagdag Feature 1: Drive the car
    public void drive(double distance) {
        if (distance > 0) mileage += distance;
    }

    //Dagdag Feature 2: Calculate car age
    public int getCarAge(int currentYear) {
        return currentYear - year;
    }

    public static void main(String[] args) {
        Car car = new Car();

        car.setCompany("Philip");
        car.setModel("p524fd");
        car.setYear(5);

        System.out.println("Company: " + car.getCompany());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Mileage: " + car.getMileage(20)); // default + 20

        car.drive(50); // drive 50 miles
        System.out.println("Updated Mileage: " + car.getMileage(0));
        System.out.println("Car Age: " + car.getCarAge(2025));
    }
}
