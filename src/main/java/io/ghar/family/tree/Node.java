package io.ghar.family.tree;

import java.util.ArrayList;

public class Node {
    protected Person member;
    protected String spouse;

    public Node(Person person){
        member = person;
    }

    protected ArrayList<Node> Children = new ArrayList<>();

}
