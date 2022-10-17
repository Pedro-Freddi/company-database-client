package company.test;

import company.dao.EmployeeDAO;

public class EmployeeDeleteTest {

	public static void main(String[] args) {
		
		// Instantiate an employee data access object
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		// Delete the employee with an ID of 35
		employeeDAO.delete(35);
		
		System.out.println("Deleted successfully");

	}

}
