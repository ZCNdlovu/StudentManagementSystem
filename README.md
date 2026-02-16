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

# Builder Design Pattern Implementation
- The Builder Pattern is used to create complex objects step-by-step. It is especially useful here because students have many attributes (ID, Name, Email, etc.), and not all might be required at once.

**Decoupling** Changes in GraduateStudent math won't affect UndergraduateStudent and PartTiemStudent.
**Scalability:** You can add 100 different student types easily.
**Robustness:** Your displayStudentDetails() method in the parent class works for all students because they all implement the required abstract methods.

