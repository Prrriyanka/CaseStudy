package com.cg.casestudy.beans;


import java.lang.invoke.StringConcatException;
import java.util.Objects;

public class Customer {
	private int id;
	private String userName;
	private String password;
	private String email;
	private String phoneNo;
	private String role;
	private boolean accisBlocked;
	private int totalAttempts;

	
	
	public Customer() {	}	
	
	

	
	public Customer(int id, String userName, String password, String email, String phoneNo) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
	}


	
	public Customer(String userName, String password, String email, String phoneNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
	}





	public Customer(int id, String userName, String password, String email, String phoneNo, String role,
			boolean accisBlocked) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.role = role;
		this.accisBlocked = accisBlocked;
	}




	public Customer(int id, String userName, String password, String email, String phoneNo, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.role = role;
	}
	
	

	public Customer(int id, String userName, String password, String email, String phoneNo, String role,
			boolean accisBlocked, int totalAttempts) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
		this.role = role;
		this.accisBlocked = accisBlocked;
		this.totalAttempts = totalAttempts;
	}




	public int getTotalAttempts() {
		return totalAttempts;
	}




	public void setTotalAttempts(int totalAttempts) {
		this.totalAttempts = totalAttempts;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhoneNo() {
		return phoneNo;
	}




	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public boolean getAccisBlocked() {
		return accisBlocked;
	}




	public void setAccisBlocked(boolean accisBlocked) {
		this.accisBlocked = accisBlocked;
	}




	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, phoneNo, role, userName);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(phoneNo, other.phoneNo) && Objects.equals(role, other.role)
				&& Objects.equals(userName, other.userName);
	}




	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", role=" + role + "]";
	}


}
	