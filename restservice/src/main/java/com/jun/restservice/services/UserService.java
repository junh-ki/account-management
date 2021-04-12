package com.jun.restservice.services;

import com.jun.restservice.entities.User;

public interface UserService {

	public User saveUser(User user);
	public User findUserById(Long id);
	public User findUserByEmail(String email);
	
}
