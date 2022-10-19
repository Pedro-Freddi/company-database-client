package company.test;

import company.bean.Employee;
import company.dao.EmployeeDAO;

public class EmployeeGetByIdTest {

	public static void main(String[] args) {
		
		Employee employee = new EmployeeDAO().getById(3);
		
		if (employee != null) {
			
			System.out.println(employee);
			
		} else {
			
			System.out.println("No employee found for that Id");
			
		}
				
	}

}
