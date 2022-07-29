package com.springboot.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.UserRepository;

@RestController
public class UserControler {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/user")
	public UserInfo postUser(@RequestBody UserInfo user) {
		String password = user.getPassword();
		password = passwordEncoder.encode(password);
		user.setPassword(password);
		return userRepository.save(user);
	}
}
