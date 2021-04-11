package com.jun.cashtransaction.integration;

import com.jun.cashtransaction.integration.dto.Transaction;

public interface TransactionRestClient {
	
	public Transaction saveTransaction(Transaction transaction);
	
}
