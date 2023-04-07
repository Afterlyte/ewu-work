package lab7.cscd211generics;
/**
 * You will need to implement the Iterator interface for the nested MyArrayListIterator class.
 * The methods you must write are hasNext, next, and remove.
 * For your implementation of remove, throw an UnsupportedOperationException.
 * Include in your thrown exception the message 'remove not implemented for MyListIterator'
 *
 * <br> 
 *  The Iterator is used to keep track of the current location in a collection
 *  and move through the collection one step at a time.
 * <br>
 * The Iterator interface allows you to use an enhanced for loop
 * (sometimes called the foreach loop) on any class that implements
 *  the interface.  Iterator is typically attached to classes that contain
 *  some form of collection of data (array, ArrayList, etc.) as one of 
 *  its primary fields.
 *
 * @NOTE I have provided the implementation of the MyArrayList portion. I am using generics that I will explain in 
 * class.  The portion you have to write is the three methods in the MyArrayListIterator as described above.
 */
import java.util.*;

public class MyArrayList<E extends Comparable<? super E>> extends ArrayList<E> implements Iterable<E>
{
   /**
    * A protected ArrayList to hold the items
    */
   protected ArrayList<E> list;
   
   /**
    * The default value constructor that sets the ArrayList to the default capacity of 10
    */
   public MyArrayList()
   {
      this.list = new ArrayList<E>();
   
   }//end default constructor
   
   /**
    * the addLast method simply calls the ArrayList add method which is
    * really an addLast behind the scenes
    *
    * @param e Representing an object of the appropriate type
    *
    * @throws IllegalArgumentException if e is null
    */
   public void addLast(E e)
   {
      if (e == null)
         throw new IllegalArgumentException("bad param addLast");
         
      this.list.add(e);
      
   }//end addLast
   
   /**
    * Returns the number of elements in the ArrayList
    *
    * @return int Representing the size of the ArrayList
    */
   public int size()
   {
      return this.list.size();
   
   }//end size method
   
   /**
    * Uses the enhanced for loop to grab each element and append \r\n
    *
    * @return String Representing each element in the list
    */
   public String toString()
   {
      String result = "";
      
      for (E e: this)
         result += e + "\r\n";
         
      return result;
   
   }//end toString
   
   /**
    * The sort method calls the sort method from the ArrayList class wjatever the list
    * is named.sort passing the parameter c
    *
    * @param c Representing an object of a type that can be compared
    */
   public void sort(Comparator<? super E> c)
   {
      this.list.sort(c);
   }
   
   /**
    * The iterator method that must be overridden for MyArrayListIterator to
    * work properly
    *
    * @return Iterator An iterator to the appropriate type E
    */
   public Iterator<E> iterator()
   {
      return new MyArrayListIterator<E>(0, this.list);
   }//end iterator -- required by Iterable interface
   
   /**
    * The MyArrayListIterator nested class to provide a means of iterating across the collection
    * You will implement the hasNext, next, and remove methods
    *
    * @NOTE Generics are used to handle any type that is Object based
    */
   public class MyArrayListIterator<E> implements Iterator<E>
   {  
      /**
       * An int to the current location in the ArrayList
       */ 
      protected int cur;
      
      /**
       * An ArrayList reference that is of the specific type
       */
      protected ArrayList<E> listRef;
      
      /**
       * The Explicit Value Constrctor that is passed the starting position
       * and the ArrayList.
       * 
       * @param start Representing the starting position in the ArrayList
       * @param list Representing an ArrayList of an Object based type
       *
       * @throws IllegalArgumentException if the list is null
       */
      public MyArrayListIterator(int start, ArrayList<E> list)
      {
         if (list == null)
            throw new IllegalArgumentException("bad param MyArrayListIterator constructor");

         this.cur = start;
         this.listRef = list;
      
      }
      
      /**
       * The hasNext method checks if the cur index is less than the listRef size.  If it is it returns true otherwise false
       * 
       * @return boolean Representing if the current index is &lt; the listRef size
       */
      public boolean hasNext()
      {
         // your code here
      }//end hasNext
      
      /** 
       * The next method returns the value from the listRef ArrayList at the current postion.  Before the value is returned
       * the current position is incremented. If there is no next element then null is returned.
       *
       * @return E Representing an element from the ArrayList of type
       */
      public E next()
      {
         // your code here
         return null;
      
      }//end next
      
      /**
       * You do not need to implement this method other than throwing an exception
       *
       * @throws UnsupportedOperationException with the message remove not implemented for MyArrayListIterator
       */
      public void remove()
      {
         // your code here
      }
   
   }//end nested class MyArrayListIterator

}//end class MyArrayList

