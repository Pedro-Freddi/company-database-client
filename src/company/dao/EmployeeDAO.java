package company.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import company.bean.Employee;
import company.database.DatabaseManager;

public class EmployeeDAO {

	// Attribute to store the connection to the database
	private Connection connection;
	
	// Method to register a new employee
	public void register(Employee employee) {
		
		PreparedStatement stmt = null;
		
		try {
			
			// Establish the connection to the database
			connection = DatabaseManager.getConnection();
			
			// Define the SQL query and prepare a statement
			String sqlQuery = "INSERT INTO tab_employee(employee_id, name, email, salary, hire_date) VALUES (DEFAULT, ?, ?, ?, ?);";
			stmt = connection.prepareStatement(sqlQuery);
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getEmail());
			stmt.setDouble(3, employee.getSalary());
			stmt.setDate(4, new Date(employee.getHireDate().getTimeInMillis()));
			
			// Execute the update
			stmt.executeUpdate();
			
			
		} catch(SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			
		} finally {
			
			try {
				
			// Close the statement
			stmt.close();
			
			// Close the connection to the database
			connection.close();
			
			} catch(SQLException e) {
				
				System.err.println("SQL Error: " + e.getMessage());
				e.printStackTrace();
				
			}

		}

	}
	
	// Method to get a list of all employees
	public List<Employee> getAll() {
		
		// Create a list that will contain employee objects
		List<Employee> list = new ArrayList<Employee>();
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			// Connect to the database
			connection = DatabaseManager.getConnection();
			
			// Create a prepared statement to select all employees
			stmt = connection.prepareStatement("SELECT * FROM tab_employee;");
			rs = stmt.executeQuery();
			
			// Iterate through the results, instantiate employee objects and store them in the list
			while (rs.next()) {
				
				int id = rs.getInt("employee_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				double salary = rs.getDouble("salary");
				Date date = rs.getDate("hire_date");
				Calendar hireDate  = Calendar.getInstance();
				hireDate.setTimeInMillis(date.getTime());
				
				Employee employee = new Employee(id, name, email, salary, hireDate);
				
				list.add(employee);
				
			}
			
			
			
		} catch(SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			
		} finally {
			
			try {
			
			// Close the statement
			stmt.close();
			
			// Close the result set
			rs.close();
			
			// Close the connection to the database
			connection.close();
			
			} catch(SQLException e) {
				
				System.err.println("SQL Error: " + e.getMessage());
				e.printStackTrace();
				
			}
			
		}
		
		return list;
		
	}
	
	// Method to get a specific employee by Id
	public Employee getById(int id) {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Employee employee = null;
		
		try {
			
			// Connect to the database
			connection = DatabaseManager.getConnection();
			
			// Prepare a statement and execute
			String sqlQuery = "SELECT * FROM tab_employee WHERE employee_id = ?;";
			stmt = connection.prepareStatement(sqlQuery);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				int employee_id = rs.getInt("employee_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				double salary = rs.getDouble("salary");
				Date date = rs.getDate("hire_date");
				Calendar hireDate  = Calendar.getInstance();
				hireDate.setTimeInMillis(date.getTime());
				
				employee = new Employee(employee_id, name, email, salary, hireDate);
				
			}
			
		} catch(SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			
		} finally {
			
			try {
				
			// Close the statement
			stmt.close();
			
			// Close the result set
			rs.close();
			
			// Close the connection to the database
			connection.close();
			
			} catch(SQLException e) {
				
				System.err.println("SQL Error: " + e.getMessage());
				e.printStackTrace();
				
			}
			
		}
		
		return employee;
		
	}
	
	// Method to update an employee
	public void update(Employee employee) {
		
		PreparedStatement stmt = null;
		
		try {
			
			// Connect to the database
			connection = DatabaseManager.getConnection();
			
			// Prepare statement and execute update
			String sqlQuery = "UPDATE tab_employee SET name = ?, email = ?, salary = ?, hire_date = ? WHERE employee_id = ?;";
			stmt = connection.prepareStatement(sqlQuery);
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getEmail());
			stmt.setDouble(3, employee.getSalary());
			stmt.setDate(4, new Date(employee.getHireDate().getTimeInMillis()));
			stmt.setInt(5, employee.getId());
			
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			
		} finally {
			
			try {
				
			// Close the statement
			stmt.close();
			
			// Close the connection to the database
			connection.close();
			
			} catch(SQLException e) {
				
				System.err.println("SQL Error: " + e.getMessage());
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	// Method to delete an employee
	public void delete(int id) {
		
		PreparedStatement stmt = null;
		
		try {
			
			// Connect to the database
			connection = DatabaseManager.getConnection();
			
			// Create a prepared statement to delete an employee by Id
			String sqlQuery = "DELETE FROM tab_employee WHERE employee_id = ?;";
			stmt = connection.prepareStatement(sqlQuery);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			
			System.err.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			
		} finally {
			
			try {
			
			// Close the statement
			stmt.close();
			
			// Close the connection to the database
			connection.close();
				
			} catch(SQLException e) {
				
				System.err.println("SQL Error: " + e.getMessage());
				e.printStackTrace();
				
			}
			
		}
		
	}
	
}
