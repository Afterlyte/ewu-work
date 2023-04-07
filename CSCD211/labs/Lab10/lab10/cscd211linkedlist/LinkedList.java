package lab10.cscd211linkedlist;

import java.util.*;

/**
 * The provided LinkedList class and Node class.  You can't change my Node class
 * You need to add  your code in the provided methods
 *
 * @param <T> A type that implements Comparable and a compareTo method using the Generic
 */
public class LinkedList<T extends Comparable <T>>
{
	
   protected class Node
   {
      public T data;
      public Node next;
      
      public Node()
      {
    	  this.data = null;
    	  this.next = null;
      }
      
      public Node(final T data)
      {
         this(data, null);
      }
      
      public Node(final T data, final Node next)
      {
         this.data = data;
         this.next = next;
      }
   }// end class Node
   
   protected Node head;
   protected int size;
   
   
   /**
    * Constructs a list with a dummy head node
    */
   public LinkedList()
   {
      this.head = new Node();
      this.size = 0;
      
   }// end DVC
   

      
   /**
    * Inserts all of the elements in the specified array into this list in the order
    * the items appear in the array, starting at the head of the list. Shifts the
    * element currently at that position (if any) and any subsequent elements
    * to the right (increases their indices). The new elements will appear in the
    * list in the order that they were in the array
    *
    * @param array containing elements to be added to this list
    *
    * @throws IllegalArgumentException if the array is null
    */
   public void addAll(final T [] array)
   {
      if(array == null)
         throw new IllegalArgumentException("null array in addAll");
         
      for(int x = array.length - 1; x > -1; x--)
      {
         Node nn = new Node(array[x]);
         nn.next = this.head.next;
         this.head.next = nn;
         this.size ++;
      }// end for
        
   }// end addAll
   
   /**
    * Removes all of the elements from this list. 
    * The list will be empty (except the dummy head node) after this call returns.    
    */
   public void clear()
   {
      this.head = new Node();
      this.size = 0;
   }// end clear
   
      
   /**
    * Returns the number of elements in this list.
    *
    * @return int The size
    */
   public int size()
   {
      return this.size;
   }// end size
     
   /**
    * Returns the contents of the list in the format [item, item, item]
    * or Empty List if the list is empty
    *
    * @return String Representing the contents of the list
    */
   public String toString()
   {
      if(this.head.next == null)
         return "Empty List";
         
      Node cur = this.head.next;
      String str = "[";
      while(cur.next != null)
      {
         str += cur.data + ", ";
         cur = cur.next;
      }// end while
      
      str = str += cur.data + "]";
      
      return str;
   }// end toString
   
   /**
   * If the list is empty, print the message "The list is empty"
	* Check the indexes to ensure
	* -fromIndex is not less than 0
	* -toIndex is not greater than size
	* -fromIndex is less than toIndex
	*
   * @param fromIndex Representing the index to start printing from in reverse order
   * (this value will be the last item printed)
   * @param toIndex Representing the index to stop printing from in reverse order
   * (this value will be the first item printed)
   *
   * @throws IndexOutOfBoundsException if one of the indexes are incorrect
   * meaning the fromIndex is greater than the toIndex otherwise print the
   * nodes fromIndex to toIndex in reverse order or the toIndex is greater
   * than size
   *
   * Note you will need to write a private method called subListReverse that is
   * overloaded from the initial call from main. This method will need additional 
   * parameters
   */
  	public void subListReverse(final int fromIndex, final int toIndex)
	{
      if(fromIndex > toIndex)
         throw new IndexOutOfBoundsException("fromIndex greater than toIndex\n");
         
      else if(toIndex > this.size)
         throw new IndexOutOfBoundsException("toIndex is greater than size\n");


      if(this.head.next == null)
         System.out.println("The list is empty");
         
      else
      {
         subListReverse(this.head.next, fromIndex, toIndex, 0);
         System.out.println();
      }// end else
              			
	}// end subListReverse
   
   private void subListReverse(Node cur, final int fromIndex, final int toIndex, final int currentIndex)
   {   
         
   }// end subListReverse
   
}// end list