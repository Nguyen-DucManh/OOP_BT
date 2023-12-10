package Composite;

import Composite.Family;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person james = new Person("James", "1980-06-12", "Male");
        Person hana = new Person("Hana", "1982-08-09", "Female");
        Person ryan = new Person("Ryan", "2002-03-16", "Male");
        Person kai = new Person("Kai", "2005-07-12", "Male");
        Person jennifer = new Person("Jennifer", "2003-10-05", "Female");
        Person child1 = new Person("Child1", "2025-01-12", "Male");
        Person child2 = new Person("Child2", "2027-09-10", "Female");
        Person child3 = new Person("Child3", "2029-06-15", "Male");
        Person child4 = new Person("Child4", "2031-09-23", "Female");
        james.marry(hana);
        james.addChild(ryan);
        james.addChild(kai);
        kai.marry(jennifer);
        kai.addChild(child1);
        kai.addChild(child2);
        kai.addChild(child3);
        kai.addChild(child4);
        Family family = new Family(james);
        List<Person> unmarriedPeople = family.unmarried();
        System.out.println("Các cá nhân không kết hôn trong danh sách phả hệ:");
        for (Person person : unmarriedPeople) {
            System.out.println(person);
        }

        List<Person> couplesWithTwoChildren = family.couples();
        System.out.println("Cặp đôi có hai con:");
        for (Person couple : couplesWithTwoChildren) {
            System.out.println(couple + " & " + couple.couple);
        }

        List<Person> newestGeneration = family.newGeneration();
        System.out.println("Các thế hệ mới nhất:");
        for (Person person : newestGeneration) {
            System.out.println(person);
        }
    }
}
