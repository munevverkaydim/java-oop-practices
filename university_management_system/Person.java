//this is a ABSTRACT class that have all persons same feature. like a up class
public abstract class Person {
    // Encapsulation (private declare)
    private int id;
    private String name;

    // Constructor -> we will call here with super(), in other subclasses
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Polimorfizm : we have to override this method in every subclasses
    public abstract void displayInfo();
}