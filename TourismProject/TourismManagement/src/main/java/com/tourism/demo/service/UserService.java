package com.tourism.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.tourism.demo.entity.User;

public interface UserService {
	
	User findByname(String name);
	public ResponseEntity<?> saveUser(@RequestBody User user) ;
	List<User> getAlluser();
	User getuserById(long User_id);
	User saveuser(User user);
	User updateUser(User user, long User_id);
	void deleteUser(long User_id);
	
	
}
