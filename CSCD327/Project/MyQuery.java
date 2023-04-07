/*****************************
Query the Crime Database
*****************************/
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Date;
import java.util.Scanner;

public class MyQuery {

   private Connection conn = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
    
    public MyQuery(Connection c)throws SQLException
    {
        conn = c;
        statement = conn.createStatement();
    }
    
	 //Query 0: this is a sample query provided by Dr. Li
	 public void findChargeDate() throws SQLException
    {
        String query  = "SELECT crime_id, date_charged " +
                            "FROM crimes " + 
                            "WHERE date_charged <= \'2008-10-22\';";

        resultSet = statement.executeQuery(query);
    }
    
    public void printChargeDate() throws IOException, SQLException
    {
		System.out.println("******** Query 0 ********");
		System.out.println("Crime_ID\t"+"Charge_Date");

        while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getString(2);
			int crime_id = resultSet.getInt(1);
			Date charge_date = resultSet.getDate("date_charged");
			System.out.println(crime_id+"\t\t"+charge_date);
		}        
    }

	 //Query 1
    public void findBestOfficer() throws SQLException
    {
     String query = "SELECT first, last, COUNT(crime_id) cnt\n"
     		+ "FROM crimes JOIN crime_officers USING (crime_id) JOIN officers USING (officer_id)\n"
     		+ "GROUP BY officer_id HAVING COUNT(crime_id) > (\n"
     		+ "	SELECT AVG(count)\n"
     		+ "    FROM (SELECT COUNT(crime_id) count FROM crimes JOIN crime_officers USING (crime_id) JOIN officers USING (officer_id)\n"
     		+ "		GROUP BY (officer_id)\n"
     		+ "	) sub\n"
     		+ ");";
     resultSet = statement.executeQuery(query);
	 }
    
    public void printBestOfficer() throws IOException, SQLException
    {
		System.out.println("******** Query 1 ********");
		System.out.println("First\t"+"Last\t"+"cnt");
		
		while(resultSet.next()) {
			String first = resultSet.getString("first");
			String last = resultSet.getString("last");
			int cnt = resultSet.getInt("cnt");
			System.out.println(first+"\t"+last+"\t"+cnt);
		}
		 
	 }


	 //Query 2
    public void findCrimeCharge() throws SQLException
    {
    	String query = "SELECT charge_id\n"
    			+ "FROM crime_charges\n"
    			+ "WHERE fine_amount > (\n"
    			+ "	SELECT AVG(fine_amount)\n"
    			+ "    FROM crime_charges\n"
    			+ ") AND amount_paid < (\n"
    			+ "	SELECT AVG(amount_paid)\n"
    			+ "    FROM crime_charges\n"
    			+ ");";
    	resultSet = statement.executeQuery(query);
    }

    public void printCrimeCharge() throws IOException, SQLException
    {
		System.out.println("******** Query 2 ********");
		System.out.println("charge_id");
		
		while(resultSet.next()) {
			int chargeID = resultSet.getInt("charge_id");
			System.out.println(chargeID);
		}
    }


	 //Query 3
    public void findCriminal() throws SQLException
    {
    	String query = "SELECT DISTINCT first, last\n"
    			+ "FROM criminals JOIN crimes USING (criminal_id) JOIN crime_charges USING (crime_id)\n"
    			+ "WHERE crime_code = ANY(\n"
    			+ "	SELECT crime_code\n"
    			+ "    FROM crime_charges\n"
    			+ "    WHERE crime_id = 10089\n"
    			+ ");";
    	resultSet = statement.executeQuery(query);
    }

    public void printCriminal() throws IOException, SQLException
    {
		System.out.println("******** Query 3 ********");
		System.out.println("first\tlast");
		
		while(resultSet.next()) {
			String first = resultSet.getString("first");
			String last = resultSet.getString("last");
			System.out.println(first+"\t"+last);
		}
    }


	 //Query 4
    public void findCriminalSentence() throws SQLException
    {
    	String query = "SELECT criminal_id, last, first, COUNT(sentence_id) cnt_sentence\n"
    			+ "FROM criminals JOIN sentences USING (criminal_id)\n"
    			+ "GROUP BY criminal_id\n"
    			+ "HAVING COUNT(sentence_id) > 1;";
    	resultSet = statement.executeQuery(query);
    }

    public void printCriminalSentence() throws IOException, SQLException
    {
		System.out.println("******** Query 4 ********");
		System.out.println("criminal_id\tlast\tfirst\tcnt_sentence");
		
		while(resultSet.next()) {
			int criminalID = resultSet.getInt("criminal_id");
			String last = resultSet.getString("last");
			String first = resultSet.getString("first");
			int cntSentence = resultSet.getInt("cnt_sentence");
			System.out.println(criminalID+"\t\t"+last+"\t"+first+"\t"+cntSentence);
		}
    }


	 //Query 5
    public void findChargeCount() throws SQLException
    {
    	String query = "SELECT precinct, COUNT(charge_id) charge_cnt\n"
    			+ "FROM crime_charges JOIN crime_officers USING (crime_id) JOIN officers USING (officer_id)\n"
    			+ "WHERE charge_status = 'GL'\n"
    			+ "GROUP BY precinct\n"
    			+ "HAVING COUNT(charge_id) >= 7;";
    	resultSet = statement.executeQuery(query);
    }

    public void printChargeCount() throws IOException, SQLException
    {
		System.out.println("******** Query 5 ********");
		System.out.println("precinct\tcharge_cnt");
		
		while(resultSet.next()) {
			String precinct = resultSet.getString("precinct");
			int chargeCount = resultSet.getInt("charge_cnt");
			System.out.println(precinct+"\t\t"+chargeCount);
		}
    }
	 
	 
	 //Query 6
	  public void findEarliestLatest() throws SQLException
    {
		  String query = "SELECT criminal_id, first, last, MIN(start_date) earliest_start_date, MAX(end_date) latest_end_date\n"
		  		+ "FROM sentences JOIN criminals USING (criminal_id)\n"
		  		+ "GROUP BY (criminal_id);";
		  resultSet = statement.executeQuery(query);
    }

    public void printEarliestLatest() throws IOException, SQLException
    {
		System.out.println("******** Query 6 ********");
		System.out.println("criminal_id\tfirst\tlast\t\tearliest_start_date\tlatest_end_date");
		
		while(resultSet.next()) {
			int criminalID = resultSet.getInt("criminal_id");
			String first = resultSet.getString("first");
			String last = resultSet.getString("last");
			Date earliest = resultSet.getDate("earliest_start_date");
			Date latest = resultSet.getDate("latest_end_date");
			System.out.println(criminalID+"\t\t"+first+"\t"+last+"\t\t"+earliest+"\t"+latest);
		}
       
    }
	

	 //Query 7
    public void findCrimeCounts() throws SQLException
    {
		System.out.println("******** Query 7 ********");	
		System.out.println("Please enter the officer_id for the query:");
		Scanner kb = new Scanner(System.in);
		int officerID = kb.nextInt();
		CallableStatement procall = conn.prepareCall("{CALL GetNumber (?, ?)}");
		procall.setInt(1, officerID);
		procall.registerOutParameter(2, Types.INTEGER);
		procall.execute();
		int crimeCount = procall.getInt(2);
		System.out.print("Officer "+officerID+" has reported "+crimeCount);
		if(crimeCount == 1) {
			System.out.println(" crime.");
		}
		else {
			System.out.println(" crimes.");
		}
		kb.close();
    }

}
