package company.jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementsTest {

	public static void main(String[] args) {
		
		
		try {
			
			// Connect to the database
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/company_test",
					"company_manager",
					"password123");
			
			System.out.println("Connected to the database");
			
			Statement stmt = conn.createStatement();
			
			// Method to execute updates (INSERT, UPDATE, DELETE) on the database
			stmt.executeUpdate("INSERT INTO tab_employee VALUES (DEFAULT, 'Bruce Banner', 'bruce.banner@example.com', 10000, TO_DATE('2016-05-03', 'YYYY-MM-DD'));");
			stmt.executeUpdate("UPDATE tab_employee SET salary = 6000 WHERE employee_id = 1;");
			stmt.executeUpdate("DELETE FROM tab_employee WHERE name = 'Bruce Banner';");
			
			// Method to execute queries (SELECT)
			ResultSet rs = stmt.executeQuery("SELECT * FROM tab_employee;");
			System.out.println(rs);
			
			// Close connection to database
			conn.close();
			
		} catch (SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			
		}

	}

}
