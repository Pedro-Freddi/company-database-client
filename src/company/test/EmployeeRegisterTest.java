package company.test;

import java.util.Calendar;

import company.bean.Employee;
import company.dao.EmployeeDAO;

public class EmployeeRegisterTest {

	public static void main(String[] args) {
		
		// Create an employee object
		Employee employee = new Employee();
		employee.setName("Tony Stark");
		employee.setEmail("tony.stark@example.com");
		employee.setSalary(18000);
		employee.setHireDate(Calendar.getInstance());
		
		// Create an employee data access object (DAO)
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		// Call the employee DAO's register method and pass the
		// employee object as an argument
		employeeDAO.register(employee);
		
		System.out.println("Employee registered successfully");

	}

}
