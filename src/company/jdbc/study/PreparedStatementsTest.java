package company.jdbc.study;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementsTest {

	public static void main(String[] args) {
		
		try {
		
			// Connect to the database
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/company_test",
					"company_manager",
					"password123");
			
			System.out.println("Connected to the database");
			
			// Create a prepared statement for insertion into the table
			PreparedStatement pInsStmt = conn.prepareStatement("INSERT INTO tab_employee VALUES (DEFAULT, ?, ?, ?, ?);");
			// Set parameters
			pInsStmt.setString(1, "Bruce Banner"); // First query param
			pInsStmt.setString(2, "bruce.banner@example.com"); // Second query param
			pInsStmt.setDouble(3, 10000); // Third query param
			Date hireDate = new Date(new java.util.Date().getTime()); 
			pInsStmt.setDate(4, hireDate); // Fourth query param
			pInsStmt.executeUpdate();
			pInsStmt.close();
			
			// Create a prepared statement for update
			PreparedStatement pUpdStmt = conn.prepareStatement("UPDATE tab_employee SET salary = salary + 1500 WHERE name = ?;");
			pUpdStmt.setString(1, "Bruce Wayne");
			pUpdStmt.executeUpdate();
			pUpdStmt.close();
			
			// Create a prepared statement for deletion
			PreparedStatement pDelStmt = conn.prepareStatement("DELETE FROM tab_employee WHERE name = ?;");
			pDelStmt.setString(1, "Bruce Banner");
			pDelStmt.executeUpdate();
			pDelStmt.close();
			
			// Create a prepared statement for a query
			PreparedStatement pSelStmt = conn.prepareStatement("SELECT * FROM tab_employee WHERE employee_id = ?;");
			pSelStmt.setInt(1, 2);
			ResultSet pRs = pSelStmt.executeQuery();
			System.out.println(pRs);
			
			// Close connection to database
			conn.close();
		
		} catch (SQLException e) {
		
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
		
	  }

	}

}
