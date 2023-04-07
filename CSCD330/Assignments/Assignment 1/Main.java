/**
 * Ian Kaiserman
 * Assignment 1: Number Words
 * Converter for numbers into words, formatted like a check
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

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

    public static void main(String args[]) {
        if(args == null) {
            throw new IllegalArgumentException("Null arguments in program run");
        }
        double i = 0.0;
        String num = "";
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean done = false;
        // Loops in case there is an input error to allow user to insert valid number
        while(!done) {
            try {
                System.out.print("Enter a positive number: ");
                i = Double.parseDouble(input.readLine());
                if(i < 0.0 || i > Integer.MAX_VALUE || i > Double.MAX_VALUE) {
                    throw new IllegalArgumentException();
                }
                num = Double.toString(i);
                done = true;
            } catch (IllegalArgumentException f) {
                System.out.println("Negative numbers and numbers above the 32-bit integer/floating-point limit are not allowed.");
            } catch (Exception e) {
                System.out.println("Error while trying to read valid input");
            }
        }
        // Does some int/double/string conversion to separately process the whole dollars and coins separately
        // This way a second algorithm is not needed to process change (since it's a decimal and not an integer)
        double numDouble = Double.parseDouble(num);
        Integer wholeNum = (int) numDouble;
        int change = (int) Math.round((numDouble - wholeNum) * 100.0);
        String wholeNumString = wholeNum.toString();
        String convertedWhole = convertNumber(wholeNumString);
        String convertedChange = "";
        if(change != 0.0) {
            convertedChange = " and " + convertSection(Integer.toString(change)) + " hundredths";
        }
        else {
            convertedChange = " and zero hundredths";
        }
        System.out.println(convertedWhole + convertedChange);
    }
}