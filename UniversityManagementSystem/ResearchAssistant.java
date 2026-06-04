public class ResearchAssistant extends AcademicStaff {
    private int projects; // special for research assistans

    // Constructor
    public ResearchAssistant(int id, String name, String title, double baseSalary, int projects) {
        super(id, name, title, baseSalary);
        this.projects = projects;
    }

    
    //Polimorfizm--->  Formül: baseSalary + (projects * 500)
    
    @Override
    public double calculateSalary() {
        return baseSalary + (projects * 500);
    }

    
    @Override
    public void displayInfo() {
        System.out.println("Research Assistant: " + getId() + " | " + getName() + " | " + title + " | Salary: " + calculateSalary());
    }
}