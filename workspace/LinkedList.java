/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{

  //instance varialbes go here (think about what you need to keep track of!)
ListNode nose;
  
  //constructors go here
public LinkedList(){
  nose = null;
}

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    ListNode add = new ListNode(line,null);
    ListNode node = nose;
    while(node.getNext()!=null){
      if(node.getValue().compareto(line)>0){
        add.setNext(node.getNext());
        node.setNext(add);
      return add;
      }
      node = node.getNext();
    }
    node.setNext(add);
    return add;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    ListNode node = nose;
    while(node.getNext()!=null){
      if(node.getNext().getValue().equals(line)){
        node.setNext(node.getNext().getNext());
      return line;
      }
    }
    if(nose.getValue().equals(line)){
      nose = nose.getNext();
      return line;
    }
    return null;
  
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
  
  }
}
