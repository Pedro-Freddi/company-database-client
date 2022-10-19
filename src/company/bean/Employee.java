package company.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employee implements Serializable {

	// Attributes
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String email;
	private double salary;
	private Calendar hireDate;
	
	// Constructors
	public Employee() {
		super();
	}
	
	public Employee(int id, String name, String email, double salary, Calendar hireDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	
	
	// Getter and Setter Methods
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Calendar getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}
	
	// Overwritten toString method from Serializable interface
	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		
		return "Employee [id = " + id
				+ ", name = " + name
				+ ", email = " + email
				+ ", salary = " + salary
				+ ", hire date = " + sdf.format(hireDate.getTime())
				+ "]";
		
	}
	
}
