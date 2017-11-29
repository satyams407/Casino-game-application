package com.nagarro.service;

import java.util.List;

import com.nagarro.dao.Customer;

public interface ICustomerService {
	public List<Customer> getAllCustomers();
	
	public void addCustomer(Customer data);
	
	public Customer getCustomer(Integer id);
	
	public void updateCustomerBalance(Integer id, Customer data);
}
