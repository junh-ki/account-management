package com.jun.cashtransaction.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashtransaction.integration.dto.User;

@Component
public class UserRestClientImpl implements UserRestClient {
	
	private static final String USER_REST_URL = "http://localhost:8080/cashdeposit/users/";
	
	@Override
	public User findUser(String email) {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(USER_REST_URL + email, User.class);
		return user;
	}

}
