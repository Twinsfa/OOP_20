package Ex1;

import java.util.ArrayList;
import java.util.List;

public class Individual implements Person {
    private String name;
    private String dateOfBirth;
    private String gender;
    boolean married;
    private List<Person> children = new ArrayList<>();

    public Individual(String name, String dateOfBirth, String gender, boolean married) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.married = married;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Married: " + married);
        System.out.println("Children: " + children.size());
    }

    public boolean isMarried() {
        return married;
    }
}
