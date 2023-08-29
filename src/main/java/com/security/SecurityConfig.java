//package com.security;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
////Entry point of spring sec configuration
//@EnableWebSecurity //to enable web security frmwork
//@Configuration //to tell SC following is java configuration class : to declare spring beans
////Equivalent to bean config xml file, This class can contain bean declaration : @Bean
////annotated methods(equivalent to <bean id , class....../>
//@EnableGlobalMethodSecurity(prePostEnabled = true) //to enable method level security , with pre auth n post auth
//public class SecurityConfig {
//	
//	//configures spring security for authorization (role based)
//	@Bean
//	public SecurityFilterChain authorizeRequests(HttpSecurity http) throws Exception
//	{
//		http.authorizeRequests() //specify all authorization rules (i.e authorize all requests)
//		.antMatchers("/login").permitAll() // for incoming req ending with /products/view : no authentication n authorization needed
//		.antMatchers("/user").hasRole("OWNER")//only customer can purchase the products
//		.antMatchers("/user").hasRole("ADMIN")
//		.antMatchers("/user").hasRole("GUEST")//only admin can add the products
//		.anyRequest().authenticated() //all remaining end points accessible only to authenticated users
//		.and()
//		.httpBasic(); //configures HTTP Basic auth (using Base64 encoded username:pwd)
//		return http.build();
//	}
//}