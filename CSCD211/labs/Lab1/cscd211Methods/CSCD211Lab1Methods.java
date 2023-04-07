package cscd211Methods;

import java.io.*;
import java.util.*;

import cscd211Classes.Player;
import cscd211Enums.NFLTeam;
import cscd211Utils.FileUtils;
import cscd211Utils.SearchUtils;

/**
 * The methods you will mostly need to write to complete Lab 1
 * <br> NOTE: All parameters will be final and all preconditions will be checked
 */
public class CSCD211Lab1Methods
{
	/**
	 * Don't write this it is free
	 */
	public CSCD211Lab1Methods() {}
	
	/**
	 * Provided by me
	 * @param kb Representing the open keyboard
	 * @return String the name of the file for output
	 * @throws IllegalArgumentException if kb is null
	 */
	public static String readFilename(final Scanner kb)
	{
		if(kb == null)
			throw new IllegalArgumentException("Bad Scanner in readFilename");
		
		String name = null;
		do
		{
			System.out.print("Please enter the name of the output file ");
			name = kb.nextLine();
			
		}while(name == null || name.isEmpty());
		
		return name;
	}
	

	/**
	 * Provided by me
	 * @param kb Representing the open keyboard
	 * @return int The menu choice
	 * @throws IllegalArgumentException if kb is null
	 */
	public static int menu(Scanner kb)
	{
		if(kb == null)
			throw new IllegalArgumentException("Bad Scanner in menu");
		
		/*
		1.	Print all Players to the screen
		2.	Print all Players to the User Specified file
		3.	Sort the Players by Natural Order
		4.	Sort the Players by Team and print to the screen
		5.	Sort the Players by Position and print to the screen
		6.	Sort the Players by Games Played and print to the screen
		7.  Print a entire team and only that team to a user specified file
		8.	Remove a player
		9.	Quit
		*/
		
		int choice;
		
		do
		{
			System.out.println("1) Print all Players to the screen");
			System.out.println("2) Print all Players to the User Specified file");
			System.out.println("3) Sort the Players by Natural Order");
			System.out.println("4) Sort the Players by Team and print to the screen");
			System.out.println("5) Sort the Players by Position and print to the screen");
			System.out.println("6) Sort the Players by Games Played and print to the screen");
			System.out.println("7) Print a entire team and only that team to a user specified file");
			System.out.println("8) Remove a player");
			System.out.println("9) Quit");
			System.out.print("Choice --> ");
			
			choice = Integer.parseInt(kb.nextLine());
			
		}while(choice < 1 || choice > 9);
		
		System.out.println();

		return choice;

	}// end menu
	

}// end class
