import java.util.ArrayList;

//T can work with any type of object. T is a generic repo class.
//T ensures us to Type Safety

public class UniversityRepository<T> {

    // "T" is a placeholder. whatever u write here, it will turn to that. 
    private ArrayList<T> items;

    // Constructor
    public UniversityRepository() {
        items = new ArrayList<T>();
    }


    // if you add an item in your repo: add()
    public void add(T item) {
        items.add(item);
    }

    // if you delete an item from repo: remove()
    public void remove(T item) {
        items.remove(item);
    }

    // Iterates through all items from your repo 
    //if objects has their own toString() or displayInfo()  etc. they can call them
    //in this project, this method can use for print all list or items
    public void displayAll() {
        for (T item : items) { //for each loop
            //object is polymorphicly print to screen or toString is calling
            System.out.println(item.toString());
        }
    }

    //for u can use in main method, this  is a helpfull method that returns the list 
    public ArrayList<T> getItems() {
        return items;
    }
}

//after that class you can use  UniversityRepository<T> in main method for putting student:
//UniversityRepository<Student> studentRepo = new UniversityRepository<>();

//you can use UniversityRepository<T> in main method for putting proffessor:
//UniversityRepository<Professor> profRepo = new UniversityRepository<>();