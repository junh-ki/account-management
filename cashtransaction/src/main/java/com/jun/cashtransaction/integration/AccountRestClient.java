package com.jun.cashtransaction.integration;

import com.jun.cashtransaction.integration.dto.Account;
import com.jun.cashtransaction.integration.dto.AccountUpdateRequest;

public interface AccountRestClient {

	public Account findAccount(Long id);
	public Account updateAccount(AccountUpdateRequest request);
	
}
