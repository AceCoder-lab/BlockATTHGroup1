import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class car extends JFrame {

    private String company_Name = "";
    private String model_Name = "";
    private int year = 0;
    private double mileAge = 0;

    // GUI components
    private JTextField companyField;
    private JTextField modelField;
    private JTextField yearField;
    private JTextField mileageField;
    private JTextArea outputArea;
    private JButton processButton;
    private JButton clearButton;  // Added clear button

    // Constructor to set up the GUI
    public car() {
        setTitle("Car Information System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Input fields
        add(new JLabel("Company Name:"));
        companyField = new JTextField(20);
        add(companyField);

        add(new JLabel("Model Name:"));
        modelField = new JTextField(20);
        add(modelField);

        add(new JLabel("Year:"));
        yearField = new JTextField(20);
        add(yearField);

        add(new JLabel("Mileage (km):"));
        mileageField = new JTextField(20);
        add(mileageField);

        // Buttons
        processButton = new JButton("Process and Display");
        add(processButton);

        clearButton = new JButton("Clear");  // Added clear button
        add(clearButton);

        // Output area
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea));

        // Action listener for the process button
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get inputs
                    String company = companyField.getText();
                    String model = modelField.getText();
                    int year = Integer.parseInt(yearField.getText());
                    double mileage = Double.parseDouble(mileageField.getText());

                    // Set values
                    setCMname(company, model);
                    setYear(year);
                    setMileAge(mileage);

                    // Display results
                    outputArea.setText("--- USER INPUT RESULTS ---\n" +
                                       getCarInfo() +
                                       "Estimated Resale Value: ₱" +
                                       String.format("%,.2f", estimateResaleValue()));
                } catch (NumberFormatException ex) {
                    outputArea.setText("Error: Please enter valid numbers for year and mileage.");
                }
            }
        });

        // Action listener for the clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all input fields and output area
                companyField.setText("");
                modelField.setText("");
                yearField.setText("");
                mileageField.setText("");
                outputArea.setText("");
            }
        });
    }

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new car().setVisible(true);
        });
    }
}
