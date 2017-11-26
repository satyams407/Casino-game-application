package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dao.Customer;
import com.nagarro.service.CustomerService;

@RestController
public class CustomerController  {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/users")   
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
}
