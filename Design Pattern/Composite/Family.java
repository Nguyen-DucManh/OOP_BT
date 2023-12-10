package Composite;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private Person root;
    private int maxDepth = -1;

    /**
     * javadoc.
     */
    public Family(Person root) {
        this.root = root;
    }

    /**
     * javadoc.
     */
    public List<Person> couples() {
        List<Person> couples = new ArrayList<>();
        couplescheck(root, couples);
        return couples;
    }

    /**
     * javadoc.
     */
    public List<Person> unmarried() {
        List<Person> unmarried = new ArrayList<>();
        unmarriedcheck(root, unmarried);
        return unmarried;
    }

    /**
     * javadoc.
     */
    private void couplescheck(Person person, List<Person> couples) {
        if (person.married() && person.getChildren().size() == 2) {
            couples.add(person);
        }
        for (Person child : person.getChildren()) {
            couplescheck(child, couples);
        }
    }

    /**
     * javadoc.
     */
    public List<Person> newGeneration() {
        List<Person> newGeneration = new ArrayList<>();
        newGenerationcheck(root, newGeneration, 0);
        return newGeneration;
    }

    /**
     * javadoc.
     */
    private void newGenerationcheck(Person person, List<Person> newGeneration, int depth) {
        if (person.getChildren().isEmpty()) {
            if (depth > maxDepth) {
                newGeneration.clear();
                maxDepth = depth;
            }
            if (depth == maxDepth) {
                newGeneration.add(person);
            }
        } else {
            for (Person child : person.getChildren()) {
                newGenerationcheck(child, newGeneration, depth + 1);
            }
        }
    }

    /**
     * javadoc.
     */
    private void unmarriedcheck(Person person, List<Person> unmarried) {
        if (!person.married()) {
            unmarried.add(person);
        }
        for (Person child : person.getChildren()) {
            unmarriedcheck(child, unmarried);
        }
    }
}
