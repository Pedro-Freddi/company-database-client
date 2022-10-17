package company.jdbc.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {

	public static void main(String[] args) {
		
		try {
			
			// Connect to the database
			Connection conn = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/company_test",
					"company_manager",
					"password123");
			
			System.out.println("Connected to the database");
			
			// Create a statement
			Statement stmt = conn.createStatement();
			// Execute query and store result set
			ResultSet rs = stmt.executeQuery("SELECT * FROM tab_employee;");
			
			while (rs.next()) {
				
				int id = rs.getInt("employee_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				String hireDate = rs.getDate("hire_date").toString();
				
				System.out.println(id + ", " + name + ", " + email + ", " + salary + ", " + hireDate);
				
			}
			
			// Close connection to database
			conn.close();
			
		} catch (SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			
		}
		
	}
	
}
