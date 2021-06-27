package io.family.tree;

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
        if(node!= null) {
            var person = node.getMember();
            var spouse = new Person(spouseName, !person.isFemale());
            node.setSpouse(spouse);
        }
    }

    public void addNewChild(String ParentName, String ChildName, boolean isFemale){
        Node parent = getNodeForPersonId(ParentName, root);
        if(parent!= null) {
            Person person = new Person(ChildName, isFemale);
            Node child = new Node(person);
            parent.addChild(child);
        }
    }

    // Returns spouse of person with id
    public String getSpouseOf(String memberId){
        Node couple = getNodeForPersonId(memberId, root);
        if (couple != null) {
            if (couple.getSpouse()!= null && couple.getMember().getName().equals(memberId)) {
                return couple.getSpouse().getName();
            } else if (couple.getSpouse()!= null && couple.getSpouse().getName().equals(memberId)) {
                return couple.getMember().getName();
            }
        }
        return null;
    }

    public String getChildrenOf(String parentName){
        Node parent = getNodeForPersonId(parentName, root);
        if (parent != null && (parent.getMember().getName().equals(parentName) || parent.getSpouse().getName().equals(parentName))) {
            List<Node> children = parent.getChildren();
            if(children.size() > 0) {
                int i;
                String childrenNames = children.get(0).getMember().getName();

                for (i = 1; i < children.size(); i++) {
                    childrenNames = childrenNames + ", " + children.get(i).getMember().getName();
                    i++;
                }
                return childrenNames;
            }
        }
        return null;
    }

    // Search the node and its children recursively till it finds the node containing the member (or spouse)
    // If not found, returns null
    private Node getNodeForPersonId(String personId, Node node){
        if (node.getMember().getId().equals(personId)) {
            return node;
        }
        if(node.getSpouse()!= null && node.getSpouse().getId().equals(personId)){
            return node;
        }

        for (var child : node.getChildren()) {
            var found = getNodeForPersonId(personId, child);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
