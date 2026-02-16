package za.ac.cput;

import java.text.NumberFormat;
import java.util.Locale;

public class UndergraduateStudent extends Student{
    private int creditHours;
    private double scholarshipAmount;

    public UndergraduateStudent() {}

    public UndergraduateStudent(Builder builder){
         super(builder.studentId, builder.name, builder.email, builder.department, builder.modules);
        this.creditHours = builder.creditHours;
        this.scholarshipAmount = builder.scholarshipAmount;
    }
    @Override
    public double calculateTuition() {
        // 1. Calculate Total Credits: (Number of modules * 5 credits each)
        int creditHours = this.modules * 5;

        // 2. Calculate Total Cost: (Total Credits * R100 per credit)
        double totalFees = creditHours * 500.00;

        // 3. Calculate Amount Due: Cost minus Scholarship
        double amountDue = totalFees - scholarshipAmount;

        // Return the amount due if it's positive, otherwise 0.0
        return (amountDue > 0) ? amountDue : 0.0;
    }

    @Override
    public String getStudentType() {
        return "Undergraduate";
    }

    @Override
    public void displayStudentDetails() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en", "ZA"));

        // Basic Info from Student class
        super.displayStudentDetails();

        // Specific Math for the report
        int creditHourst = this.modules * 5;
        double totalFees = creditHours * 500.00;
        double amountDue = calculateTuition();

        System.out.println("Total Modules: " + modules);
        System.out.println("Total Credits Hours (5 per module): " + creditHours);
        System.out.println("Cost per Credit: " + currency.format(500.00));
        System.out.println("Gross Total Fees: " + currency.format(totalFees));
        System.out.println("Scholarship Amount: -" + currency.format(scholarshipAmount));

        System.out.println("--- FINAL BALANCE ---");
        if (amountDue > 0) {
            System.out.println("STATUS: BALANCE OUTSTANDING");
            System.out.println("AMOUNT DUE: " + currency.format(amountDue));
        } else {
            System.out.println("STATUS: FULLY FUNDED");
            System.out.println("Amount Left for Next Year: " + currency.format(scholarshipAmount - totalFees));
        }
        System.out.println("---------------------\n");
    }
    public static class Builder{
        private String studentId;
        private String name;
        private String email;
        private String department;
        private int modules;
        private int creditHours;
        private double scholarshipAmount;

      public Builder studentId(String studentId) {this.studentId = studentId;return this;}
      public Builder name(String name) {this.name = name;return this;}
      public Builder email(String email) {this.email = email;return this;}
      public Builder department(String department) {this.department = department;return this;}
        public Builder modules(int modules){this.modules = modules; return this;}
        public Builder creditHours(int creditHours) {this.creditHours = creditHours;return this;}
      public Builder scholarshipAmount(double scholarshipAmount){this.scholarshipAmount = scholarshipAmount;return this;}

        public UndergraduateStudent build(){return new UndergraduateStudent(this);}
    }
}
