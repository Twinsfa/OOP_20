package Ex1;

import java.util.ArrayList;
import java.util.List;

public class Family implements Person {
    final List<Person> members = new ArrayList<>();

    public Family() {

    }

    public void addMember(Person person) {
        members.add(person);
    }

    public void removeMember(Person person) {
        members.remove(person);
    }

    public void displayInfo() {
        for (Person person : members) {
            person.displayInfo();
        }
    }

    public List<Person> getMembers() {
        return members;
    }
}