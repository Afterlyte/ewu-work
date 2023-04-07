/*******************************************************
Tester for the project
This file should be untouched except the DBname/user/passwd fields
By: Dan Li
*******************************************************/
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMyQuery {
        public static void main(String[] args) {                
            try {
                    Connection conn = getConnection();
                    MyQuery mquery = new MyQuery(conn);
                    
     					  // Query 0
                    mquery.findChargeDate();
                    mquery.printChargeDate();
						              
						  // Query 1
                    mquery.findBestOfficer();
                    mquery.printBestOfficer();

                    // Query 2
                    mquery.findCrimeCharge();
                    mquery.printCrimeCharge();
                  
                    // Query 3
                    mquery.findCriminal();
                    mquery.printCriminal();
                    
                    // Query 4
                    mquery.findCriminalSentence();
                    mquery.printCriminalSentence();
                  
                    // Query 5
                    mquery.findChargeCount();
                    mquery.printChargeCount();
						  
						  // Query 6
                    mquery.findEarliestLatest();
                    mquery.printEarliestLatest();
 					
						  // Query 7
						 mquery.findCrimeCounts();
				
                    conn.close();
            } catch (SQLException e) {
                    e.printStackTrace();
            }
            catch (IOException e) {
                    e.printStackTrace();
            }
        }
        
        public static Connection getConnection() throws SQLException{
            Connection connection; 
            try {
                    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            } catch (InstantiationException e1) {
                    e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                    e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
            }
            //Create a connection to the database
            String serverName = "localhost";
            String mydatabase = "crimeDB";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC url
            String username = "root";
            String password = "CocMc7sql"; //change needed
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
}
