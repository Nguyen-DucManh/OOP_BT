package Composite;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private String gender;
    private List<Person> children;
    public Person couple;

    /**
     * javadoc.
     */
    public Person(String name, String birthDate, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.couple = null;
    }

    /**
     * javadoc.
     */
    public void addChild(Person child) {
        children.add(child);
    }

    /**
     * javadoc.
     */
    public void marry(Person person) {
        this.couple = person;
        person.couple = this;
    }

    /**
     * javadoc.
     */
    public List<Person> getChildren() {
        return children;
    }

    /**
     * javadoc.
     */
    public boolean married() {
        return couple != null;
    }

    /**
     * javadoc.
     */
    public String toString() {
        return "Person: [Name: " + name + ", Birth Date: " + birthDate + ", Gender: " + gender + "]";
    }
}

