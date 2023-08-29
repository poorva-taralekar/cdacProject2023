package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.EditPassDTO;
import com.app.dto.ForgetPassOtpDTO;
import com.app.dto.OTPVerificationDTO;
import com.app.dto.RoomDTO;
import com.app.dto.Signuprequest;
import com.app.dto.UserBooking;
import com.app.entities.User;
import com.app.service.RoomService;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserContoller {
	@Autowired
	private UserService userService;

	@Autowired
	private RoomService rs;
	
//	@PostMapping("/signin")
//    public ResponseEntity<?>signInUser(@RequestBody @Valid AuthRequest request ){
//    	System.out.println("auth req "+request);
//    	AuthResp resp=userService.singInUser(request);
//    	return ResponseEntity.ok(resp);
//    }
	@GetMapping
	public List<User> listAllUser() {
		return userService.getAllUser();
	}

//	@PostMapping
//	public User addNewCust(@RequestBody User cust) {
//		return userService.addUser(cust);
//	}
	@PostMapping("/signUp")
	public ResponseEntity<?>addNewUser(@RequestBody @Valid Signuprequest cust){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(cust));
	}

	@PutMapping
	public User updateUser(@RequestBody User cust) {
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

	@GetMapping("/CheckAvailability/{city}")
	public List<RoomDTO> RoomDetails(@PathVariable String city) {
		return rs.getAvailableRooms(city);
	}

	@PostMapping("/booking")
	public int BookingDetails(@RequestBody UserBooking book) {
		return userService.bookingPrice(book.getCheckIn(), book.getCheckOut(), book.getRoomType());
	}
	
	//------------------------------------------------------------
    //------------------------------------------------------------
    
    String email=new String();
    @PostMapping("/getOtpForForgotPass")
    public ResponseEntity<String> getOtpForForgotPass(@RequestBody ForgetPassOtpDTO emailId){
    	email=emailId.getEmail();
    	userService.getOtpForForgotPass(emailId.getEmail());
    	return ResponseEntity.ok("OTP send for verification .");
   	 	
    }
    
    boolean isVerified1;
    @PostMapping("/verify-otpforforgot")
    public ResponseEntity<?>verifyOTPForForgotPass(@RequestBody OTPVerificationDTO otpVerificationDTO ){
    	boolean isVerified=userService.verifyOTP(otpVerificationDTO);
    	isVerified1=isVerified;
    	if(isVerified) {
    		System.out.println("successfull");
    		return ResponseEntity.status(HttpStatus.CREATED).body("Sucessful");    //.ok("OTP Verification is Successful");
    	}else {
    		return ResponseEntity.badRequest().body("OTP verification failed .");
    	}
    }  
    
    @PostMapping("/storenewpass")
    public ResponseEntity<?>storeNewPass(@RequestBody EditPassDTO pass){
    	if(isVerified1) {
    		userService.storeUserDataWithNewPass(pass);
    		System.out.println("success");
    		return ResponseEntity.ok("Pass changed Successfully");
    	}else {
    		return ResponseEntity.badRequest().body("pass failed");
    	}
    	
    	
    }
}
