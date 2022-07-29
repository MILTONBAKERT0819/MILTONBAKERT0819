package com.springboot.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.backend.model.UserInfo;
import com.springboot.backend.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		UserInfo uInfo = UserRepository.getByUsername(username);
		if(uInfo ==null)
			throw new UsernameNotFoundException("Username invalid");
		
		List<GrantedAuthority> list = new ArrayList<>();
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(uInfo.getRole());
		list.add(sga);
		User user = new User(uInfo.getUsername(), uInfo.getPassword(),list);
		
		
		
		
		
		
		return user;
	}

}
