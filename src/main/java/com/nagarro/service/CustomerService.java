package com.nagarro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.Customer;
import com.nagarro.repository.ICustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		List<Customer> users = new ArrayList<>();
		customerRepository.findAll().forEach(users::add);
		return users;
	}

	public void addCustomer(Customer data) {
		customerRepository.save(data);
	}
}
