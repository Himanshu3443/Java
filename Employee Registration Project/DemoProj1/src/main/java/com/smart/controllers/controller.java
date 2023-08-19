package com.smart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smart.entities.Employee;
import com.smart.repositories.EmployeeRepo;

@Controller
public class controller {
	
	@Autowired
	EmployeeRepo repo;
	
	
	@GetMapping("/")
	public String home(Model model)
	{
		List<Employee> employee = repo.findAll();
		model.addAttribute("employee", employee);
		
		return "show";
		 
	}
	
	
	@GetMapping("/saveEmp")
	public String saveEmp(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}
	
	@PostMapping("/display")
	public String display(@ModelAttribute("employee") Employee employee) 
	{
		repo.save(employee);
		return "redirect:/";
	}
	
	
	

}
