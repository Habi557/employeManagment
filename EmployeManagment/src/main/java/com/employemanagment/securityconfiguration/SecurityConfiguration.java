package com.employemanagment.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Bean
	public SecurityFilterChain security(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(req ->{
//			req.requestMatchers("/","authincate").permitAll()
//			.requestMatchers("authincate").hasRole("ADMIN");
//			//.requestMatchers("authincate").permitAll();
//			
//			
//            
//		})
//		.exceptionHandling( 
//                exception 
//                -> exception.accessDeniedPage( 
//                    "/error"));
//		return http.build();
		
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(req -> req.requestMatchers("/employee/showFormforUpdate").hasRole("ADMIN").anyRequest().authenticated())
		.exceptionHandling( 
                exception 
                -> exception.accessDeniedPage( 
                    "/errors"))
		        .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/authincate").defaultSuccessUrl("/employee/employelist", true).permitAll());
		        
		return http.build();
	
		
		
	}
	@Bean
	public UserDetailsService loginData() {
		UserBuilder builder = User.builder();
		UserDetails habiUser= builder.username("Habi").password(passwordEncoder.encode("786786")).roles("USER","EMPLOYE").build();
		UserDetails abdulla= builder.username("Abdulla").password(passwordEncoder.encode("786786")).roles("ADMIN").build();

		return  new InMemoryUserDetailsManager(habiUser,abdulla);
		
	}
//	@Bean 
//	public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration config) throws Exception {
//		return config.getAuthenticationManager();
//	}
//	@Bean 
//	public DaoAuthenticationProvider getDaoAuthenticationProvider() {
//		
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//		daoAuthenticationProvider.setUserDetailsService(UserDetailsService userDetailService);
//		return daoAuthenticationProvider;
//		
//		
//	}
	
	@Bean 
	public WebSecurityCustomizer webSecurityCustomizer() {
		
		return (web)-> web.ignoring().requestMatchers("/css/**","/js/**");
	}
	

}
