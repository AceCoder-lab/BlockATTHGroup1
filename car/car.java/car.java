import java.util.Scanner;

public class car {

    private String company_Name = "";
    private String model_Name = "";
    private int year = 0;
    private double mileAge = 0;

    // getter for company and model
    public String getCMname(String name) {
        if (name.equalsIgnoreCase("company")) {
            return this.company_Name;
        } else if (name.equalsIgnoreCase("model")) {
            return this.model_Name;
        }
        return "You can only get 'company' or 'model'";
    }

    // setter for company and model
    public void setCMname(String company_Name, String model_Name) {
        this.company_Name = company_Name;
        this.model_Name = model_Name;
    }

    // getter for year
    public int getYear() {
        return this.year;
    }

    // setter for year
    public void setYear(int year) {
        this.year = year;
    }

    // getter for mileage
    public double getMileAge() {
        return this.mileAge;
    }

    // setter for mileage
    public void setMileAge(double mileage) {
        this.mileAge = mileage;
    }

    // FEATURE 1: Calculate estimated resale value
    public double estimateResaleValue() {
        double baseValue = 500_000;
        double depreciation = year * 0.05;
        return baseValue * (1 - depreciation);
    }

    // FEATURE 2: Display full car info
    public String getCarInfo() {
        return "Car Information:\n" +
               "Company: " + company_Name +
               "\nModel: " + model_Name +
               "\nYear: " + year +
               "\nMileage: " + mileAge + " km\n";
    }

//  FEATURE 3: Mileage Category
    public String getMileageCategory() {
        if (mileAge < 20000) {
            return "Low Mileage (Excellent condition)";
        } else if (mileAge < 70000) {
            return "Average Usage";
        } else {
            return "High Mileage (Heavily Used)";
        }
    }

    //  FEATURE 4: Car Age
    public int getCarAge() {
        int currentYear = 2025; 
        return currentYear - year;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        car car = new car();

        System.out.print("Enter company name: ");
        String company = input.nextLine();

        System.out.print("Enter model name: ");
        String model = input.nextLine();

        car.setCMname(company, model);

        System.out.print("Enter car year: ");
        int year = input.nextInt();
        car.setYear(year);

        System.out.print("Enter mileage (km): ");
        double mileage = input.nextDouble();
        car.setMileAge(mileage);

        System.out.println("\n--- USER INPUT RESULTS ---");
        System.out.println(car.getCarInfo());

        System.out.println("Estimated Resale Value: ₱" +
                String.format("%,.2f", car.estimateResaleValue()));

        // NEW FEATURE OUTPUTS
        System.out.println("Mileage Category: " + car.getMileageCategory());
        System.out.println("Car Age: " + car.getCarAge() + " years old");

        input.close();
    }
}

