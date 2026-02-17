# SOLID Principles Application
## I. I have used Open/Closed Principle (OCP)
- Means that Software entities like (classes, modules, functions) should be open for extension but closed for modification.
  
**This is how i applied it in my project:**
- In Student class it does not need to be changed every time you add a new category of student.
  
**Closed for Modification:**
-	 As I decided to add a "Part Time Student," I did not rewrite or edit the code inside my Student class, instead i open new Sub classes for Extension: I simply create a new class "Part Time Student," that extends Student and implements its own calculateTuition() logic.

**Example in my Code:**
- When i added the PartTimeStudent class i extended the system without touching the logic in UndergraduateStudent or GraduateStudent.

## II. Liskov Substitution Principle (LSP)
- Means the Objects of a superclass should be replaceable with objects of its subclasses without breaking the application.
  
**This is How it applied in my project:**
- My design ensures that any subclass of Student can be treated as a Student object. This allows me to write code that handles a list of students generically, even though their tuition calculations are completely different.

**Application:**
-	In a Main class, i created a List<Student>. Whether i added an UndergraduateStudent, GraduateStudent and PartTimeStudent to that list, calling calculateTuition() method will always work and return a valid double.
-	The program doesn't "break" because the subclass fulfills the promise made by the parent class.
  
**Example in my Code:**
- The UndergraduateStudent, GraduateStudent and PartTimeStudent they honour the contract of the calculateTuition() method, even though they using different tuitions.

## III. Single Responsibility Principle (SRP)
- Means A class should have one, and only one, reason to change.

**Application:**
- The Student class and its subclasses are responsible solely for managing student data and financial calculations.

**Example in my Code:**
- That how the calculateTuition() method only handles the math, while the displayStudentDetails() method handles the output formatting. By separating the logic of "calculating" from "displaying," you ensure that a change in university fee structures doesn't break the code that prints the report.

#  Inheritance ("Is-a" Relationship)
- I created a generalization/specialization hierarchy where the Student class is the general concept, and the others are specific types.
- **Code Evidence:** I used the extends keyword in all my subclasses.
  - UndergraduateStudent is a Student.
  - GraduateStudent is a Student.
  - PartTimeStudent is a Student`.
- **Why it's "Strong":** It is a strong "is-a" relationship because the subclasses inherit all the fields (studentId, name, email) and the behavior (calculateTuition) from the parent. They cannot exist as students without that parent structure.

# Composition ("Has-a" Strong) —  (Implicitly)
- I use a form of composition with a Builder Pattern.
  - **Code Evidence:** The Builder is a static inner class.
  - **The Relationship:** The UndergraduateStudent class "has a" Builder. Because the Builder is an inner class defined inside the Student class, it is tightly coupled
  - **Lifecycle:** In my code, the Builder's purpose is only to create the Student. Once .build() is called, the Builder's job is done. This strong association is part of the object's creation lifecycle.
  
**Decoupling** Changes in GraduateStudent math won't affect UndergraduateStudent and PartTimeStudent.

**Scalability:** I can add more different student types easily.

**Robustness:** My displayStudentDetails() method in the parent class works for all students because they all implement the required abstract methods.

