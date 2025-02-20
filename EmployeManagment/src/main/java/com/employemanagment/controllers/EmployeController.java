package com.employemanagment.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employemanagment.dto.Employee;
import com.employemanagment.services.EmployeService;

@Controller
@RequestMapping("/employee")
public class EmployeController {
	
	@Autowired
	EmployeService employeService;
	@GetMapping("employelist")
	public String delault(Model model) {
		
		List<Employee> allEmployees = employeService.getAllEmployees();
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 System.out.println("authentication "+ authentication.getName());
		model.addAttribute("employeList", allEmployees);
		model.addAttribute("userName", authentication.getName());
		model.addAttribute("role", authentication.getAuthorities());


		return "views/home";
	}
	@GetMapping("showFormforUpdate")
	public String update(@RequestParam("empId") int id, Model model) {
		Employee updateEmploye = employeService.updateEmploye(id);
		model.addAttribute("updatedEmployee", updateEmploye);
		System.out.println(updateEmploye);
		return "views/employe/update";
		
	}

}
