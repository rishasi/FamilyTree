# FamilyTree

**API design** to create model for a bloodline and query relationships from it.



### Building tree

Design question ?

- Should we use `Person` to add people to family tree or should we use string names ?



Will support operations like : 

```java
// If we use names to create person 

// Alwasy starts with a male member
familyTree.Create('Member Name');
familyTree.AddSpouse('Member Name', 'Spouse Name');

// Add a son
familyTree.AddChild('Parent Name', 'Son Name', true); 

// Add a daughter 
familyTree.AddChild('Parent Name', 'Daughter Name', false); 

// In future if we need to set additional data for a family member 
familyTree.getPerson('Person Name').setBirthDate(date);
```



```java
// If we use domain object (Person) to create new person

Person malePerson = new Person('Member Name');
Person femalePerson = new Person('Member Name', true);

var husband = new Person('Member Name');
familyTree.create(husband);

var wife = new Person("Spouse name")
familyTree.addSpouse(husband.getId(), wife);

// Add a son
var son = new Person('Son Name');
familyTree.addChild(wife.getId(), son); 

// Add a daughter 
var daughter = new Person('Daughter Name', true);
familyTree.addChild(husband.getId(), daughter); 

// Add a husband 
var sonInLaw = new Person('Man Name', true);
familyTree.addSpouse(daughter.getId(), sonInLaw); 
```



Choosing the API design: 

| With string name               | With Person object                | Comments                                                     |
| ------------------------------ | --------------------------------- | ------------------------------------------------------------ |
| Simple and direct              | Easy to add more fields to person |                                                              |
| Hard to add fields to person ? |                                   | What if we just add a new person data like `famityTree.getPerson('Person Name').setDateOfBirth(date)` |
|                                |                                   |                                                              |

**Rishabh** : We will go with string for now.

**KISS :** Keep it simple silly !!



### Relations Queriying

Will support quries like : 

```java
familyTree.getChildrenOf('Parent Name');
// 'Child one', 'Child two'

familyTree.getSonOf('Parent Name');
// 'SoneOne Name', 'SoneTwo Name'

familyTree.getDaughterOf('Parent Name');
// 'DaughterOne Name', 'DaughterTwo Name'

familtyTree.getSpouseOf('Person Name')
// 'Spouse Name'
  
familtyTree.getFatherOf('Child Name')
// 'Father Name'
  
familtyTree.getGrandMotherOf('Child Name')
// 'GrandMother Name'
  
familtyTree.getUnclesOf('Child Name')
// 'PersonOne Name', 'PersonTwo Name'  

familtyTree.getBrotherInLawsOf('Person Name')
// 'PersonOne Name', 'PersonTwo Name'  

familtyTree.getNephewsOf('Person Name')
// 'NephewOne Name', 'NephewTwo Name'
  
familtyTree.getCousingOf('Person Name')
// 'CousinOne Name', 'CousinTwo Name'
```



### Internal design

- We represent the bloodline by a  tree structure

- A person is represented by `Person` class

  ```java
  public class Person {
  	private String name;
    private boolean isFemale;
    
    // Currently we will use name as id
    // It is expect that if members have same name, we will append
    // Roman numerals as suffix to names 
    // e.g. "Rishu I" and "Rishu II"
    private String id;
  }
  ```

  

- Each Node will have three fields : 

  ```java
  public class Node {
  
    // Represents a person from current bloodline
  	private Person member;
    
    // Represents spouse of the member
    private Person spouse;
    
    // Represents nodes with children of the member and spouse
    private List<Node> children;
  }
  ```


---

#### Task List:

- [x] Allow creating Default tree
- [x] Allow adding and querying Spouse and Children
- [x] Test the above functionality

This comletes the basic setup for the Tree. Next is to implement querying relationships.

- [x] Implement finding Grand Father for a member.

Before proceeding further, it makes sense to add logic for:

- [ ] Find Cousing(s) for a member
- [ ] Find Brother(s) for a member
- [ ] Find Sister(s) for a member

And then we can proceed with more complex relations:

- [ ] Implement finding Granch Child(s) for a member/non-member.
- [ ] Implement finding Aunt(s) for a member.
- [ ] Find Uncle(s) for a member.

