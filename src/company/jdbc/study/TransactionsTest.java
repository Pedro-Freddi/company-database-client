package company.jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionsTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		try {
			
			// Connect to the database
			conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/company_test",
					"company_manager",
					"password123");
			
			System.out.println("Connected to the database");
			
			// Turn autocommit off
			conn.setAutoCommit(false);
			
			/*
			 * Transaction
			 */
	
			// Prepare and execute first statement
			PreparedStatement stmt = conn.prepareStatement("UPDATE tab_employee SET salary = salary - 1500 WHERE employee_id = ?;");
			stmt.setInt(1, 2);
			stmt.executeUpdate();
			stmt.close();
			
			// Prepare and execute second statement
			PreparedStatement stmt2 = conn.prepareStatement("UPDATE tab_employee SET salary = salary + 1500 WHERE employee_id = ?;");
			stmt2.setInt(1, 3);
			stmt2.executeUpdate();
			stmt2.close();
			
			// Commit the transaction
			conn.commit();
			
			System.out.println("Transaction successful");
			
			// Close connection to database
			conn.close();
			
		} catch (SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			try {
				
				conn.rollback();
				
			} catch (SQLException e1) {
				
				System.err.println("Rollback error: " + e1.getMessage());
				e1.printStackTrace();
				
			}
			
		}

	}

}
