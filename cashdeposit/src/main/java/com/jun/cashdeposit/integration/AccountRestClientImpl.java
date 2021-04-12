package com.jun.cashdeposit.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashdeposit.integration.dto.Account;
import com.jun.cashdeposit.integration.dto.AccountUpdateRequest;

@Component
public class AccountRestClientImpl implements AccountRestClient {

	private static final String ACCOUNT_REST_URL = "http://localhost:8080/restservice/accounts/";
	
	@Override
	public Account findAccountById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		Account account = restTemplate.getForObject(ACCOUNT_REST_URL + id, Account.class);
		return account;
	}
	
	@Override
	public List<Account> findAccountsByHolderId(Long id) {
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
	public Account saveAccount(Account account) {
		RestTemplate restTemplate = new RestTemplate();
		Account savedAccount = restTemplate.postForObject(ACCOUNT_REST_URL + "save", account, Account.class);
		return savedAccount;
	}
	
	@Override
	public Account updateAccount(AccountUpdateRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Account account = restTemplate.postForObject(ACCOUNT_REST_URL, request, Account.class);
		return account;
	}
	
}
