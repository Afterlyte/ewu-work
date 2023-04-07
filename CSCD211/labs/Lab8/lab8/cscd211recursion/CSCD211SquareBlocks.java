package lab8.cscd211recursion;


public class CSCD211SquareBlocks
{

   /**
    * We have square made of blocks. 
    * The topmost row has 1 block, the next row down has 2 blocks, 
    * the next row has 3 blocks, and so on. 
    * Compute recursively (no loops or multiplication) the total 
    * number of blocks in such a square with the given number of rows.
    * 
    * square(0) - 0
    * square(1) - 1
    * square(2) - 3
    *
    * <br>
    * @param row The number of rows
    * @return int - the number of blocks for the given n
    */
   public static int square(final int row)
   {
         return 0;
   }// end squares
      
}// end class

/*
A square with 0 rows has a total of 0 blocks
A square with 1 row has a total of 1 block
A square with 2 rows has a total of 3 blocks
A square with 3 rows has a total of 6 blocks
A square with 4 rows has a total of 10 blocks
A square with 5 rows has a total of 15 blocks
A square with 6 rows has a total of 21 blocks
A square with 7 rows has a total of 28 blocks
*/
