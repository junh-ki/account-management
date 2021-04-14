package com.jun.restservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.restservice.entities.User;
import com.jun.restservice.services.UserService;

@RestController
@CrossOrigin
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable("id") Long id) {
		return userService.findUserById(id);
	}
	
	@GetMapping("/user/{email}")
	public User findUserByEmail(@PathVariable("email") String email) {
		return userService.findUserByEmail(email);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
}
