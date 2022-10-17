package company.jdbc.study;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementsTest {

	public static void main(String[] args) {
		
		try {
			
			// Connect to the database
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/company_test",
					"company_manager",
					"password123");
			
			System.out.println("Connected to the database");
			
			// Create callable statement
			CallableStatement cs = conn.prepareCall("call sp_update_employee_salary(?, ?)");
			
			// Set parameters and execute the update
			cs.setInt(1, 3);
			cs.setInt(2, 7000);
			cs.executeUpdate();
			cs.close();
			
			// Close the connection to database
			conn.close();
			
		} catch (SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
		
		}

	}

}
