package com.cg.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.dao.UserRepository;

import com.cg.entity.User;



@RestController

public class UserController {

	
	@Autowired 
	private UserRepository userRepository;

	@PostMapping(path = "/users/signUpIntoLoginCredentials")
	public User userSignUp(@RequestBody User user) {
		
	return userRepository.save(user); 
	}
	
	@GetMapping(path = "/users/login")
	public String userLogin(@RequestBody User user) {
		User existingUser=userRepository.findById(user.getUserId()).get();
		
		if(existingUser.getUserId().equals(user.getUserId())&& existingUser.getPassword().equals(user.getPassword()))
		{
		return "successfully logged in";
		}
		else
		{
			return "Bad credentials";
		}
	}
	
	
	@GetMapping(path = "/users/logout")
	public void userLogOut() {
		System.out.println("this function will be used for USER LOGIN ");
		
	}

	@PutMapping(path="/users/login/forgetpassword/userId/{userId}")
	public String userForgotPassword(@PathVariable String userId ,@RequestBody User user)
	{
		User existingUser=userRepository.findById(userId).get();
		existingUser.setPassword(user.getPassword()); 
		final User updatedUser = userRepository.save(existingUser);
		return "password changed successfully....now login!!!";
	}

	

//	@GetMapping(path = "/users/check/{userId}")
//	public User userCheck(@PathVariable String userId) {
//		if(userRepository.existsById(userId))
//		{
//			User user = userRepository.findByUserId(userId);
//		return user;
//		}
//		else
//		{
//			return null;
//		}
//	}
	
	
	
	
	
}
