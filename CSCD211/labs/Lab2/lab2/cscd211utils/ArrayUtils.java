package lab2.cscd211utils;

import java.io.PrintStream;


/**
 * The ArrayUtils class performs basic array functions, such as printing the arrays.
 *
 * <br>NOTE The class uses generics for the type. Please note the &lt;T&gt; on the class header
 */
public class ArrayUtils<T>
{

   /**
    * Don't write this it if free
    */
    public ArrayUtils(){}

   /**
    * The printArray prints the array in the format [item1, item2, ...]
    *
    * @param <T> Representing the Generic type of the array
    * @param myArray Representing the actual array
    * @param fout Representing the PrintStream object
    *
    * @throws IllegalArgumentException if the array is null, fout is null, or the array length
    * is &lt; 1     
    *
    * <br>NOTE Please notice the method is &lt;T&gt; void for the return type and T for the array type.
    * T is replaced by the actual type when the code is compiled.
    */
   public static <T> void printArray(final T [] myArray, final PrintStream fout )
   {
      if(myArray == null || myArray.length < 1 || fout == null)
         throw new IllegalArgumentException("Bad params printArray");
         
      String str = "[\n";
      
      for(int x = 0; x < myArray.length - 1; x++)
         str += myArray[x] + ",\n\n";
         
      str += myArray[myArray.length - 1] +"\n]";
      
      fout.println(str);

   }// end printArray
   
}// end class