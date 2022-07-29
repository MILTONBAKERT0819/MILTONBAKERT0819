package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Customer1;
import com.springboot.backend.model.CustomerProduct;

public interface Customer1ProductRepository extends JpaRepository<CustomerProduct, Long> {
	/*
	@Query(value="selct name from product where id IN"+ "(select product_id from customer_product where customer_id=10)", nativeQuery = true)
	List<String> getProductsByCustomerIdNative(Long id);
	
	@Query("select cp.product.name from CustomerProduct cp where cp.customer.id=?1")
	List<String> getProductsByCustomerId(Long id);*/
	/*
	@Query(value="selct name from customer where id IN"+ "(select customer_id from customer_product where product_id=10)", nativeQuery = true)
	List<String> getCustomerByProductIdNative(Long id);
	
	@Query("select cp.customer.name from CustomerProduct cp where cp.product.id=?1")
	List<String> getCustomerByProductId(Long id);*/
	
	/*@Query("select distinct cp.customer from CustomerProduct cp where cp.product.id IN" +"(select p.id from Product p where LOWER(p.vendor.name)=LOWER(?1")
	List<Customer1> getCustomerByVendorName(String name);*/
	
	/*@Query("select distinct cp.customer from CustomerProduct cp where cp.product.vendor.name=?1 ")
	List<Customer1> getCustomersByVendorNameAlternative(String name);*/
	

}
