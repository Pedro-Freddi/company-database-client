package company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/company_test",
					"company_manager", "password123");
			
		} catch(SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			
		}
		
		return connection;
		
	}
	
}
