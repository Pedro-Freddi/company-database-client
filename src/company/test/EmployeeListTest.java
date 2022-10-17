package company.test;

import java.util.Date;
import java.util.List;

import company.bean.Employee;
import company.dao.EmployeeDAO;

public class EmployeeListTest {

	public static void main(String[] args) {
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		
		List<Employee> employeeList = employeeDAO.getAll();
		for (Employee employee : employeeList) {
			
			int id = employee.getId();
			String name = employee.getName();
			String email = employee.getEmail();
			double salary = employee.getSalary();
			Date hireDate = employee.getHireDate().getTime();
			
			System.out.println("==========\n");
			System.out.println("Id: " + id);
			System.out.println("Name: " + name);
			System.out.println("Email: " + email);
			System.out.println("Salary: " + salary);
			System.out.println("Hire Date: " + hireDate + "\n");
			
		}

	}

}
