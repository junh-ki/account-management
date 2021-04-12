package com.jun.restservice.services;

import java.util.List;

import com.jun.restservice.entities.Account;

public interface AccountService {

	public Account saveAccount(Account account);
	public Account getAccountById(Long accountId);
	public List<Account> getAllAccounts();
	public List<Account> getAccountsOfUser(Long userId);
	
}
