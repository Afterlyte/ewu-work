package cscd210Lab11;

import java.io.*;
import java.util.Scanner;
import cscd210Utils.SortUtils;
import cscd210Utils.ArrayUtils;
import lab10.cscd210Utils.FileUtils;
import cscd210Methods.CSCD210Lab11Methods;

/**
 * It is very important that you learn to read and understand my testing files.  In this
 * instance main has a little new code and a lot of old code.  This lab focuses on
 * the basics of array, creating, filling, printing and sorting.
 * All parameters to methods will be passed as final and all 
 * preconditions will be met.  Don't write more than specified by the API.
 */
public class CSCD210Lab11
{
	/**
	 * The main method.  Note we will be using command line
	 * parameters for this lab.
	 * @param args The command line parameters including our file name
	 * @throws Exception to quiet the compiler concerning the possible
	 * FileNotFoundException
	 */
	public static void main(final String[] args)throws Exception
	{
      File inf = null;
      String fn = null;
      int choice, total;
      String [] array = null;
      Scanner kb = new Scanner(System.in), fin = null;
        
      inf = FileUtils.openInputFile(args);
      fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 2);
      fin.close();
      fin = new Scanner(inf);

      array = CSCD210Lab11Methods.fillArray(fin, total, 2);
      fin.close();
      ArrayUtils.printArray(array, System.out);
      System.out.println();
      
		do
		{
         choice = CSCD210Lab11Methods.menu(kb);
         
         if(choice == 1)
         {
            SortUtils.selectionSort(array);
            ArrayUtils.printArray(array, System.out);
            System.out.println();
         }// end choice == 1
         
         else if(choice == 2)
         {
            fn = FileUtils.readFileName(kb, "input");
            inf = FileUtils.openInputFile(fn);
            fin = new Scanner(inf);
            total = FileUtils.countRecords(fin, 1);
            fin.close();
            fin = new Scanner(inf);

            array = CSCD210Lab11Methods.fillArray(fin, total, 1);
            fin.close();
            ArrayUtils.printArray(array, System.out);
            System.out.println();
            
         }// end choice == 2
         
         else if(choice == 3)
         {
            System.out.println();
            fn = FileUtils.readFileName(kb, "output");
            PrintStream fout = new PrintStream(fn);
            ArrayUtils.printArray(array, fout);
            System.out.println();
         }// end choice == 3
         
         else if(choice == 4)
            System.out.println("Ending Program");
            
         else
         {
            System.out.println("Ending");
            throw new RuntimeException("Bad Menu Choice");
         }// end else
      
		}while(choice != 4);
      
      kb.close();

	}// end main

}// end class