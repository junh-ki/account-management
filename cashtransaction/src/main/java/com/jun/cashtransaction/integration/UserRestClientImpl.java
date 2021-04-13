package com.jun.cashtransaction.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashtransaction.integration.dto.User;
import com.jun.cashtransaction.properties.MyConfigs;

@Component
public class UserRestClientImpl implements UserRestClient {
	
	@Autowired
	private MyConfigs myConfigs;
	private static final String USER_REST_URL = "http://localhost:8080/restservice/users/";
	
	@Override
	public User findUser(String email) {
		RestTemplate restTemplate = new RestTemplate();
		User user;
		if (myConfigs.getREST_URL_USER() != null) {
			user = restTemplate.getForObject(myConfigs.getREST_URL_USER() + email, User.class);
		} else {
			user = restTemplate.getForObject(USER_REST_URL + email, User.class);
		}
		return user;
	}

}
