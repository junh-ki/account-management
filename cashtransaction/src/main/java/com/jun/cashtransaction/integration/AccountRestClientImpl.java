package com.jun.cashtransaction.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashtransaction.integration.dto.Account;
import com.jun.cashtransaction.integration.dto.AccountUpdateRequest;
import com.jun.cashtransaction.properties.MyConfigs;

@Component
public class AccountRestClientImpl implements AccountRestClient {

	@Autowired
	private MyConfigs myConfigs;
	private static final String ACCOUNT_REST_URL = "http://localhost:8080/restservice/accounts/";
	
	@Override
	public Account findAccountById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Account account;
		if (myConfigs.getREST_URL_ACCOUNT() != null) {
			account = restTemplate.getForObject(myConfigs.getREST_URL_ACCOUNT() + id, Account.class);
		} else {
			account = restTemplate.getForObject(ACCOUNT_REST_URL + id, Account.class);
		}
		return account;
	}
	
	@Override
	public List<Account> findAccountsByHolderId(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Account[]> response;
		if (myConfigs.getREST_URL_ACCOUNT() != null) {
			response = restTemplate.getForEntity(myConfigs.getREST_URL_ACCOUNT(), Account[].class);
		} else {
			response = restTemplate.getForEntity(ACCOUNT_REST_URL, Account[].class);
		}
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
		RestTemplate restTemplate = new RestTemplate();
		Account account;
		if (myConfigs.getREST_URL_ACCOUNT() != null) {
			account = restTemplate.postForObject(myConfigs.getREST_URL_ACCOUNT(), request, Account.class);
		} else {
			account = restTemplate.postForObject(ACCOUNT_REST_URL, request, Account.class);
		}
		return account;
	}
	
}
