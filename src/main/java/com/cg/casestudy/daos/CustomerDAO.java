package com.cg.casestudy.daos;

import java.util.List;
import com.cg.casestudy.beans.Customer;

public interface CustomerDAO {
	
	public boolean accisBlocked(String userName);
	public String register(Customer customer);
	public String login(String userName, String passwordString);
	public  boolean delete(int id);
	public List<Customer> showAll();
	public boolean validate(Customer customer);
	public void blockacc(String userName);
	public boolean userExist(String userName);
	public boolean emailExist(String email);
	public void resetTotalAttempts(String userName);
	public void resetTotalAttempts(String userName, int attempts);
	public int fetchTotalAttempts(String userName);
	
	
}
