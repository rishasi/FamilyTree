package io.family.tree;

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

    // Returns spouse of person with id
    public String getSpouseOf(String memberId){
        Person spouse = getNodeForPersonId(memberId, root).getSpouse();
        if(spouse == null){
            return null;
        }
        return spouse.getName();
    }

    // Search the node and its children recursively till it finds the node containing the member
    // If not found, returns null
    private Node getNodeForPersonId(String personId, Node node){
        if(node.getMember().getId().equals(personId)){
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
