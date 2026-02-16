package za.ac.cput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GraduateStudent grad = new GraduateStudent.Builder()
                .studentId("2024000")
                .name("Sipho Dlamini")
                .email("dlaminis@gmail.com")
                .department("ICT Multmedia")
                .modules(5)
                .stipend(100000.00)
                .researchAssistant(true) // This will trigger the R1000 cost
                .build();
        GraduateStudent grad1 = new GraduateStudent.Builder()
                .studentId("2025000")
                .name("Zinhle Ngcobo")
                .email("ngcoboz@gmail.com")
                .department("ICT Application Development")
                .modules(6)
                .stipend(100000.00)
                .researchAssistant(false) // This will trigger the R1000 cost
                .build();
        GraduateStudent grad2 = new GraduateStudent.Builder()
                .studentId("2027000")
                .name("Zama Ndlovu")
                .email("ndlovuz@gmail.com")
                .department("ICT Com Net")
                .modules(5)
                .stipend(4000.00)
                .researchAssistant(false) // This will trigger the R1000 cost
                .build();
        UndergraduateStudent under = new UndergraduateStudent.Builder()
                .studentId("2025000")
                .name("Zinhle Ngcobo")
                .email("ngcoboz@gmail.com")
                .department("ICT Application Development")
                .modules(6)
                .creditHours(30)
                .scholarshipAmount(20000)
                .build();
        UndergraduateStudent under2 = new UndergraduateStudent.Builder()
                .studentId("2027000")
                .name("Zama Ndlovu")
                .email("ndlovuz@gmail.com")
                .department("ICT Com Net")
                .modules(7)
                .creditHours(30)
                .scholarshipAmount(100000)
                .build();
        grad.displayStudentDetails();
        grad1.displayStudentDetails();
        grad2.displayStudentDetails();
        under.displayStudentDetails();
        under2.displayStudentDetails();

    }
}