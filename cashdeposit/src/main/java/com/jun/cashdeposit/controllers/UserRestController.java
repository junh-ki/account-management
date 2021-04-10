package com.jun.cashdeposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jun.cashdeposit.entities.User;
import com.jun.cashdeposit.services.UserService;

@RestController
@CrossOrigin
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users/{email}")
	public User findAccount(@PathVariable("email") String email) {
		return userService.findUserByEmail(email);
	}
	
}
