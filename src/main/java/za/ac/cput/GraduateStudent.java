package za.ac.cput;

import java.text.NumberFormat;
import java.util.Locale;

public class GraduateStudent extends Student{
    private boolean researchAssistant;
    private double stipend;
    private double moduleFees;
    private double foodAllowance;
    private double assistantCost;
    private double totalCosts;
    private double netBalance;


    public GraduateStudent(){}

    public GraduateStudent(Builder builder){
        super(builder.studentId, builder.name, builder.email, builder.department, builder.modules);
        this.researchAssistant = builder.researchAssistant;
        this.stipend = builder.stipend;
        this.moduleFees = builder.moduleFees;
        this.foodAllowance = builder.foodAllowance;
        this.assistantCost = builder.assistantCost;
        this.totalCosts = builder.totalCosts;
        this.netBalance = builder.netBalance;
    }

    @Override
    public double calculateTuition() {

         moduleFees = this.modules * 1000.00;
        foodAllowance = 5000.00 * 12;
        assistantCost = this.researchAssistant ? (1000.00 * 12) : 0.0;
        totalCosts = moduleFees + foodAllowance + assistantCost;
        netBalance = totalCosts - this.stipend;
        return (netBalance > 0) ? netBalance : 0.0;
    }
    @Override
    public  String getStudentType() {
        return  "GraduateStudent ";
    }

    @Override
    public void displayStudentDetails() {
        NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en", "ZA"));
        super.displayStudentDetails();

        double totalCosts = (modules * 1000.0) + (5000.0 * 12) + (researchAssistant ? 12000.0 : 0.0);
        double amountOwed = calculateTuition();
        double remainingStipend = stipend - totalCosts;

        System.out.println("--- ACCOUNT SUMMARY ---");
        System.out.println("Total Costs:      " + currency.format(totalCosts));
        System.out.println("Annual Stipend:   " + currency.format(stipend));

        if (amountOwed > 0) {
            //If Stipend was NOT enough
            System.out.println("STATUS:           INSUFFICIENT FUNDS");
            System.out.println("AMOUNT OWED:      " + currency.format(amountOwed));
        } else {
            // If Stipend covered everything
            System.out.println("STATUS:           FULLY FUNDED");
            System.out.println("Amount Left:  " + currency.format(remainingStipend));
        }
        System.out.println("------------------------\n");
    }

    public static class Builder{
        private String studentId;
        private String name;
        private String email;
        private String department;
        private int modules;
        private boolean researchAssistant;
        private double stipend;
        private double moduleFees;
        private double foodAllowance;
        private double assistantCost;
        private double totalCosts;
        private double netBalance;

 public Builder studentId(String studentId){this.studentId = studentId;return this;}
        public Builder name(String name){this.name = name;return this;}
        public Builder email(String email){this.email = email;return this;}
        public Builder department(String department){this.department = department;return this;}
        public Builder modules(int modules){this.modules = modules; return this;}
        public Builder researchAssistant(boolean researchAssistant){this.researchAssistant = researchAssistant;return this;}
        public Builder stipend(double stipend){this.stipend = stipend;return this;}
        public Builder moduleFees(double moduleFees){this.moduleFees = moduleFees; return this;}
        public Builder foodAllowance(double foodAllowance){this.foodAllowance = foodAllowance; return this;}
        public Builder assistantCost(double assistantCost){this.assistantCost = assistantCost; return this;}
        public Builder totalCosts(double totalCosts){this.totalCosts = totalCosts; return this;}
        public Builder netBalance(double netBalance){this.netBalance = netBalance; return this;}

        public GraduateStudent build(){return new GraduateStudent(this);}
    }
}
