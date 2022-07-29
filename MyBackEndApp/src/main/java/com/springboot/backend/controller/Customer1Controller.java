package com.springboot.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Customer1;
import com.springboot.backend.repository.Customer1Repository;

@RestController
public class Customer1Controller {
	
	@Autowired
	Customer1Repository customer1Repository;
	
	@PostMapping("/customer1")
	public Customer1 postCustomer(@RequestBody Customer1 customer1) {
		return customer1Repository.save(customer1);
	}
	
	@GetMapping ("/customer1")
	public List<Customer1> getAllCustomers(){
		return customer1Repository.findAll();
	}

}
