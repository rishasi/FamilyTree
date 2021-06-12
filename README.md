# FamilyTree

API design to create mode for a bloodlineand query relationships from it.



### Building tree

Design question ?

- Should we use `Person` to add people to family tree or should we use string names ?



Will support operations like : 

```java
// If we use names to create person 

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

