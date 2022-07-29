package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("Select p from Product p where p.category = ?1")
	List<Product> getProductsByCategoryId(Long cid);
	
}
