package io.ghar.family.tree.tree;

import io.ghar.family.tree.FamilyTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyTreeTest {

    FamilyTree myFamily = new FamilyTree("Babaji");

    @Test
    void shouldCreateDefaultFamily(){
        FamilyTree defaultTree = new FamilyTree("Babaji");
        String expected = "Family created for Babaji";
        String actual = defaultTree.printRootNode();
        assertEquals(expected, actual);
    }

    @Test
    void shouldAllowAddingSpouse(){
        String command = "add spouse Babaji, Amma";
        String actual = myFamily.addSpouse(command);
        String expected = "Spouse added for Babaji";
        assertEquals(expected, actual);
    }
}
