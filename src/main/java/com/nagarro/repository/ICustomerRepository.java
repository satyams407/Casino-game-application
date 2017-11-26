package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.dao.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer>{

}
