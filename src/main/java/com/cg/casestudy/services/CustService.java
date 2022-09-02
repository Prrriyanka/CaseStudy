package com.cg.casestudy.services;
import java.util.List;
import com.cg.casestudy.beans.Customer;

public interface CustService {

	public Customer registerCustomer(Customer customer);
	public String loginCustomer(String userName,String password);
	public boolean deleteCustomer(int id);
	public List<Customer> showAllCustomer();
	public boolean validateUserDetails(Customer customer);
	
}
