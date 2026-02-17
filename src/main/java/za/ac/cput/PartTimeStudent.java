package za.ac.cput;

import java.text.NumberFormat;
import java.util.Locale;

public class PartTimeStudent extends Student {
    private double employerSponsorship;
    private double totalFees;
    private double balance;
    private double totalCost;
    private double amountDue;
    private final double FEE_PER_MODULE = 2500.00; // Flat rate for part-time
    private final double TECH_FEE = 1500.00;      // Annual distance learning fee

    public PartTimeStudent() {
    }

    public PartTimeStudent(Builder builder) {
        super(builder.studentId, builder.name, builder.email, builder.department, builder.modules);
        this.employerSponsorship = builder.employerSponsorship;
        this.totalFees = builder.totalFees;
        this.balance = builder.balance;
        this.totalCost = builder.totalCost;
        this.amountDue = builder.amountDue;
    }

    @Override
    public double calculateTuition() {
        // Calculation Logic: (Modules * Flat Rate) + Tech Fee - Sponsorship
        totalFees = (modules * FEE_PER_MODULE) + TECH_FEE;
        balance = totalFees - employerSponsorship;

        return (balance > 0) ? balance : 0.0;
    }

    @Override
    public String getStudentType() {
        return "Part-Time Student";
    }

    @Override
    public void displayStudentDetails() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en", "ZA"));

        super.displayStudentDetails();

        totalCost = (modules * FEE_PER_MODULE) + TECH_FEE;
        amountDue = calculateTuition();

        System.out.println("--- Part-Time Financial Breakdown ---");
        System.out.println("Modules: " + modules + " (at " + currency.format(FEE_PER_MODULE) + " each)");
        System.out.println("Annual Tech Fee:    " + currency.format(TECH_FEE));
        System.out.println("Total Gross Cost:   " + currency.format(totalCost));
        System.out.println("Employer Sponsort: -" + currency.format(employerSponsorship));

        if (amountDue > 0) {
            System.out.println("FINAL AMOUNT DUE:   " + currency.format(amountDue));
        } else {
            System.out.println("STATUS: FULLY SPONSORED");
        }
        System.out.println("-------------------------------------\n");
    }

    // Builder Class
    public static class Builder {
        private String studentId;
        private String name;
        private String email;
        private String department;
        private int modules;
        private double employerSponsorship;
        private double totalFees;
        private double balance;
        private double totalCost;
        private double amountDue;

        public Builder studentId(String id) {
            this.studentId = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Builder modules(int modules) {
            this.modules = modules;
            return this;
        }

        public Builder employerSponsorship(double sponsorship) {
            this.employerSponsorship = sponsorship;
            return this;
        }

        public Builder totalFees(double totalFees) {
            this.totalFees = totalFees;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder totalCost(double totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Builder amountDue(double amountDue) {
            this.amountDue = amountDue;
            return this;
        }

        public PartTimeStudent build() {
            return new PartTimeStudent(this);
        }
    }
}