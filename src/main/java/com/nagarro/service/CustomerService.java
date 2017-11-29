package com.nagarro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nagarro.dao.Customer;
import com.nagarro.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		List<Customer> users = new ArrayList<>();
		customerRepository.findAll().forEach(users::add);
		return users;
	}

	public Customer getCustomer(Integer id) {
		return customerRepository.findOne(id);
	}

	public void addCustomer(Customer data) {
		data.setAccountBalance(500.00);
		String uniqueKey = UUID.randomUUID().toString();
		data.setUserId(uniqueKey);
		customerRepository.save(data);
	}

	public void updateCustomerBalance(Integer id, Customer data) {
		Customer customer = customerRepository.findOne(id);
		customer.setAccountBalance(data.getAccountBalance());
		customerRepository.save(customer);
	}

}
