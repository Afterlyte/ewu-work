package lab2.cscd211lab2;

import java.io.*;
import java.util.*;
import lab2.cscd211utils.*;
import lab2.cscd211methods.*;
import lab2.cscd211classes.*;
import lab2.cscd211comparators.FirstAuthorSort;



/**
 * The provided class used to test your code.  This file will
 * not be changed!<br>
 * 
 * <br>NOTE: FileUtil and SortUtil are provided in the jar file;
 */
public class CSCD211Lab2
{
   public static void main(String [] args) throws Exception
   {
      Book [] myBooks = null;
      int choice;
      Scanner kb = new Scanner(System.in);
      
      File inf = FileUtils.openInputFile(kb); 
      Scanner fin = new Scanner(inf);
      myBooks = CSCD211Lab2Methods.fillArray(fin);
      fin.close();
      
      do
      {
         choice = CSCD211Lab2Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  CSCD211Lab2Methods.printBooks(myBooks, System.out);
                     break;
                     
            case 2:  String fileName = CSCD211Lab2Methods.readFileName(kb);
                     PrintStream fout = new PrintStream(new FileOutputStream(fileName), true);
                     CSCD211Lab2Methods.printBooks(myBooks, fout);
                     fout.close();
                     break;
                     
            case 3:  SortUtils.selectionSort(myBooks);
                     break;
            
            case 4:  Arrays.sort(myBooks, new FirstAuthorSort());
                     break;
                     
            case 5:  myBooks = CSCD211Lab2Methods.addBook(myBooks, CSCD211Lab2Methods.createBook(kb));
                     break;
                     
            case 6:  System.out.println("Program Ending");
         
         }// end choice
         
      }while(choice != 6);
   
   }// end main

}// end class