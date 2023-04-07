package cscd210Lab7;

import java.util.Scanner;
import cscd210Methods.CSCD210Lab7Methods;

/**
 * The class that contains main.  You may not change this class or main in any fashion.
 * All parameters passed to methods will be final and all preconditions will be enforced
 */
public class CSCD210Lab7
{
   /**
    * The main method provided by me.  You can't change this method
    * @param args Representing command line arguments
    */
	public static void main(String [] args)
	{
      int term = 0;
		boolean goAgain;
		Scanner kb= new Scanner(System.in);
                
      do
      {
         term = CSCD210Lab7Methods.readTerm(kb);
         CSCD210Lab7Methods.calculatePi(term);
         goAgain = CSCD210Lab7Methods.goAgain(kb);
         
		}while(goAgain);

	   kb.close();

	}// end main

}// end class