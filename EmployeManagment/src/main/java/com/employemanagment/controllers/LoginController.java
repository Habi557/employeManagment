package com.employemanagment.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employemanagment.dto.Employee;
import com.employemanagment.dto.UserDto;
import com.employemanagment.services.LoginService;

@Controller
//@RequestMapping("/sample")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	@GetMapping("/login")
	public String login() {
		return "login/login";
	}
	
	
//	@PostMapping("/authincate")
//	public String login(UserDto userDto) {
//		System.out.println("authincate");
//		return loginService.login(userDto);
//		//return null;
//		
//	}
	@GetMapping("/errors")
	public String error() {
		return "error/error";
	}
	@GetMapping("/logout")
	public String logout(){
		
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 authentication.setAuthenticated(false);
			return "login/login";


		
	}
	
	
	

}
