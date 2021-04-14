package com.jun.restservice.services;

import java.util.List;

import com.jun.restservice.entities.User;

public interface UserService {

	public User findUserById(Long id);
	public User findUserByEmail(String email);
	public List<User> getAllUsers();
	public User saveUser(User user);
	
}
