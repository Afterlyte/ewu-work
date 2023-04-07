package cscd210Methods;

import java.util.Scanner;
import java.text.DecimalFormat;


public class CSCD210Lab7Methods
{
   
   /**
    * You will not write this method it is provided for free
    */
    public CSCD210Lab7Methods(){}
    
    
   /**
    * The readTerm method prompts the user to enter the number of terms for the PI calculation.  The method
    * ensures the term is greater than 9. The method also ensures the input buffer is left clean.
    * You must use a while loop to ensure the term is greater than 9
    * @param kb Reprsenting the open Scanner object to the keyboard
    * @return int Representing the term is greater than 9
    * @throws IllegalArgumentException if kb is null
    */
   public static int readTerm(final Scanner kb)
   {
      return 0;
   }// end readTerm
   
   
   
   /**
    * The calculatePi method determines the value of Pi based on the taylor series of 
    * 4 - 4/3 + 4/5 - 4/7 + 4/9 - ... up to and including term.  
    * The results of the last 10 calculations of pi are displayed to the screen using a Decimal Format object
    * to 15 decimal places.
    * @param term Representing the term value you would like to calculate Pi to
    * @throws IllegalArgumentException if term is less than 10
    */
   public static void calculatePi(final int term)
   {
   
   }// end method
    
    
    /**
    * The goAgain method prompts the user to enter yes or no and ensures the user only
    * entered yes or no.  The loop to ensure yes or no is up to you.  The 
    * method will leave the input buffer empty.
    * @param kb Reprsenting the open Scanner object to the keyboard
    * @return boolean Representing true if the user chose yes otherwise false
    * @throws IllegalArgumentException if kb is null
    */
    public static boolean goAgain(final Scanner kb)
    {
      return false;
    }// end goAgain
    
}// end class