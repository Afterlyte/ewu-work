package lab8.cscd211lab8;

import lab8.cscd211recursion.CSCD211SquareBlocks;


public class CSCD211Lab8
{
   public static void main(String [] args)
   {
      for(int x = 0; x < 8; x++)
         if(x == 1)
            System.out.printf("A square with %d row has a total of %d block\n", x, CSCD211SquareBlocks.square(x));      
            
         else
            System.out.printf("A square with %d rows has a total of %d blocks\n", x, CSCD211SquareBlocks.square(x));      
            
   }// end main
   
   
}// end class 
