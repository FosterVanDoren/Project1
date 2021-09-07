package com.troy;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//@Table(name ="tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="trans_id", updatable = false, nullable = false)
	private int transId;
	
	@Column(name = "emp_id")
//	private List<Employee> employees;
	private int empId;
	@Column(name ="reimbursement_type")
	private String rType;
	private Date date;
	@Column(name = "reimburse_reason")
	private String rReason;
	@Column(name ="reimburse_amount")
	private double rAmount;
	private String status;
	
	public Ticket() {}
	
	public Ticket(int transId, int empId, String rType, Date date, double rAmount, String status) {
		this.transId = transId;
		this.empId = empId;
		this.rType = rType;
		this.rAmount = rAmount;
		this.status = status;
	}
//	public Ticket(int transId, List<Employee> employees, String rType, Date date, double rAmount, String status) {
//		this.transId = transId;
//		this.employees = employees;
//		this.rType = rType;
//		this.rAmount = rAmount;
//		this.status = status;
//	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
//	public List<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}

	public String getrType() {
		return rType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getrReason() {
		return rReason;
	}

	public void setrReason(String rReason) {
		this.rReason = rReason;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	public double getrAmount() {
		return rAmount;
	}

	public void setrAmount(double rAmount) {
		this.rAmount = rAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	@Override
//	public String toString() {
//		return "Ticket [transId=" + transId + ", employees=" + employees + ", rType=" + rType + ", date=" + date
//				+ ", rReason=" + rReason + ", rAmount=" + rAmount + ", status=" + status + "]";
//	}

	@Override
	public String toString() {
		return "Ticket [transId=" + transId + ", empId=" + empId + ", rType=" + rType + ", date=" + date + ", rReason="
				+ rReason + ", rAmount=" + rAmount + ", status=" + status + "]";
	}

	
	
	
	
	

}
