package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.entities.User;
import com.app.exception.ResourceNotFoundException;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}

	@Override
	public User updateUserDetail(User user) {
		User founduser = userDao.findById(user.getId()).orElseThrow(()-> new
				ResourceNotFoundException("Invalid Emp ID !!!!!"));
				
		return userDao.save(user);
	}
	@Override
	public String deleteUserDetails(Long userId) {
		// TODO Auto-generated method stub
		User founduser=userDao.findById(userId).orElseThrow(()
				->new  ResourceNotFoundException("Invalid Emp ID !!!!!"));
		userDao.deleteById(userId);
		return "user Deatils deleted successfully !!!";
	}
	@Override
	public User getUserDetails(Long userId) {
		// TODO Auto-generated method stub
		
		return userDao.findById(userId).orElseThrow(()->
		new ResourceNotFoundException("Invalid Emp ID !!!!!"));
	}

}
