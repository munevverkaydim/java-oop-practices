/**
 * Person sınıfından miras alan ve Comparable arayüzünü uygulayan somut sınıf.
 * Sıralama işlemlerinde GPA kriter alınacağı için Comparable<Student> jeneriği kullanılmıştır.
 */
public class Student extends Person implements Comparable<Student> {
    private String department;
    private double gpa;

    // Constructor
    public Student(int id, String name, String department, double gpa) throws InvalidGPAException {
        super(id, name);
        // İstenen kural: GPA 0'dan küçük veya 4'ten büyükse hata fırlatılır.
        if (gpa < 0 || gpa > 4) {
            throw new InvalidGPAException("Error: GPA must be between 0 and 4.");
        }
        this.department = department;
        this.gpa = gpa;
    }

    // Getter setter 
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }


    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) throws InvalidGPAException {
        if (gpa < 0 || gpa > 4) {
            throw new InvalidGPAException("Error: GPA must be between 0 and 4.");
        }
        this.gpa = gpa;
    }



    // we have to override this methode. 
    @Override
    public void displayInfo() {
        System.out.println("Student: " + getId() + " | " + getName() + " | " + department + " | GPA: " + gpa);
    }

    /**
     * Comparable arayüzünden gelen metot.
     * Öğrencileri GPA'e göre AZALAN (descending) sırada sıralamak için ezilmiştir.
     */
    @Override
    public int compareTo(Student other) {
        // Azalan sıra istendiği için 'other.gpa' ile 'this.gpa' karşılaştırılır.
        if (other.gpa > this.gpa) return 1;
        if (other.gpa < this.gpa) return -1;
        return 0;
    }
}