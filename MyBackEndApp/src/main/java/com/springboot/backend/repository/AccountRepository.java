package com.springboot.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.backend.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
