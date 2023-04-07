package cscd210Lab14;

import cscd210Classes.CheckingAccount;


/**
 * The class that contains main. 
 * 
 * @NOTE You can't change this class in any fashion.  It is expected you will write a separate main to test for
 * preconditions
 */
public class CSCD210Lab14
{
   /**
    * The main method to check your code for the CheckingAccount class you will write
    *
    * @param args Representing command line arguments
    */
	public static void main(String [] args)
	{
		CheckingAccount one = new CheckingAccount(2001556687, 2000.04);

		CheckingAccount two = new CheckingAccount(884116055);

		CheckingAccount three = new CheckingAccount(510301300, 555.66);  
      
      CheckingAccount four = one;

		System.out.println("Information on this checking accounts:\n");
		System.out.println("Account Number: " + two.getAcctNumber());  
		System.out.printf("Account Balance: %.2f\n", two.getBalance());    
      System.out.println();
      
		System.out.println("Making a deposit of 300");
		two.deposit(300.00);                                     

		System.out.println("Information on this checking account is ");
		System.out.println("Account Number: " + two.getAcctNumber());
		System.out.printf("Account Balance: %.2f\n", two.getBalance());
      System.out.println();
      
      System.out.println("Information on this checking account is ");
		System.out.println("Account Number: " + three.getAcctNumber());
		System.out.printf("Account Balance: %.2f\n", three.getBalance());
      System.out.println();
      
		System.out.println("Making a withdrawal of 132.70");
		three.withdrawal(132.70);                                
		System.out.println("Information on this checking account is ");
		System.out.println("Account Number: " + three.getAcctNumber());
		System.out.printf("Account Balance: %.2f\n", three.getBalance());
      System.out.println();
      
		System.out.println("Making a withdrawal of 750");
		two.withdrawal(750);
      System.out.printf("Account Balance: %.2f\n", two.getBalance());
      System.out.println();
      
   	System.out.println("Examine accounts");			
		
      if(one.equals(four))                                              
			System.out.println("Accounts are EXACTLY the same");

		else
			System.out.println("Accounts are NOT the same");
		
      System.out.println();
		System.out.println("Information on this checking account is ");
		System.out.println(one);
      
      System.out.println("Information on this checking account is ");
		System.out.println(two);

      System.out.println("Information on this checking account is ");
		System.out.println(three);
      
      if(one.equals(three))                                              
			System.out.println("Accounts are EXACTLY the same");

		else
			System.out.println("Accounts are NOT the same");

	}// end main

}// end class