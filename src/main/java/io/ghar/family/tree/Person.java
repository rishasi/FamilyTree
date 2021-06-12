package io.ghar.family.tree;

public class Person {

    String name;
    String gender;
    String id;

    public Person(String name, String gender){
        this.name = name;
        this.gender = gender;
        id = name;
    }
}
