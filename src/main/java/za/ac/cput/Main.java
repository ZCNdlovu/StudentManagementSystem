package za.ac.cput;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        GraduateStudent grad = new GraduateStudent.Builder().studentId("2024000")
                .name("Sipho Dlamini").email("dlaminis@gmail.com").department("ICT Multmedia")
                .modules(5).stipend(100000.00)
                .researchAssistant(true)
                .build();

        GraduateStudent grad1 = new GraduateStudent.Builder().studentId("2025000")
                .name("Zinhle Ngcobo").email("ngcoboz@gmail.com").department("ICT Application Development")
                .modules(6).stipend(100000.00).researchAssistant(false)
                .build();

        GraduateStudent grad2 = new GraduateStudent.Builder().studentId("2027000")
                .name("Zama Ndlovu").email("ndlovuz@gmail.com").department("ICT Com Net")
                .modules(5).stipend(4000.00).researchAssistant(false)
                .build();

        UndergraduateStudent under = new UndergraduateStudent.Builder().studentId("2025000")
                .name("Zinhle Ngcobo").email("ngcoboz@gmail.com").department("ICT Application Development")
                .modules(6).creditHours(30).scholarshipAmount(2000)
                .build();

        UndergraduateStudent under2 = new UndergraduateStudent.Builder().studentId("2027000")
                .name("Zama Ndlovu").email("ndlovuz@gmail.com").department("ICT Com Net").modules(7)
                .creditHours(30).scholarshipAmount(100000)
                .build();

        PartTimeStudent partTime = new PartTimeStudent.Builder().studentId("PT-2026-404")
                .name("Thabo Mokoena").email("thabo@gmail.com").department("Engineering")
                .modules(3).employerSponsorship(5000.00)
                .build();

        // Polymorphism by adding all to one list
        List<Student> students = new ArrayList<>();
        students.add(under);
        students.add(under2);
        students.add(grad);
        students.add(grad1);
        students.add(grad2);
        students.add(partTime);

        System.out.println("==================================================\n");

        for (Student s : students) {

            s.displayStudentDetails();
            System.out.println("--------------------------------------------------");
//        grad.displayStudentDetails();
//        grad1.displayStudentDetails();
//        grad2.displayStudentDetails();
//        under.displayStudentDetails();
//        under2.displayStudentDetails();
//        partTime.displayStudentDetails();
        }
    }
}