# SOLID Principles Application
I. Single Responsibility Principle (SRP)
A class should have one, and only one, reason to change.

The Student class and its subclasses are responsible solely for managing student data and financial calculations.

Notice how the calculateTuition() method only handles the math, while the displayStudentDetails() method handles the output formatting. By separating the logic of "calculating" from "displaying," you ensure that a change in university fee structures doesn't break the code that prints the report.

II. Liskov Substitution Principle (LSP)
Objects of a superclass should be replaceable with objects of its subclasses without breaking the application.

My design uses the Student abstract class as a contract. In a Main class, you can create a List<Student> and add both UndergraduateStudent and GraduateStudent objects to it.

Because both subclasses implement calculateTuition(), you can call s.calculateTuition() on any Student object without knowing its specific type. The program will behave correctly regardless of which subclass is currently being processed.

# Builder Design Pattern Implementation
The Builder Pattern is used to create complex objects step-by-step. It is especially useful here because students have many attributes (ID, Name, Email, etc.), and not all might be required at once.
