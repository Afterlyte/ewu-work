package lab4.cscd211linkedlist;
import java.util.*;
/**
 * The LinkedList class with a dummy head node
 * NOTE All preconditions will be met and all parameters will be final
 */
public class LinkedList<T extends Comparable <? super T>>
{
	/**
	 * The private Node class as discussed in class
	 */
   private class Node
   {
	   /**
	    * The Node class data element as T which is a generic that is Comparable
	    */
      public T data;
      
      /**
       * The Node class next reference for the singly linked list
       */
      public Node next;
      
      /**
       * The node class constructor that only takes the data item
       * @param data Representing the data 
       */
      public Node(final T data)
      {
    	  this.data = data;
    	  this.next = null;

      }
      
      /**
       * The node class constructor that takes the data item and the next
       * reference 
       * @param data Representing the data
       * @param next Representing the next reference
       */
      public Node(final T data, final Node next)
      {
         this.data = data;
         this.next = next;
      }
   }// end class Node
   
   /**
    * The Class Level Head reference that allows us access to the list
    */
   private Node head;
   
   /**
    * The variable size that is a convenience for us
    */
   private int size;
   
   /**
    * Constructs an empty list.<br>
    * Dummy Head Node
    */
   public LinkedList()
   {
      
   }
   
   /**
    * Returns the number of elements in this list.
    *
    * @return int  - Representing the size
    */
   public int size()
   {
      return this.size;
   }
   
   /**
    * Removes all of the elements from this list. 
    * The list will be empty after this call returns.    
    */
   public void clear()
   {
   
   }
   
   /**
    * Inserts the specified element at the beginning of this list.
    *
    * @param item The item to add
    *
    * @throws IllegalArgumentException if item is null
    */
   public void addFirst(final T item)
   {
     
   }
   /**
    * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    *
    * @param item The item to find
    * @return int - The index if found or -1
    *
    * @throws IllegalArgumentException if item is null
    */
   public int indexOf(final T item)
   {
      return -1;
   }
   
   
   /** 
    * Removes and returns the first element from this list.
    *
    * @return T - The item removed
    *
    * @throws NoSuchElementException - if this list is empty
    */
   public T removeFirst()
   {
      return null;
   }
   
   /** 
    * Removes and returns the last element from this list.
    *
    * @return T - The item removed
    *
    * @throws NoSuchElementException - if this list is empty
    */
   public T removeLast()
   {
      return null;
   }
   
   /**
    * Removes the element at the specified position in this list. 
    * Shifts any subsequent elements to the left (subtracts one from their indices). 
    * Returns the element that was removed from the list.
    *
    * @param index The index of the element to be removed
    * @return T - The element previously at the specified position
    *
    * @throws IndexOutOfBoundsException - if the index is out of range (index less than 0 || index greater than or equal to size())
    */   
   public T remove(final int index)
   {
      return null;
   }
   
   /**
    * Inserts the specified element at the specified position in this list. 
    * Shifts the element currently at that position (if any) and any subsequent 
    * elements to the right (adds one to their indices).
    *
    * @param index The index at which the specified element is to be inserted
    * @param item The element to be inserted
    *
    * @throws IndexOutOfBoundsException if the index is out of range (index less than 0 || index greater than size())
    * @throws IllegalArgumentException if item is null
    */
   public void add(final int index, final T item)
   {

   }
   
   /**
    * Removes the last occurrence of the specified element in this list 
    * (when traversing the list from head to tail). 
    * If the list does not contain the element, it is unchanged.
    *
    * @param item The element to be removed from this list, if present
    * @return true - If the list contained the specified element
    *
    * @throws IllegalArgumentException if item is null
    */ 
   public boolean removeLastOccurrence(final T item)
   {
      return false;
   }

   /**
    * Removes the first occurrence of the specified element in this list 
    * (when traversing the list from head to tail). 
    * If the list does not contain the element, it is unchanged.
    *
    * @param item The element to be removed from this list, if present
    * @return true - If the list contained the specified element
    *
    * @throws IllegalArgumentException if item is null
    */ 
   public boolean removeFirstOccurrence(final T item)
   {
      return false;
   }

   /**
    * Appends the specified element to the end of this list.
    * 
    * @param item The element to be added to this list
    *
    * @throws IllegalArgumentException if item is null
    */
   public void addLast(final T item)
   {

   }

   /**
    * Returns the contents of the list in the format [item, item, item]
    * or Empty List if the list is empty
    *
    * @return String - Representing the contents of the list
    */
   public String toString()
   {
      return "";
   }
   
   /**
    * Returns true if this list contains the specified element. 
    * More formally, returns true if and only if this list contains at 
    * least one element AKA first occurrance
    *
    * @param item The element whose presence in this list is to be tested
    * @return boolean - true if this list contains the specified element
    *
    * @throws IllegalArgumentException if item is null
    */
   public boolean contains(final T item)
   {
      return false;
   }
   
   

}