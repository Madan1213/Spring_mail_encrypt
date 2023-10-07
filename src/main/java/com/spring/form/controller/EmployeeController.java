package com.spring.form.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.form.entities.EmployeeEntity;
import com.spring.form.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/register")
	public String create(Model model)
	{
		model.addAttribute("employee", new EmployeeEntity());
		return "Register";
	}
	
	@PostMapping("/savings")
	public String registerUsre(@ModelAttribute EmployeeEntity user)
	{
		service.registerUser(user);
		return "SuccessPage";
	}
}
