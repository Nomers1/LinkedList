//Author: Noam Reich
//Date Created: 9/22/2026


/*
Description: A program that keeps and manipulates a linked list of
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
ListNode tail;
  
  //constructors go here
public LinkedList(String value){
  nose = new ListNode(value,null);
}
public LinkedList(){
  nose = null;
}

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line){
    ListNode node = nose;
    ListNode add = new ListNode(line,null);
    if(nose == null){
      nose = new ListNode(line,null);
      return nose;
    }else if(nose.getValue().compareTo(line)>0){
      add.setNext(nose);
      nose = add;
      return add;
    }
    while(node.getNext()!=null){
      if(node.getNext().getValue().compareTo(line)>0){
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
    if(nose.getValue().equals(line)){
      ListNode temp = nose;
      nose = nose.getNext();
      return temp;
    } 
    node = nose;
    
    while(node.getNext()!=null){
      if(node.getNext().getValue().equals(line)){
        //ListNode temp = new ListNode(node.getNext().getValue(),node.getNext());
        ListNode temp = node.getNext();
        node.setNext(node.getNext().getNext());
      return temp;
      }
      node = node.getNext();
    }
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String list = "";
    ListNode node = nose;
    while(node!=null){
      list+= node.getValue()+" ";
      node = node.getNext();
    }
      return list;
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear(){
  nose = null;
  }
  
  //precondition: the list has been initialized
  //postconditions: reverse the entire linked list such that the 
  // tail is now the head and the head is the tail
  public void reverse(){
    ListNode node = nose;
    ListNode prev = null;
    while(node != null){
      ListNode next = node.getNext();
      node.setNext(prev);
      prev = node;
      node = next;
    }
    nose = prev;
  }

  //precondition: the list has been initialized and n >= 0
  //postconditions: take each "chunk" of n nodes and reverse them. If there aren't enough 
  //nodes at the end to fit into a chunk they are left without being reversed.
  public void nReverse(int n){
    if(n <= 1 || nose == null) return;
    ListNode prev = nose;
    ListNode curr = prev.getNext();
    ListNode next = curr.getNext();
    ListNode tempTail = nGetNext(n-1, nose);
    nose = tempTail;
    while(tempTail!=null){
      ListNode tempHead = prev;
      for(int i = 1; i<n; i++){
        curr.setNext(prev);
        prev =curr;
        curr = next;
        if(next != null)
        next = next.getNext();
      }
        tempTail = nGetNext(n-1, curr);
        if(tempTail != null){
        tempHead.setNext(tempTail);
        }else{
          tempHead.setNext(curr);
          return;
        }  
        prev =curr;
        curr = next;
        next = next.getNext();
    }

  }
  // pre-condition: next is either null or a valid ListNode.
	// post-condition: the last node in the "chunk" of n
	public static ListNode nGetNext(int n, ListNode node){
	while(node != null && n>0){
    node = node.getNext();
    n--;
	}
  if(n==0)return node;
  else return null;
	}

}

	
