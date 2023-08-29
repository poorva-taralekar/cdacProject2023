package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.EditPassDTO;
import com.app.dto.OTPVerificationDTO;
import com.app.dto.SignupResponse;
import com.app.dto.Signuprequest;
import com.app.entities.RoomType;
import com.app.entities.User;

public interface UserService {
	public boolean authenticate(String username, String password);

	public String getUserRole();

	List<User> getAllUser();

	//User addUser(User user);
	SignupResponse addUser(Signuprequest newuser);

	User updateUserDetail(User user);

	String deleteUserDetails(Long userId);

	User getUserDetails(Long userId);

	public int bookingPrice(LocalDate checkIn, LocalDate checkOut, String type);

	// forgot pass
	void getOtpForForgotPass(String emailId);

	SignupResponse storeUserDataWithNewPass(EditPassDTO newpass);

	boolean verifyOTP(OTPVerificationDTO otpVerificationDTO);
}
