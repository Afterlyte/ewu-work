package cscd210Lab13;

import cscd210Classes.Stock;

/**
 * This is the first lab concerning creating our own classes.  
 * NOTE: no methods (other than main) will be static
 */
public class CSCD210Lab13
{
   public static void main(String [] args)
   {
      Stock aStock = new Stock();
      
      Stock bStock = new Stock("MSFT", "Microsoft", 53.17);
      
      Stock cStock = new Stock("Charles Schwab", 30.18, "SCHW");
      
      System.out.println();
      System.out.println(aStock); 
        
      System.out.println();
      System.out.println(bStock);   
      
      System.out.println();
      System.out.println(cStock);   

   }// end main
}// end class