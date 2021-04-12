package com.jun.cashdeposit.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashdeposit.integration.dto.User;

@Component
public class UserRestClientImpl implements UserRestClient {
	
	private static final String USER_REST_URL = "http://localhost:8080/restservice/users/";
	
	@Override
	public User findUser(String email) {
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(USER_REST_URL + email, User.class);
		return user;
	}
	
	@Override
	public User saveUser(User user) {
		RestTemplate restTemplate = new RestTemplate();
		User savedUser = restTemplate.postForObject(USER_REST_URL, user, User.class);
		return savedUser;
	}

}
