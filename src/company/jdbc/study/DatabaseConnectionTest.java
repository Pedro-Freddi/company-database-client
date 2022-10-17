package company.jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {

	public static void main(String[] args) {

		try {
			
			// Register the driver
			// Note: this step is not required for this postgres driver in 
			// particular but it's being made explicit for learning purposes
			Class.forName("org.postgresql.Driver");
			
			// Open a connection
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/company_test", 
					"company_manager", 
					"password123");
			
			System.out.println("Connection established!");
			
			// Close the connection
			conn.close();
			
		} catch (ClassNotFoundException e) {
			
			System.err.println("Class Error: " + e.getMessage());
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
