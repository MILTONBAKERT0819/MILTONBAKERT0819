package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Customer;
import com.springboot.backend.repository.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/customer")
	public void postAccount(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}

	@GetMapping("/customer")
	public List<Customer> getAllAccounts() {
		List<Customer> list = customerRepository.findAll();
		return list;
	}

	@GetMapping("/customer/{cid}")
	public Customer getAccountById(@PathVariable("cid") Long cid) {
		Optional<Customer> optional = customerRepository.findById(cid);
		if (optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
	}

	@DeleteMapping("/customer/{cid}")
	public void deleteAccount(@PathVariable("cid") Long cid) {
		customerRepository.deleteById(cid);
	}

	@PutMapping("/customer/{cid}")
	public Customer updateAccount(@PathVariable("aid") Long cid, @RequestBody Customer newCustomer) {
		Optional<Customer> optional = customerRepository.findById(cid);
		if (optional.isPresent()) {
			Customer existingCustomer = optional.get();
			existingCustomer.setName(newCustomer.getName());
			existingCustomer.setAge(newCustomer.getAge());
			existingCustomer.setAccount(newCustomer.getAccount());
			return customerRepository.save(existingCustomer);
		}
		throw new RuntimeException("ID is Invalid");
	}
	/*@GetMapping("/customer/account/{aid}")
	public List<Customer> getCustomerByAccountId(@PathVariable("aid") Long aid) {
		List<Customer> list= customerRepository.getCustomerByAccountId(aid);
		return list;
	}*/
	/*@GetMapping("/customer/account/{atype}")
	public List<Customer> getCustomerByAccountType(@PathVariable("atype") String atype){
		List<Customer> list= customerRepository.getCustomerByAccountType(atype);
		return list;
	}*/
}
