package lab7.cscd211lab7;

import java.io.*;
import java.util.*;
import lab7.cscd211utils.*;
import lab7.cscd211methods.*;
import lab7.cscd211comparators.*;
import lab7.cscd211classes.teams.*;
import lab7.cscd211generics.MyArrayList;
/**
 * The class that tests all the code for this lab.
 *
 * @NOTE All Parameters will be passed as final and all preconditons will be enforced
 */
public class CSCD211Lab7
{
   public static void main(String [] args)throws Exception
   {
      File inf = null;
      int choice;
      MyArrayList<Team> theTeams = new MyArrayList<Team>();
      Scanner fin = null, kb = new Scanner(System.in);
      
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      CSCD211Lab7Methods.fillArrayList(fin, theTeams);
      System.out.println("The number of teams is: " + theTeams.size());
      System.out.println();
      fin.close();
      
      do
      {
          choice = CSCD211Lab7Methods.menu(kb);
          switch(choice)
          {
            case 1:  System.out.println();
            		   System.out.println(theTeams + "\n");
                     break;
                     
            case 2:  Collections.sort(theTeams);
                     System.out.println();
            		   System.out.println(theTeams + "\n");
                     break;
                     
            case 3:  Collections.sort(theTeams, new TeamPayrollComparator());
                     System.out.println();
            		   System.out.println(theTeams + "\n");
                     break;
                     
            default: System.out.println("Exiting");
                     
          }// end switch
          
      }while(choice != 4); 
      
      kb.close();

   }// end main
   
}// end class