import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class UniversityManagementSystem {
    public static void main(String[] args) {
        
        //creating the polymorphic main list
        ArrayList<Person> people = new ArrayList<>();

        // 2. objects created inside try-catch (for InvalidGPAException check)
        try {
            //student examples
            Student s1 = new Student(1001, "Ahmet", "Computer Engineering", 3.85);
            Student s2 = new Student(1002, "Ayse", "Software Engineering", 3.40);
            
            //professsors examples
            Professor p1 = new Professor(2001, "Mehmet", "Prof. Dr.", 25000, 10); // 25000 + 10*1000 = 35000
            Professor p2 = new Professor(2002, "Elif", "Assoc. Prof.", 24000, 8);   // 24000 + 8*1000 = 32000
            
            // research assisan examples
            ResearchAssistant r1 = new ResearchAssistant(3001, "Ali", "Res. Asst.", 20000, 4); // 20000 + 4*500 = 22000
            ResearchAssistant r2 = new ResearchAssistant(3002, "Zeynep", "Res. Asst.", 20000, 3); // 20000 + 3*500 = 21500

            //objects added polimorficly to the list 
            people.add(s1);
            people.add(s2); 
            people.add(p1);
            people.add(p2);
            people.add(r1);
            people.add(r2);

        } catch (InvalidGPAException e) {
            System.out.println(e.getMessage());
        }

        // 1st: all persons in university printed polymorphicly
        System.out.println("=== University Members ===");
        for (Person p : people) {
            // Dynamic Method Dispatch
            // çalışma zamanında hangi displayInfo() metodunun çağrılacağı nesneye göre belirlenir.
            p.displayInfo();
        }
        System.out.println();

        //2nd: by using Instanceof ve Downcasting, salarys print
        System.out.println("=== Academic Staff Salaries ===");
        for (Person p : people) {
            //if the person hwo inside the list is type of AcademicStaff or inheritence this,
            if (p instanceof AcademicStaff) {
                //safely change from upperclass(person) to subclass(AcademicStaff) --> DOWNCASTİNG
                AcademicStaff staff = (AcademicStaff) p;
                System.out.println(staff.getName() + " salary: " + staff.calculateSalary());
            }
        }
        System.out.println();

        // 3rd : students are taken to another list and lining to GPA 
        ArrayList<Student> students = new ArrayList<>();
        for (Person p : people) {
            if (p instanceof Student) {
                students.add((Student) p);
            }
        }

        // Student sınıfında ezdiğimiz Comparable arayüzünün kurallarına göre standart Collections.sort kullanılır.
        Collections.sort(students);

        System.out.println("=== Students Sorted by GPA ===");
        for (Student s : students) {
            System.out.println(s.getName() + " " + s.getGpa());
        }
        System.out.println();

        // === GÖSTERİM 4: Dosya Yazma İşlemleri (students.txt) ===
        // FileWriter ve PrintWriter kullanımı için try-with-resources yapısı tercih edilmiştir (otomatik close sağlar).
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                writer.println("Student ID: " + s.getId() + " | Name: " + s.getName() + " | Dept: " + s.getDepartment() + " | GPA: " + s.getGpa());
            }
            System.out.println("Student information was written to students.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
        System.out.println();

        //5th : InvalidGPAException error control senario
        System.out.println("=== Testing Invalid GPA Handling ===");
        try {
            // we try to create object with invalid GPA (5.0) 
            Student badStudent = new Student(1003, "Veli", "Computer Engineering", 5.0);
        } catch (InvalidGPAException e) {
            // Beklenen hata mesajı burada yakalanır ve ekrana basılır.
            System.out.println(e.getMessage());
        }
    }
}