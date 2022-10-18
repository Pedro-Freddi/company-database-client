package company.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import company.bean.Employee;
import company.dao.EmployeeDAO;

public class UserInterface {
	
	private Scanner sc = new Scanner(System.in);
	private EmployeeDAO employeeDAO = new EmployeeDAO();

	public void printWelcomeMessage() {
		
		System.out.println("\n===== EMPLOYEE DATABASE CRUD CLIENT =====\n");
		System.out.println("Welcome!\n");
		
	}
	
	public void printMenuOptions() {
		
		System.out.println("Available operations:\n");
		System.out.println("1. List all employee records");
		System.out.println("2. Get an employee record by ID");
		System.out.println("3. Register a new employee");
		System.out.println("4. Update employee record");
		System.out.println("5. Delete an employee record");
		System.out.println("6. Exit application");
		
	}
	
	public void printGoodbyeMessage() {
		
		sc.close();
		System.out.println("\n=======================");
		System.out.println("Exiting application...");
		System.out.println("=======================");
		
	}
	
	public int getUserMenuOption() {
		
		System.out.println("\nInput operation number or 9 to print the options menu: ");
	
		int option = 0;
		
		try {
			
			option = sc.nextInt();
			
		} catch(InputMismatchException e) {
			
			System.err.println("Invalid operation");
			return -1;
			
		} catch (Exception e) {
			
			System.err.println("Error: " + e.getMessage());
			System.out.println("Please restart the application");
			
		}
		
		return option;
		
	}
	
	public void printAllEmployees() {
		
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
	
	public void printEmployeeById() {
		
		int id = 0;
		
		System.out.println("\nInput the employee ID: ");
		
		try {
			
			id = sc.nextInt();
			
		} catch (InputMismatchException e) {
			
			System.err.println("Invalid ID, please try again.");
			return;
			
		}
		
		Employee employee = employeeDAO.getById(id);
		
		if (employee != null) {
			
			System.out.println("\nFound!");
			System.out.println("\n=================\n");
			System.out.println("Id: " + employee.getId());
			System.out.println("Name: " + employee.getName());
			System.out.println("Email: " + employee.getEmail());
			System.out.println("Salary: " + employee.getSalary());
			System.out.println("Hire Date: " + employee.getHireDate().getTime());
			
		} else {
			
			System.out.println("No employee found for that Id");
			
		}
		
	}
	
	public void registerEmployee() {
		
		System.out.println("\n===== Register a new employee =====\n");
		
		String name = null;
		String email = null;
		double salary = 0;
		String hireDate = null;
		
		try {
			
			System.out.println("Name: ");
			name = sc.next();
			
			System.out.println("E-mail: ");
			email = sc.next();
			
			System.out.println("Salary: ");
			salary = sc.nextDouble();
			
			System.out.println("Hire date (YYYY-MM-DD): ");
			hireDate = sc.next();
			
			
		} catch (InputMismatchException e) {
			
			System.err.println("Invalid input, try again");
			return;
			
		}
		
		Employee employee = new Employee();
		
		if (name != null && email != null && salary != 0 && hireDate != null) {
			employee.setName(name);
			employee.setEmail(email);
			employee.setSalary(salary);
			try {
				Date parsedDate = new SimpleDateFormat("YYYY-MM-DD").parse(hireDate);
				Calendar date = Calendar.getInstance();
				date.setTimeInMillis(parsedDate.getTime());
				employee.setHireDate(date);
			} catch (ParseException e) {
				System.err.println("Invalid date");
				e.printStackTrace();
				return;
			}
			employeeDAO.register(employee);
			System.out.println("\nEmployee registered successfully\n");
			
		} else {
			
			System.err.println("Something went wrong, please try again");
			
		}
		
	}
	
	public void updateEmployee() {
		
		System.out.println("\n===== Update employee record =====\n");
		
		int id = 0;
		String name = null;
		String email = null;
		double salary = 0;
		String hireDate = null;
		Employee employee = null;
		
		try {
			
			System.out.println("Employee ID to update: ");
			id = sc.nextInt();
			
			employee = employeeDAO.getById(id);
			
			if (employee != null) {
			
				System.out.println("Name: ");
				name = sc.next();
			
				System.out.println("E-mail: ");
				email = sc.next();
			
				System.out.println("Salary: ");
				salary = sc.nextDouble();
			
				System.out.println("Hire date (YYYY-MM-DD): ");
				hireDate = sc.next();
				
				if (name != null && email != null && salary != 0 && hireDate != null) {
					employee.setName(name);
					employee.setEmail(email);
					employee.setSalary(salary);
					try {
						Date parsedDate = new SimpleDateFormat("YYYY-MM-DD").parse(hireDate);
						Calendar date = Calendar.getInstance();
						date.setTimeInMillis(parsedDate.getTime());
						employee.setHireDate(date);
					} catch (ParseException e) {
						System.err.println("Invalid date");
						e.printStackTrace();
						return;
					}
					employeeDAO.update(employee);
					System.out.println("\nEmployee updated successfully");
					
				} else {
					
					System.err.println("Something went wrong, please try again");
					return;
					
				}
				
			} else {
				
				System.out.println("No employee found for that ID");
				
			}
			
		} catch (InputMismatchException e) {
			
			System.err.println("Invalid input, try again");
			
		}
		
	}
	
	public void deleteEmployee() {
		
		int id = 0;
		
		try {
			
			System.out.println("Employee ID to delete: ");
			id = sc.nextInt();
			
			employeeDAO.delete(id);
			
		} catch (InputMismatchException e) {
			
			System.err.println("Invalid input, try again");
			
		}
		
		System.out.println("Successful operation");
		
	}
	
}
