package com.cg.casestudy.services;

import java.util.List;
import com.cg.casestudy.beans.Customer;
import com.cg.casestudy.daos.CustomerDAO;
import com.cg.casestudy.daos.CustomerDAOImpl;


public class CustServiceImpl implements CustService{
	
	private CustomerDAO customerDAO=new CustomerDAOImpl();

	@Override
	public Customer registerCustomer(Customer customer) {
		//uncomment while using main class
		//customer=customerDAO.register(customer);
		return customer;
	}

	@Override
	public String loginCustomer(String userName, String password) {
		return customerDAO.login(userName, password);
	}

	@Override
	public boolean deleteCustomer(int id) {
		boolean productdeleted = customerDAO.delete(id);
		return productdeleted;
	}

	@Override
	public List<Customer> showAllCustomer() {
		List<Customer> AllCustomerList = customerDAO.showAll();
		return AllCustomerList;
	}

	@Override
	public boolean validateUserDetails(Customer customer) {
		return customerDAO.validate(customer);
	}


}
