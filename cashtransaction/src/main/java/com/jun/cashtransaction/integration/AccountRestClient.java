package com.jun.cashtransaction.integration;

import java.util.List;

import com.jun.cashtransaction.integration.dto.Account;
import com.jun.cashtransaction.integration.dto.AccountUpdateRequest;

public interface AccountRestClient {

	public Account findAccountById(Long id);
	public List<Account> findAccountsByHolderId(Long id);
	public Account updateAccount(AccountUpdateRequest request);
	
}
