package cscd210Lab12;

import java.io.*;
import java.util.Scanner;
import cscd210Utils.SortUtils;
import cscd210Utils.ArrayUtils;
import cscd210Utils.IntArrayUtils;
import lab10.cscd210Utils.FileUtils;
import cscd210Methods.CSCD210Lab12Methods;

/**
 * The class that contains the main method
 */
public class CSCD210Lab12
{
   /**
    * The main method you can't change.<br>
    *
    * @param args Representing the array of command line parameters
    * @throws Exception to quiet the Scanner object for a possible FileNotFoundException
    */
   public static void main(String [] args)throws Exception
   {
      int num, choice;
      int [] myArray = null;
      Scanner kb = new Scanner(System.in);

      File inf = FileUtils.openInputFile(args);
      Scanner fin = new Scanner(inf);
      num = CSCD210Lab12Methods.readNum(fin);
      myArray = IntArrayUtils.createAndFillArray(num, fin);
      fin.close();
      ArrayUtils.printArray(myArray);
      System.out.println();

      do
      {
         choice = CSCD210Lab12Methods.menu(kb);

         switch(choice)
         {
            case 1:  myArray = IntArrayUtils.addNum(myArray, kb);
                     ArrayUtils.printArray(myArray);
                     System.out.println();
                     break;

            case 2:  myArray = IntArrayUtils.deleteValue(myArray, kb);
                     if(myArray.length > 0)
                     {
                        ArrayUtils.printArray(myArray);
                        System.out.println();
                     }
                     break;

            case 3:  myArray = IntArrayUtils.deleteValueByIndex(myArray, kb);
                     if(myArray.length > 0)
                     {
                        ArrayUtils.printArray(myArray);
                        System.out.println();
                     }
                     break;

            case 4:  ArrayUtils.printArray(myArray);
                     System.out.println();
                     break;

            case 5:  SortUtils.selectionSort(myArray);
                     ArrayUtils.printArray(myArray);
                     System.out.println();
                     break;

            case 6: System.out.println("All Done");

         }// end switch

      }while(choice != 6);

      System.out.println("Good Bye");
      kb.close();

   }// end main

}// end class