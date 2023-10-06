package com.spring.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.form.entities.EmployeeEntity;
import com.spring.form.repository.EmployeeRepo;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MailService mailSender;
	
	public void registerUser(EmployeeEntity user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
		
		//After registering/saving send mail 
		mailSender.sendRegistrationMail(user.getUsername(), "Welocme To Our Service", "Thank You for registering with us");
	}
	
}
