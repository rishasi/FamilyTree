package io.family.tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class FamilyTreeTest {

    FamilyTree familyTree = new FamilyTree("Grand Father");

    @Test
    void getSpouseReturnNullIfNoSpouse(){
        var actual = familyTree.getSpouseOf("Grand Father");
        assertNull(actual);
    }

    @Test
    void addSpouseReturnSpouse(){
        familyTree.addSpouse("Grand Father", "Grand Mother");
        var expected = "Grand Mother";
        var actual = familyTree.getSpouseOf("Grand Father");

        assertEquals(expected, actual);
    }

    @Test
    void getSpouseForMemberOrNonMember(){
        familyTree.addSpouse("Grand Father", "Grand Mother");
        var expected = "Grand Father";
        var actual = familyTree.getSpouseOf("Grand Mother");

        assertEquals(expected, actual);
    }

    @Test
    void addChildrenReturnChildren(){
        familyTree.addChild("Grand Father", "Ned Stark", false);
//        familyTree.addChild("Grand Father", "Eddard Stark", false);
        var expected = "Ned Stark";
        var actual = familyTree.getChildrenOf("Grand Father");

        assertEquals(expected, actual);
    }
}
