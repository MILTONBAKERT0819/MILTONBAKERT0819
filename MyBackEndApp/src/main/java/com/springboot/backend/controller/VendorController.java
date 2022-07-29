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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Category;
import com.springboot.backend.model.Vendor;
import com.springboot.backend.repository.VendorRepository;

@RestController
public class VendorController {

	@Autowired
	VendorRepository vendorRepository;

	@PostMapping("/vendor")
	public void postVendor(@RequestBody Vendor vendor) {
		vendorRepository.save(vendor);
	}

	@GetMapping("/vendor")
	public List<Vendor> getAllVendors(@RequestParam(name = "page",required = false, defaultValue = "0")Integer page, @RequestParam(name = "size",required = false, defaultValue = "100000")Integer size) {
		//List<Vendor> list = vendorRepository.findAll();
		//return list;
		List<Vendor> list = vendorRepository.findAll(pageable).getContent();
	}

	@GetMapping("/vendor/single/{id}")
	public Vendor getVendorbyId(@PathVariable("id") Long id) {
		Optional<Vendor> optional = vendorRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
	}

	@DeleteMapping("/vendor/{id}")
	public void deleteVendor(@PathVariable("id") Long id) {
		vendorRepository.deleteById(id);
	}

	@PutMapping("/vendor/{id}")
	public Vendor updateVendor(@PathVariable("id") Long id, @RequestBody Vendor newVendor) {
		Optional<Vendor> optional = vendorRepository.findById(id);
		if (optional.isPresent()) {
			Vendor existingVendor = optional.get();
			existingVendor.setName(newVendor.getName());
			existingVendor.setCity(newVendor.getCity());
			return vendorRepository.save(existingVendor);
		}
		throw new RuntimeException("ID is invalid");
	}

	@GetMapping("/vendor/city/{city}")
	public List<Vendor>getVendorByCity(@PathVariable("city") String city){
		List<Vendor> list = vendorRepository.findBycity(city);
		return list;
	}
}