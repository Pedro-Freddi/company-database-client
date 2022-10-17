package company.test;

import company.bean.Employee;
import company.dao.EmployeeDAO;

public class EmployeeUpdateTest {

	public static void main(String[] args) {
		
		// Instantiate an employee data access object
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		// Get employee with Id of 1 and raise salary by 1500
		Employee employee = employeeDAO.getById(1);
		Double salary = employee.getSalary();
		employee.setSalary(salary + 1500);
		
		// Persist the updated employee object to the database
		employeeDAO.update(employee);

	}

}
