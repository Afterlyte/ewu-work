package lab2.cscd211utils;


/**
 * The SearchUtils class performs basic array searching functions.
 *
 * <br>NOTE The class uses generics for the type. Please note the &lt;T&gt; on the class header
 */
public class SearchUtils <T>
{
   /**
    * Don't write this it if free
    */
    public SearchUtils(){}

	/**
    * The linearSearch functions walks the array element by element looking
    * for the target.  If the target is found the index of the first occurance of the
    * target is returned.  If the item is not in the array -1 is returned.
    *
    * @param <T> Representing the Generic type of the array
    * @param array Representing the actual array
    * @param target Representing the item to be found
    * @return int Representing the index of the first occurance of target or -1 if the item is not found
    *
    * @throws IllegalArgumentException if the array is null, target is null, or the array length
    * is &lt; 1     
    *
    * <br>NOTE Please notice the method is &lt;T&gt; void for the return type and T for the array type.
    * T is replaced by the actual type when the code is compiled.
    */
	public static <T> int linearSearch(final T [] array, final T target)
	{
      if(array == null || target == null || array.length < 1)
         throw new IllegalArgumentException("Bad Params linearSearch");
         
		for(int x = 0; x < array.length; x++)
			if(array[x].equals(target))
				return x;
		
		return -1;
	}   

}