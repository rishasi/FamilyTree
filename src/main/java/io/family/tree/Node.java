package io.family.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    // Represents a person from current bloodline
    private final Person member;

    // Represents spouse of the member
    private Person spouse;

    // Represents nodes with children of the member and spouse
    private final List<Node> children = new ArrayList<>();

    public Node(Person person){
        member = person;
    }

    public Person getMember(){
        return member;
    }

    public List<Node> getChildren(){
        return children;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getSpouse(){
        return spouse;
    }
}
