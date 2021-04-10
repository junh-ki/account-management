package com.jun.cashtransaction.integration;

import com.jun.cashtransaction.integration.dto.User;

public interface UserRestClient {

	public User findUser(String email);
	
}
