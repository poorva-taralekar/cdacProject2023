package com.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.app.dto.AuthResponse;
import com.app.dto.LoginForm;
import com.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class AuthController {
     @Autowired 
     private UserService userService;

     @PostMapping
     public ResponseEntity<?> login(@RequestBody LoginForm loginForm)
     {
    	 if(userService.authenticate(loginForm.getEmail() , loginForm.getPassword()))
    	 {
    		 String userRole = userService.getUserRole();
    	 		String token = Jwts.builder()
    	                 .setSubject(loginForm.getEmail()) // Set the subject (user)
    	                 .claim("role", userRole) // Set the user role as a claim
    	                 .setIssuedAt(new Date()) // Set the issue date
    	                 .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Set the expiration date (1 day)
    	                 .signWith(SignatureAlgorithm.HS512, "yourSecretKey") // Sign the token with your secret key
    	                 .compact();
    		return ResponseEntity.ok(new AuthResponse(userRole,token));
    	 }else {
    		 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    	 }
     }
} 