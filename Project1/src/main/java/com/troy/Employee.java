package com.troy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
//@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	@Column(name ="firstname")
	private String firstName;
	@Column(name ="lastname")
	private String lastName;
	private String email;
	private String username;
	private String password;
	@Column(name = "reimbursement_total")
	private double rTotal;
	@Column(name = "emp_status")
	private String status;
	
	public Employee() {}
	
	public Employee(int empId, String firstName, String lastName, String email, String username, String password, double rTotal, String status) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.rTotal = rTotal;
		this.status = status;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getrTotal() {
		return rTotal;
	}

	public void setrTotal(double rTotal) {
		this.rTotal = rTotal;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", username=" + username + ", password=" + password + ", rTotal="
				+ rTotal + ", status=" + status + "]";
	}

	
	
	
	
}
