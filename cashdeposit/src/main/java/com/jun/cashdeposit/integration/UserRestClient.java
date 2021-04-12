package com.jun.cashdeposit.integration;

import com.jun.cashdeposit.integration.dto.User;

public interface UserRestClient {

	public User findUser(String email);
	public User saveUser(User user);
	
}
