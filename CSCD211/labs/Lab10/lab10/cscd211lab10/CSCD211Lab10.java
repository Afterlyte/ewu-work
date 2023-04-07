package lab10.cscd211lab10;

import lab10.cscd211linkedlist.LinkedList;

public class CSCD211Lab10
{
   public static void main (String[] args)
   {
      Integer [] ordered = {  0,  10,  20,  30,  40,  50,  60,  70,  80,  90,
								100, 110, 120, 130, 140, 150, 160, 170, 180, 190,
								200, 210, 220, 230, 240, 250, 260, 270, 280, 290 };
																  								    
		LinkedList <Integer> list = new LinkedList<Integer>();  
  
      list.addAll(ordered);
			
      System.out.println ("After adding " + ordered.length + " items " +
                          "the list size is " + list.size() );
     	System.out.println();
		
		System.out.println("Printing List in order");
		System.out.println(list);
		System.out.println();

		
		System.out.println("Printing  every item in the List in Reverse on Filled List");
	   list.subListReverse(0, list.size());
		System.out.println();
      
		System.out.println("Clear the List");
		list.clear();
		System.out.println();
      
		System.out.println("Printing List in Reverse on EMPTY List");
      list.subListReverse(0, 0);
		System.out.println();
		
		list.addAll(ordered);
		
		System.out.println("Printing items 3 to 10 (inclusive) in the List in Reverse");
	   list.subListReverse(3, 10);
		System.out.println();
      
      System.out.println("Printing items 19 to 19 (inclusive) in the List in Reverse");
	   list.subListReverse(19, 19);
		System.out.println();
		
		System.out.println("Printing items 0 to 0 (inclusive) in the List in Reverse");
	   list.subListReverse(0, 0);
		System.out.println();
		
		int last = list.size() - 1;
		System.out.println("Printing items " + last + " to " + last + " (inclusive) in the List in Reverse");
	   list.subListReverse(last, last);
		System.out.println();
	
		try
		{
			System.out.println("Printing items 10 to 3 in the List in Reverse -- Should Throw Exception");
	   	list.subListReverse(10, 3);
			System.out.println();
		}// end try
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("IndexOutOfBoundsException Caught: " + e.getMessage());
			System.out.println();

		}// end catch
		
		try
		{
			System.out.println("Printing items 0 to 31 in the List in Reverse -- Should Throw Exception");
	   	list.subListReverse(0, list.size() + 1);
			System.out.println();
		}// end try
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("IndexOutOfBoundsException Caught: " + e.getMessage());
			System.out.println();

		}// end catch
		
		System.out.println("Finished");
		
   }// end main
	
}// end class


/*
The output:
       
After adding 30 items the list size is 30

Printing List in order
[0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280, 290]

Printing  every item in the List in Reverse on Filled List
290 280 270 260 250 240 230 220 210 200 190 180 170 160 150 140 130 120 110 100 90 80 70 60 50 40 30 20 10 0 

Clear the List
Printing List in Reverse on EMPTY List
The list is empty

Printing items 3 to 10 (inclusive) in the List in Reverse
100 90 80 70 60 50 40 30 

Printing items 19 to 19 (inclusive) in the List in Reverse
190 

Printing items 0 to 0 (inclusive) in the List in Reverse
0 

Printing items 29 to 29 (inclusive) in the List in Reverse
290 

Printing items 10 to 3 in the List in Reverse -- Should Throw Exception
IndexOutOfBoundsException Caught: fromIndex greater than toIndex

Printing items 0 to 31 in the List in Reverse -- Should Throw Exception
IndexOutOfBoundsException Caught: toIndex is greater than size

Finished
*/
 
