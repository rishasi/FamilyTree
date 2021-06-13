package io.family.tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    final Node root;

    // Tree is created from a male member
    public FamilyTree(String rootPersonName){
        Person person = new Person(rootPersonName);
        root = new Node(person);
    }

    public void addSpouse(String memberName, String spouseName){
        var node = getNodeForPersonId(memberName, root);
        var person = node.getMember();
        var spouse = new Person(spouseName, !person.isFemale());
        node.setSpouse(spouse);
    }

    public void addChild(String ParentName, String ChildName, boolean isFemale){
        Node parent = getNodeForPersonId(ParentName, root);
        Person person = new Person(ChildName, isFemale);
        Node child = new Node(person);
        parent.addChild(child);
    }

    // Returns spouse of person with id
    public String getSpouseOf(String memberId){
        try {
            Node couple = getNodeForPersonId(memberId, root);
                if (couple.getMember().getName().equals(memberId)){
                    return couple.getSpouse().getName();
                }
                else if (couple.getSpouse().getName().equals(memberId)){
                    return couple.getMember().getName();
                }
        }
        catch (Exception e){}
        return null;
    }

    public String getChildrenOf(String parentName){
        try {
            Node parent = getNodeForPersonId(parentName, root);
            if (parent.getMember().getName().equals(parentName) || parent.getSpouse().getName().equals(parentName)){
                List <Node> children = parent.getChildren();
                int i = 0;

                String namesToReturn = children.get(0).getMember().getName();

                for (i = 1; i < children.size(); i++) {
                    namesToReturn = namesToReturn + ", " + children.get(i).getMember().getName();
                    i++;
                }

                return namesToReturn;
            }
        }
        catch (Exception e){}
        return null;

    }

    // Search the node and its children recursively till it finds the node containing the member (or spouse)
    // If not found, returns null
    private Node getNodeForPersonId(String personId, Node node){
        if(node.getMember().getId().equals(personId) || node.getSpouse().getId().equals(personId)){
            return node;
        }

        for (var child: node.getChildren()) {
            var found = getNodeForPersonId(personId, child);
            if(found != null){
                return found;
            }
        }
        return null;
    }
}
