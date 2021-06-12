package io.ghar.family.tree;

public class FamilyTree {
    final Node root;

    public FamilyTree(String name){
        Person person = new Person(name, "male");
        root = new Node(person);
    }

    public String printRootNode(){
        return "Family created for " + root.member.name;
    }

    public String addSpouse(String input){
        String spouseName = input.split(",")[1].strip();
        String[] command = input.split(" ");
        String spouseFor = command[2].substring(0,(command[2].length() - 1));

        // Before this, we need to add logic that if the member is male, add female spouse
        // and if the member is female, add male spouse.
        Person spouse = new Person(spouseName, "female");

        Node memberNode = getCurrentMemberNode(root, "Babaji");
        memberNode.spouse = spouseName;

        return "Spouse added for " + memberNode.member.name;
    }

    // Return node with member or null
    public Node getCurrentMemberNode(Node node, String member){

        if(node.member.name.equals(member)){
            return node;
        }
        for (Node childNode : node.Children) {
            getCurrentMemberNode(childNode, member);
            if(childNode != null) {
                return childNode;
            }
        }
        return null;
    }
}
