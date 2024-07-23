package com.employemanagment.serviceImp;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.employemanagment.dto.UserDto;
import com.employemanagment.services.LoginService;
@Service
public class LoginServiceImpl implements LoginService{
	
   // @Autowired
   // AuthenticationManager authenticationManager;
	@Override
	public String login(UserDto user) {
//		UserDto  inMemoryUser= new UserDto("Habi","786");
//		String userNameMessage= (inMemoryUser.getUserName().equals(user.getUserName()))? "valid" : "Invalid";
//		String userPasswordMessage= (inMemoryUser.getPassword().equals(user.getPassword()))? "valid" : "Invalid";
//		Map<String,String> userMap = new HashMap();
//		userMap.put("userNameMessage", userNameMessage);
//		userMap.put("userPasswordMessage", userPasswordMessage);
//
//		return userMap;
       // Collection<GrantedAuthority> authorities = new ArrayList();
       // authorities.add(new SimpleGrantedAuthority("ADMIN"));
		// Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(),authorities));
		 return "test";
		// return "views/home";
	}

}
