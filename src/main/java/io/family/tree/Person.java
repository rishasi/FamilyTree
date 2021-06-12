package io.family.tree;

public class Person {

    private final String name;
    private final boolean isFemale;
    private final String id;

    public Person(String name, boolean isFemale){
        this.name = name;
        this.isFemale = isFemale;
        id = name;
    }

    // Create a male person
    public Person(String name){
        this.name = name;
        this.isFemale = false;
        id = name;
    }

    public String getId(){
        return id;
    }

    public boolean isFemale(){
        return isFemale;
    }

    public String getName(){
        return name;
    }
}
