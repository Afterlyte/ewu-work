package cscd210Lab9;

import java.util.Scanner;
import lab7.cscd210Methods.CSCD210Lab7Methods;
import cscd210Methods.CSCD210Lab9Methods;

/**
 * The point of this lab is method overloading. Method overloading is defined as a single class have two or more methods with the same name but
 * different parameters.  You can't method overload via return type only the parameters.  Different parameters are defined as different number or same number
 * different type.
 * <br>NOTE: Please look at the code of main for additional NOTES
 */
public class CSCD210Lab9
{
	/**
	 * The main method for this lab.  
	 * @param args Representing any command line arguments which there are none
	 */
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      
      String name = null;
      double height, weight;
      
      do
      {
    	  name = CSCD210Lab9Methods.readName(kb);
    	  
    	  /**
    	   * NOTE: The next two methods are very similar with the parameters reveresed.  You will not repeat the code 
    	   * instead write the information in one of the methods and call that method from the other method just reversing
    	   * the parameters.
    	   */    	  
          height = CSCD210Lab9Methods.readInfo(kb, "height");
          weight = CSCD210Lab9Methods.readInfo("weight", kb);
          
          CSCD210Lab9Methods.displayResults(name, height, weight, CSCD210Lab9Methods.calcBMI(height, weight));
         
      }while(CSCD210Lab7Methods.goAgain(kb));   // Since we wrote this code in Lab 7 we are using it here now
      
      kb.close();
   
   }// end main

}// end class