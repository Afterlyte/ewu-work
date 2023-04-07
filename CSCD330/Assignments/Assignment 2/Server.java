/**
 * Ian Kaiserman
 * CSCD 330
 * Assignment 2: Number Conversion Client-Server
 * Converter for numbers into words, formatted like a check
 * Uses Client-Server structure for data transfer and calculation
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server { // Server class for the number to words converter

    // The main function used to convert the number. Splits each "section of a number" (normally separated by commas) and has convertSection()
    // convert those individually, then splices the sections together.

    public static String convertNumber(String num) {
        // Handles zero specifically (would return empty if handled by convertSection)
        if(Integer.parseInt(num) == 0) {
            return "zero";
        }
        String numInWords = "";
        // For values of at least one billion
        if(num.length() > 9) {
            numInWords += convertSection(num.substring(0, num.length() - 9)) + " billion ";
            num = num.substring(num.length() - 9, num.length());
        }
        while(!num.isEmpty() && num.charAt(0) == '0') {
            num = num.substring(1, num.length());
        }
        // For values of at least one million
        if(num.length() > 6) {
            numInWords += convertSection(num.substring(0, num.length() - 6)) + " million ";
            num = num.substring(num.length() - 6, num.length());
        }
        while(!num.isEmpty() && num.charAt(0) == '0') {
            num = num.substring(1, num.length());
        }
        // For values of at least one thousand
        if(num.length() > 3) {
            numInWords += convertSection(num.substring(0, num.length() - 3)) + " thousand ";
            num = num.substring(num.length() - 3, num.length());
        }
        // Converts the last set of digits
        numInWords += convertSection(num);        
        return numInWords;
    }

    // Takes in strings of three characters each, converts them into words, then returns them to be used by convertNumber.

    public static String convertSection(String num) {
        if(num.isEmpty() || Integer.parseInt(num) == 0) {
            return "";
        }
        // Checks for and filters out leading zeros
        if(num.charAt(0) == '0') {
            num = num.substring(1, num.length());
        }
        String section = "";

        // Arrays of words to be used by the algorithm for convenience and efficiency

        String[] underTen = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] underTwenty = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tenMultiples = new String[]{"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        // For values of at least 100
        if(Integer.parseInt(num) > 99) {
            section += underTen[Character.getNumericValue(num.charAt(0))] + " hundred ";
            num = num.substring(1, num.length());
        }
        // For values of at least 10
        if(Integer.parseInt(num) > 9) {
            // Handles special words under 20
            if(Integer.parseInt(num) < 20) {
                section += underTwenty[Integer.parseInt(num) % 10];
                return section;
            }
            else {
                section += tenMultiples[Integer.parseInt(num) / 10 - 2];
                if(num.charAt(1) != '0') {
                    section += "-";
                }
                else {
                    return section;
                }
            }
            num = num.substring(1, num.length());
        }
        // Adds units place words for each section
        if(Integer.parseInt(num) != 0) {
            section += underTen[Integer.parseInt(num)];
        }
        // Removes the extra space inserted if the units place is a zero
        else {
            section = section.substring(0, section.length() - 1);
        }
        return section;
    }

    // Helper method for obtaining, formatting, and error checking data, along with applicable error messages and looping

    public static String getInput(BufferedReader input, PrintWriter output) {
        String num = "";
        boolean done = false;
        Double d = 0.0;
        while(!done) {
            try {
                num = input.readLine().trim();
                if(num.equals("00")) {
                    return "-1"; // This -1 is used as a definitive check for if the user wants to quit, to prevent the 00 from conflicting with attempted calculations
                }
                d = Double.parseDouble(num);
                if(d < 0.0) {
                    output.println("Negative numbers are not allowed. Please try again.");
                    System.out.println("User entered a negative number, reprompting...");
                } else if(d > Integer.MAX_VALUE) {
                    output.println("Numbers larger than the largest 32-bit signed integer are not allowed. Please try again.");
                    System.out.println("User entered a number that is too large, reprompting...");
                } else {
                    done = true;
                }
            } catch(IOException e) {
                System.out.println("Error fetching input from input buffer.");
                break;
            } catch(NullPointerException e) {
                System.out.println("The string passed into checkInput is null.");
            } catch(NumberFormatException e) {
                output.println("You didn't enter a number. Please try again.");
                System.out.println("User entered a non-number, reprompting...");
            } catch(IllegalArgumentException e) {
                output.println(e);
            }
        }
        return Double.toString(d);
    }

    public static void main(String[] args) {
        // Waits for a client socket connection on port 8000
        System.out.println("Starting server on port 8000");
        try (
            ServerSocket server = new ServerSocket(8000);
        ) {
            while(true) {
                try (
                    Socket client = server.accept();
                    PrintWriter output = new PrintWriter(client.getOutputStream(), true);
                    BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                ) {
                    System.out.println("Socket connected. Servicing requests to " + client.toString());
                    while(true) {
                        String num = getInput(input, output);
                        if(num.equals("-1")) { // Called if the user inputs the pattern to quit the program, see getInput method above
                            System.out.println("Quit pattern entered by user, exiting.");
                            output.println("Thank you, come again!");
                            break;
                        }
                        System.out.println("Successfully received input " + num + " from user input. Converting...");
                        double d = Double.parseDouble(num);
                        int change = (int)Math.round((d-(int)d) * 100);
                        String convertedWhole = convertNumber(Integer.toString((int)d));
                        String convertedChange = "";
                        if(change != 0.0) {
                            convertedChange = " and " + convertSection(Integer.toString(change)) + " hundredths";
                        }
                        else {
                            convertedChange = " and zero hundredths";
                        }
                        output.println("Here is " + num + " in english words: " + convertedWhole + convertedChange);
                        System.out.println(num + " successfully converted and sent back to client.");
                    }
                } catch(IOException i) {
                    System.out.println("Error creating server socket on port 8000. Aborting.");
                } catch(Exception e) {
                    System.out.println("Unknown error in main method");
                }
            }
        } catch(IOException e) {
            System.out.println("Error starting server on port 8000. Aborting.");
        }
    }
}