package cscd211Lab1;

import java.io.*;
import java.util.*;
import cscd211Utils.*;
import cscd211Comparators.*;
import cscd211Classes.Player;
import cscd211Methods.CSCD211Lab1Methods;


/**
 * The class that contains the main method
 * <br>NOTE All Parameters will be final and all preconditions will be checked
 */
public class CSCD211Lab1
{
	/**
	 * The main method used to test your code
	 * @param args The command line arguments if any
	 * @throws Exception To quiet the compiler for the Scanner and FileNotFound
	 */
	public static void main(String [] args)throws Exception
	{
		String outFileName;
		PrintStream fout = null;
		int totalPlayers, choice;
		File [] inFileNames = null;
		Player [] nflPlayers = null;
		Scanner kb = new Scanner(System.in);
		
		
		inFileNames = CSCD211Lab1Methods.determineDirectoryFileNames("./inputFiles/");
		totalPlayers = CSCD211Lab1Methods.determineTotalPlayers(inFileNames);
		nflPlayers = new Player[totalPlayers];
		
		CSCD211Lab1Methods.fillArray(inFileNames, nflPlayers);

		do
		{
			choice = CSCD211Lab1Methods.menu(kb);
			
			switch(choice)
			{
				case 1: ArrayUtils.printArray(nflPlayers, System.out);
						break;
						
				case 2:	outFileName = CSCD211Lab1Methods.readFilename(kb);
						fout = new PrintStream(outFileName);				
						ArrayUtils.printArray(nflPlayers, fout);
						fout.close();
						break;
						
				case 3:	SortUtils.selectionSort(nflPlayers);
						ArrayUtils.printArray(nflPlayers, System.out);
						break;
						
				case 4:	Arrays.sort(nflPlayers, new TeamComparator());
						ArrayUtils.printArray(nflPlayers, System.out);
						break;
						
				case 5:	Arrays.sort(nflPlayers, new PositionComparator());
						ArrayUtils.printArray(nflPlayers, System.out);
						break;
						
				case 6:	Arrays.sort(nflPlayers, new GamesPlayedComparator());
						ArrayUtils.printArray(nflPlayers, System.out);
						break;
						
				case 7:	outFileName = CSCD211Lab1Methods.readFilename(kb);
						fout = new PrintStream(outFileName);	
						String teamCode = CSCD211Lab1Methods.readTeamCode(kb);
						CSCD211Lab1Methods.printArray(nflPlayers, fout, teamCode);
						fout.close();
						break;
			 						
				case 8: Player target = CSCD211Lab1Methods.readPlayer(kb);
						nflPlayers = CSCD211Lab1Methods.removePlayer(target, nflPlayers);
						ArrayUtils.printArray(nflPlayers, System.out);
						break;
				
				default:	System.out.println("Program Ending");
				
			}// end switch

			System.out.println();

		}while (choice != 9);

		kb.close();
		
	}// end main
	
}// end class