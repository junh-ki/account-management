package com.jun.cashtransaction.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashtransaction.integration.dto.Account;
import com.jun.cashtransaction.integration.dto.AccountUpdateRequest;

@Component
public class AccountRestClientImpl implements AccountRestClient {

	private static final String ACCOUNT_REST_URL = "http://localhost:8080/cashdeposit/accounts/";
	
	@Override
	public Account findAccount(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Account account = restTemplate.getForObject(ACCOUNT_REST_URL + id, Account.class);
		return account;
	}
	
	@Override
	public Account updateAccount(AccountUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Account account = restTemplate.postForObject(ACCOUNT_REST_URL, request, Account.class);
		return account;
	}
	
}
