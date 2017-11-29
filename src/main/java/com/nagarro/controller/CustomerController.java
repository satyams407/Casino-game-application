package com.nagarro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nagarro.dao.Customer;
import com.nagarro.service.ICustomerService;

@CrossOrigin
@RestController
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@GetMapping(path = "/users", produces = "application/json")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping(path = "/users/{id}", produces = "application/json")
	public Customer getCustomer(@PathVariable Integer id) {
		return customerService.getCustomer(id);
	}

	@PostMapping(value = "/users")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	@PostMapping(value = "/users/{id}")
	public void updateCustomerBalance(@RequestBody Customer customer, @PathVariable Integer id) {
		customerService.updateCustomerBalance(id, customer);
	}

}
