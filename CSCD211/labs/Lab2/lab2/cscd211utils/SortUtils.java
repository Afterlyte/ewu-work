package lab2.cscd211utils;

/**
 * Enhanced SortUtil class that will be used throughout
 * the rest of the quarter for CSCD 211.<br>
 *
 * There are 2 selectionSort methods one that takes an int and one that takes a type called
 * T which is really a type that implements Comparable. <br>
 * <br>Both methods will <b>NOT</b> return a value 
 * <br>NOTE All passed parameters are always final!
 */
public class SortUtils<T>
{
   /**
    * Don't write this it if free
    */
    public SortUtils(){}


   /**
    * The selectSort method sorts the array in ascending order. The 
    * array is of type T which is ulimately of type Comparable.  This method
    * has been rewritten to remove the raw Comparable and replace it with the specific
    * type being passed in using the generic. This mean the appropriate compareTo method
    * is called.  
    *
    * @param <T> This describes a generic type
    * @param array The array to be sorted
    *
    * @throws IllegalArgumentException if the Comparable [] array is null or if the array length &lt; 1
    */
   public static <T extends Comparable <? super T>> void selectionSort(T [] array)
   {
      if(array == null || array.length <= 0)
         throw new NullPointerException("Comparable selectionSort bad Params");
         
      int start, search, min;
      T temp;
      
      for(start = 0; start < array.length - 1; start ++)
      {
         min = start;
         
         for(search = start + 1; search < array.length; search ++)
         {
            if(array[search].compareTo(array[min]) < 0)
               min = search;
         
         }// end for search
         
         temp = array[min];
         array[min] = array[start];
         array[start] = temp;     
      
      }// end for start
   
   }// end SortUtil
   
   
   /**
    * The selectionSort method sorts the array of integers in ascending order
    *
    * @param myArray Representing an array of integers
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static void selectionSort(final int [] myArray)
   {
      if(myArray == null || myArray.length < 1)
         throw new IllegalArgumentException("Bad params selectionSort");
         
      int search, start, min;
      int temp;
      
      for(start = 0; start < myArray.length - 1; start++)
      {
         min = start;
         
         for(search = start + 1; search < myArray.length; search++)
         {
            if(myArray[search] < min)
               min = search;
         }// end for search
         
         temp = myArray[start];
         myArray[start] = myArray[min];
         myArray[min] = temp;   
      
      }// end for start

   }// end method
   
}// end class