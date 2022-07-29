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

import com.springboot.backend.model.Account;
import com.springboot.backend.repository.AccountRepository;

@RestController
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;

	@PostMapping("/account")
	public void postAccount(@RequestBody Account account) {
		accountRepository.save(account);
	}

	@GetMapping("/account")
	public List<Account> getAllAccounts() {
		List<Account> list = accountRepository.findAll();
		return list;
	}

	@GetMapping("/account/{aid}")
	public Account getAccountById(@PathVariable("aid") Long aid) {
		Optional<Account> optional = accountRepository.findById(aid);
		if (optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
	}

	@DeleteMapping("/account/{aid}")
	public void deleteAccount(@PathVariable("aid") Long aid) {
		accountRepository.deleteById(aid);
	}

	@PutMapping("/account/{aid}")
	public Account updateAccount(@PathVariable("aid") Long aid, @RequestBody Account newAccount) {
		Optional<Account> optional = accountRepository.findById(aid);
		if (optional.isPresent()) {
			Account existingAccount = optional.get();
			existingAccount.setType(newAccount.getType());
			return accountRepository.save(existingAccount);
		}
		throw new RuntimeException("ID is Invalid");
	}
	
	

}
