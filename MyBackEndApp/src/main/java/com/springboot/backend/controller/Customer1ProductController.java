package com.springboot.backend.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Customer1;
import com.springboot.backend.model.CustomerProduct;
import com.springboot.backend.model.Product;
import com.springboot.backend.repository.Customer1ProductRepository;
import com.springboot.backend.repository.Customer1Repository;
import com.springboot.backend.repository.ProductRepository;

@RestController
public class Customer1ProductController {

	@Autowired
	private Customer1ProductRepository customer1ProductRepository;

	@Autowired
	private Customer1Repository customer1Repository;

	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/customer/product/{cid}/{pid}")
	public CustomerProduct purchaseApi(@PathVariable("cid") Long cid, @PathVariable("pid") Long pid,
			@RequestBody CustomerProduct cp) {

		Optional<Customer1> optionalC = customer1Repository.findById(cid);
		if (!optionalC.isPresent())
			throw new RuntimeException("Invalid Customer ID Given");

		Optional<Product> optionalP = productRepository.findById(pid);
		if (!optionalP.isPresent())
			throw new RuntimeException("Invalid Customer ID Given");

		Customer1 c = optionalC.get();
		Product p = optionalP.get();

		cp.setCustomer1(c);
		cp.setProduct(p);

		cp.setDateOfPurchase(LocalDate.now());

		return customer1ProductRepository.save(cp);

	}
/*
	@GetMapping("/product/customer/{cid}")
	public List<String> getProductsByCustomerId(@PathVariable("cid") Long cid) {
		Optional<Customer1> optionalC = customer1Repository.findById(cid);
		if (!optionalC.isPresent())
			throw new RuntimeException("Customer ID is invalid");
		Customer1 c = optionalC.get();

		List<String> list = customer1ProductRepository.getProductsByCustomerId(c.getId());
		return list;

	}*/
	
	/*@GetMapping("/customer/prduct/{pid}")
	public List<String> getCustomerByProductId(@PathVariable("pid") Long pid){
		Optional<Product> optionalP = productRepository.findById(pid);
		if(!optionalP.isPresent())
			throw new RuntimeException("Product ID is invalid");
		Product p = optionalP.get();
		
		List<String> list = customer1ProductRepository.getCustomerByProductId(p.getId());
		return list;
		
	}*/
	
	/*@GetMapping("/customer/vendor/{name}")
	public List<Customer1> gerCustomerByVendorName(@PathVariable("name")String name){
		return customer1ProductRepository.getCustomersByVendorNameAlternative(name);
	}*/
	
	

}
