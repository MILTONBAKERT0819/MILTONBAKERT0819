package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	/*@Query("Select c from Customer c where c.accountid = ?1")
	List<Customer> getCustomerByAccountId(Long aid);
	
	@Query("Select c from Customer c where c.accountType=?1")
	List<Customer> getCustomerByAccountType(String atype);*/

}
