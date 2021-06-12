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
    void getSpouseReturnSpouse(){
        familyTree.addSpouse("Grand Father", "Grand Mother");
        var expected = "Grand Mother";
        var actual = familyTree.getSpouseOf("Grand Father");

        assertEquals(expected, actual);
    }
}
