package com.springboot.backend.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.dto.ProductDto;
import com.springboot.backend.model.Category;
import com.springboot.backend.model.Product;
import com.springboot.backend.model.Vendor;
import com.springboot.backend.repository.CategoryRepository;
import com.springboot.backend.repository.ProductRepository;
import com.springboot.backend.repository.VendorRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private VendorRepository vendorRepository;
	
	@GetMapping("/products")
	public List<ProductDto> getAllProducts(){
		List<Product> list = productRepository.findAll();
		List<ProductDto> listDto = new ArrayList<>();
		list.stream().forEach(p->{
			ProductDto dto = new ProductDto();
			dto.setId(p.getId());
			dto.setName(p.getName());
			dto.setPrice(p.getPrice());
			dto.setCid(p.getCategory().getId());
			dto.setCname(p.getCategory().getName());
			dto.setVid(p.getVendor().getId());
			dto.setVcity(p.getVendor().getCity());
			dto.setVname(p.getVendor().getName());
			listDto.add(dto);
		});
		return listDto;
	}
	
	@PostMapping("/product/{cid}/{vid}")
	public Product postProduct(@RequestBody Product product,@PathVariable("cid") Long cid, @PathVariable("vid") Long vid) {
		
		Optional<Category> optional = categoryRepository.findById(cid);
		if(!optional.isPresent())
			throw new RuntimeException("Category Id is Invalid");
		
		Category category =optional.get();
		
		Optional<Vendor> optionalV =vendorRepository.findById(vid);
		if(!optionalV.isPresent())
			throw new RuntimeException("Vendor ID is invalid");
		
		Vendor vendor = optionalV.get();
		
		product.setCategory(category);
		product.setVendor(vendor);
		
		return productRepository.save(product);
	}
	
	@GetMapping("/product/category/{cid}")
	public List<Product> getProductByCategoryId(@PathVariable("cid") Long cid) {
		List<Product> list= productRepository.getProductsByCategoryId(cid);
		return list;
	}
	
	/*@GetMapping("/product/vendor/{vid}")
	public List<Product> getProductByVendorId(@PathVariable("vid") Long vid) {
		List<Product> list= productRepository.getProductsByVendorId(vid);
		return list;
	}*/
	
	
	

}

