package com.springboot.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	UserDetailsService myUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Configure our apis as per role
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/customers").authenticated().antMatchers("/products")
				.authenticated().antMatchers("/products/category/{cid}").hasAnyRole("ADMIN").anyRequest().permitAll()
				.and().httpBasic().and().csrf().disable();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Build out custom Auth Manager
		// auth.inMemoryAuthentication().withUser("harry").password(getPasswordEncoder().encode("potter123")).roles("ADMIN").and().withUser("ronald").password(getPasswordEncoder().encode("weasly123")).roles("EXEC");

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	private DaoAuthenticationProvider getCustomProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(myUserDetailsService);
		return dao;

	}

}
