package com.jun.cashtransaction.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashtransaction.integration.dto.Account;
import com.jun.cashtransaction.integration.dto.AccountUpdateRequest;

@Component
public class AccountRestClientImpl implements AccountRestClient {

	@Autowired
	private RestServiceUrl restServiceUrl;
	
	@Override
	public Account findAccountById(Long id) {
		String ACCOUNT_REST_URL = restServiceUrl.getRestServiceUrl() + "accounts/";
		RestTemplate restTemplate = new RestTemplate();
		Account account = restTemplate.getForObject(ACCOUNT_REST_URL + id, Account.class);
		return account;
	}
	
	@Override
	public List<Account> findAccountsByHolderId(Long id) {
		String ACCOUNT_REST_URL = restServiceUrl.getRestServiceUrl() + "accounts/";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Account[]> response = restTemplate.getForEntity(ACCOUNT_REST_URL, Account[].class);
		Account[] accountArray = response.getBody();
		List<Account> accounts = new ArrayList<Account>();
		for (int i = 0; i < accountArray.length; i++) {
			Account account = accountArray[i];
			if (account.getHolderId().equals(id)) {
				accounts.add(account);
			}
		}
		return accounts;
	}
	
	@Override
	public Account updateAccount(AccountUpdateRequest request) {
		String ACCOUNT_REST_URL = restServiceUrl.getRestServiceUrl() + "accounts/";
		RestTemplate restTemplate = new RestTemplate();
		Account account = restTemplate.postForObject(ACCOUNT_REST_URL, request, Account.class);
		return account;
	}
	
}
