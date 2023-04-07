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
import java.net.Socket;

public class Client { // Client class for the number to words converter
    public static void main(String[] args) {
        try ( // Attempts to connect to server application on the localhost on port 8000
            Socket server = new Socket("localhost", 8000);
            PrintWriter output = new PrintWriter(server.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(server.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ) { // Data retrieval and sending specifically set up for the number of inputs/outputs that are needed to keep the applications synchronized
            while(true) {
                System.out.print("Please enter a positive number: ");
                String str = keyboard.readLine();
                output.println(str);
                if(str.equals("00")) {
                    System.out.println(input.readLine());
                    break;
                }
                System.out.println(input.readLine());
                System.out.println();
            }
            
        } catch(IOException e) {
            System.out.println("Error creating one or more buffers and/or socket. Aborting.");
        }
    }
}
