package com.app.service;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.app.entities.User;

public interface UserService {
   List<User> getAllUser();
   User addUser(User user);
   User updateUserDetail(User user);
   String deleteUserDetails(Long userId);
   User getUserDetails(Long userId);
   
}
