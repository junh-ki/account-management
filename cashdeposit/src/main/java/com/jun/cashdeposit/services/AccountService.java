package com.jun.cashdeposit.services;

import java.util.List;

import com.jun.cashdeposit.entities.Account;

public interface AccountService {

	public Account saveAccount(Account account);
	public List<Account> getAccountsOfUser(Long userId);
	
}
