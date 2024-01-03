package com.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Comparable<Customer>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6445660374873371327L;
	private int custId;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private double regesterAmount;
	private LocalDate dob;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private Plan plan;
	private static int count;

	static {
		count = 1001;
	}

	public Customer(String fName, String lName, String email, String password, double regesterAmount, LocalDate dob,
			LocalDate planStartDate, LocalDate planEndDate, Plan plan) {
		// super();
		this.custId = count++;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.regesterAmount = regesterAmount;
		this.dob = dob;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.plan = plan;

	}

	
	public void setCustId(int custId) {
		this.custId = custId;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public static void setCount(int count) {
		Customer.count = count;
	}


	public void setRegesterAmount(double regesterAmount) {
		this.regesterAmount = regesterAmount;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCustId() {
		return custId;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public double getRegesterAmount() {
		return regesterAmount;
	}

	public LocalDate getDob() {
		return dob;
	}

	public Plan getPlan() {
		return plan;
	}

	public static int getCount() {
		return count;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			return this.getEmail().equals(((Customer) o).getEmail());
		} else
			return false;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", fName=" + fName + ", lName=" + lName + ", email=" + email
				+ ", regesterAmount=" + regesterAmount + ", dob=" + dob + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", plan=" + plan + "]";
	}

	@Override
	public int compareTo(Customer o) {

		return this.getEmail().compareTo(o.getEmail());
	}

}
