package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")

public class UserContoller {
@Autowired
	private  UserService userService;
	
	@GetMapping
	public List<User>listAllUser(){
		return userService.getAllUser();
		}
	
	@PostMapping
	public User addNewCust(@RequestBody User cust) {
	  return userService.addUser(cust);
	}
	
    @PutMapping
    public User updateUser(@RequestBody User cust)
    {
    	return userService.updateUserDetail(cust);
    }
   @DeleteMapping("/{custId}")
   public String deleteUserDetails(@PathVariable Long custId) {
	   return userService.deleteUserDetails(custId);
   }
   @GetMapping("/{custId}")
   public User getUserDetails(@PathVariable Long custId) {
	   return userService.getUserDetails(custId);
   }
    
    
}
