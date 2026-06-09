//this class inheritence that Person class. and uses the payable interface.

//for subclasses can reach variables, i defined them protected

public class AcademicStaff extends Person implements Payable {
    protected String title;
    protected double baseSalary;

    // Constructor
    public AcademicStaff(int id, String name, String title, double baseSalary) {
        super(id, name);
        this.title = title;
        this.baseSalary = baseSalary;
    }


    @Override
    public void displayInfo() {
        System.out.println("Academic Staff: " + getId() + " | " + getName() + " | " + title + " | Salary: " + calculateSalary());
    }

    
    //this method came from payabl interface
    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}