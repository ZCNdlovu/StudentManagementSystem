package za.ac.cput;

import java.text.NumberFormat;
import java.util.Locale;

public class UndergraduateStudent extends Student{
    private double scholarshipAmount;
    private double totalFees;
    private double amountDue;

    public UndergraduateStudent() {}

    public UndergraduateStudent(Builder builder){
         super(builder.studentId, builder.name, builder.email, builder.department, builder.modules);
        this.scholarshipAmount = builder.scholarshipAmount;
        this.totalFees = builder.totalFees;
        this.amountDue = builder.amountDue;
    }
    @Override
    public double calculateTuition() {
        totalFees = (this.modules * 5) * 500.00;
        amountDue = totalFees - scholarshipAmount;
        return (amountDue > 0) ? amountDue : 0.0;
    }

    @Override
    public String getStudentType() {
        return "Undergraduate";
    }

    @Override
    public void displayStudentDetails() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en", "ZA"));

        super.displayStudentDetails();

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
        private double scholarshipAmount;
        private double totalFees;
        private double amountDue;

      public Builder studentId(String studentId) {this.studentId = studentId;return this;}
      public Builder name(String name) {this.name = name;return this;}
      public Builder email(String email) {this.email = email;return this;}
      public Builder department(String department) {this.department = department;return this;}
        public Builder modules(int modules){this.modules = modules; return this;}
      public Builder scholarshipAmount(double scholarshipAmount){this.scholarshipAmount = scholarshipAmount;return this;}
      public Builder totalFees(double totalFees){this.totalFees = totalFees; return this;}
        public Builder amountDue(double amountDue){this.amountDue = amountDue; return this;}

        public UndergraduateStudent build(){return new UndergraduateStudent(this);}
    }
}
