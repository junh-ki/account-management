package com.jun.cashtransaction.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashtransaction.integration.dto.User;

@Component
public class UserRestClientImpl implements UserRestClient {
	
	@Autowired
	private RestServiceUrl restServiceUrl;
	
	@Override
	public User findUser(String email) {
		String USER_REST_URL = restServiceUrl.getRestServiceUrl() + "users/";
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(USER_REST_URL + email, User.class);
		return user;
	}

}
