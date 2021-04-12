package com.jun.cashdeposit.integration;

import com.jun.cashdeposit.integration.dto.Deposit;

public interface DepositRestClient {
	
	public Deposit saveDeposit(Deposit deposit);

}
