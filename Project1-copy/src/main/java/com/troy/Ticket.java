package com.troy;

public class Ticket {
	private int transId;
	private int empId;
	private String rType;
	private double rAmount;
	private String status;
	
	public Ticket() {}
	
	public Ticket(int transId, int empId, String rType, double rAmount, String status) {
		this.transId = transId;
		this.empId = empId;
		this.rType = rType;
		this.rAmount = rAmount;
		this.status = status;
	}

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

	public String getrType() {
		return rType;
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

	@Override
	public String toString() {
		return "Ticket [transId=" + transId + ", empId=" + empId + ", rType=" + rType + ", rAmount=" + rAmount
				+ ", status=" + status + "]";
	}
	
	
	

}
