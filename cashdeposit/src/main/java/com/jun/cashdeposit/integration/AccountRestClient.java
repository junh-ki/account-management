package com.jun.cashdeposit.integration;

import java.util.List;

import com.jun.cashdeposit.integration.dto.Account;
import com.jun.cashdeposit.integration.dto.AccountUpdateRequest;

public interface AccountRestClient {

	public Account findAccountById(Long id);
	public List<Account> findAccountsByHolderId(Long id);
	public Account saveAccount(Account account);
	public Account updateAccount(AccountUpdateRequest request);
	
}
