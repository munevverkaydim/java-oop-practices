//this class came from(extends) academicStaff class
//and academic class extends from person
// java dont let you extend twice. we came here with two stepp.

public class Professor extends AcademicStaff {
    private int publishedPapers; // it is special to Professor

    // Constructor
    public Professor(int id, String name, String title, double baseSalary, int publishedPapers) {
        super(id, name, title, baseSalary);
        this.publishedPapers = publishedPapers;
    }



    //Polimorfizm (i override here)---> Formul: baseSalary + (publishedPapers * 1000)
    
    @Override
    public double calculateSalary() {
        return baseSalary + (publishedPapers * 1000);
    }

    @Override
    public void displayInfo() {
        System.out.println("Professor: " + getId() + " | " + getName() + " | " + title + " | Salary: " + calculateSalary());
    }
}