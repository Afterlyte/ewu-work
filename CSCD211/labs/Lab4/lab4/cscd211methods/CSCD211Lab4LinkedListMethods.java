package lab4.cscd211methods;

import java.util.Scanner;

/**
 * Some basic methods we will need to use in conjunction with the LinkedList class
 * Note All parameters will be final and all preconditions met
 */
public class CSCD211Lab4LinkedListMethods
{
   /**
    * menu method for testing your linked list
    * <br>  1) Print the List
    * <br>  2) Create a BoxCar and addFirst
    * <br>  3) Create a BoxCar and addLast
    * <br>  4) Create a BoxCar, read and index and add -- at the index
    * <br>  5) Create a BoxCar, check the list to see if the list contains the BoxCar
    * <br>  6) Create a BoxCar, find the indexOf that BoxCar
    * <br>  7) removeFirst
    * <br>  8) removeLast
    * <br>  9) Read index remove Node at that index
    * <br> 10) Create a BoxCar and removeFirstOccurrence of that BoxCar
    * <br> 11) Create a BoxCar and removeLastOccurrence of that BoxCar
    * <br> 12) clear the list
    * <br> 13) Print the size of the list
    * <br> 14) Quit
    * <br> You must ensure the value entered in within range
    *
    * @param kb Representing the Scanner Object
    * @return int  - The choice guaranteed by you to be between 1 and 14 inclusive
    *
    * @throws IllegalArgumentException if kb is null
    */
   public static int menu(final Scanner kb)
   {
	   return 14;      
   }
   
   /**
    * Prompts the user for a String and reads the String from the keyboard
    *
    * @param kb The Scanner object
    * @return String The String read from the keyboard
    *
    * @throws IllegalArgumentException if kb is null
    */
   public static String buildAString(final Scanner kb)
   {
      return null;
   }
   
   
   /**
    * readIndex reads a value greater than -1
    *
    * @param kb The Scanner object
    * @return int - The index will be guaranteed by you to be greater than -1
    *
    * @throws IllegalArgumentException if kb is null
    */
   public static int readIndex(final Scanner kb)
   {
      return 0;
   }
   
   

}