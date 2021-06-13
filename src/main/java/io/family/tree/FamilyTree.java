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
        try {
            Node couple = getNodeForPersonId(memberId, root);
            if (couple == null){
            return null;
            }
            else{
                if (couple.getMember().getName().equals(memberId)){
                    return couple.getSpouse().getName();
                }
                if (couple.getSpouse().getName().equals(memberId)){
                    return couple.getMember().getName();
                }
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
