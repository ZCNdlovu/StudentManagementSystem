package za.ac.cput;

public abstract class Student {
    protected String studentId;
    protected String name;
    protected String email;
    protected String department;
    protected int modules;

    public abstract double calculateTuition();
    public abstract  String getStudentType();
    public Student(){}

    public Student(String studentId, String name, String email, String department, int modules) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.department = department;
        this.modules = modules;
    }

     public  void  displayStudentDetails(){
         System.out.println("Student ID: " + studentId);
         System.out.println("Name: " + name);
         System.out.println("Email: " + email);
         System.out.println("Department: " + department);
         System.out.println("Modules: " + modules);
         System.out.println("Type: " + getStudentType());
         System.out.println("Tuition: R" + calculateTuition());
     };
}
