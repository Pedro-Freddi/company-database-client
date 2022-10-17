package company.test;

import company.bean.Employee;
import company.dao.EmployeeDAO;

public class EmployeeGetByIdTest {

	public static void main(String[] args) {
		
		Employee employee = new EmployeeDAO().getById(3);
		
		if (employee != null) {
			
			System.out.println("Id: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Email: " + employee.getEmail());
			System.out.println("Salary: " + employee.getSalary());
			System.out.println("Hire Date: " + employee.getHireDate().getTime() + "\n");
			
		} else {
			
			System.out.println("No employee found for that Id");
			
		}
				
	}

}
