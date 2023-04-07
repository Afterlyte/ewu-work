package cscd210Lab10;

import java.io.*;
import java.util.Scanner;
import cscd210Utils.FileUtils;

/**
 * This is the class used to test all your FileUtils methods
 */
public class CSCD210Lab10
{
	/**
	 * The main method.  This method is passed command line parameters,
	 * those command line parameters will be passed to an openInputFile method
	 * @param args Representing command line arguments
	 * @throws Exception This is used to quite the compiler because it doesn't know what we know
	 */
   public static void main(String [] args)throws Exception
   {
      int num = 0;
      File inf = null, outf = null;
      String fileName = null;
      PrintStream fout = null;
      Scanner kb = new Scanner(System.in), fin = null;

      /* Filename passed in to main */            
      inf = FileUtils.openInputFile(args);
      fin = new Scanner(inf);
      num = FileUtils.countRecords(fin, 1);
      fin.close();
      fin = new Scanner(inf);      
      FileUtils.displayFile(num, fin, 1);
      fin.close();
      
      
      /* open the input file by reading the file name
         from the keyboard unitl a valid file is opened
       */
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      num = FileUtils.countRecords(fin, 2);
      fin.close();
      fin = new Scanner(inf);      
      FileUtils.displayFile(num, fin, 2);
      fin.close();
      
      
      /* read the filename from the keyboard
         pass that filename to openInputFile
       */ 
      fileName = FileUtils.readFileName(kb, "input");      
      inf = FileUtils.openInputFile(fileName);
      fin = new Scanner(inf);
      FileUtils.displayFile(fin);
      fin.close();
      
      fin = new Scanner(inf);
      fileName  = FileUtils.readFileName(kb, "output");
      outf = FileUtils.openOutputFile(fileName);
      fout = new PrintStream(outf);
      FileUtils.displayFile(fin, fout);
      fin.close();
      fout.close();
      
      /* open the output file by reading the file name
         from the keyboard unitl a valid file is opened
         then pass that File object and create a new
         PrintStream
       */
      outf = FileUtils.openOutputFile("output1.txt");
      fout = FileUtils.openOutputFile(outf);
      
      /*
       * Read from the input file and write the output
       * to both the output file and the screen
       */
      inf = FileUtils.openInputFile("commandLine.txt");
      fin = new Scanner(inf);
      FileUtils.displayFile(fin, fout);
      FileUtils.displayFile(fin, System.out);
      fin.close();
      fout.close();

      kb.close();
   
   }// end main 

}// end class