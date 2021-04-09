package com.jun.cashdeposit.services;

import com.jun.cashdeposit.entities.User;

public interface UserService {

	public User saveUser(User user);
	public User findUserByEmail(String email);
	
}
