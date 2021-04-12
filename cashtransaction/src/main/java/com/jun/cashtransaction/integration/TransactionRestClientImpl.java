package com.jun.cashtransaction.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashtransaction.integration.dto.Transaction;

@Component
public class TransactionRestClientImpl implements TransactionRestClient {
	
	private static final String TRANSACTION_REST_URL = "http://localhost:8080/restservice/transactions/";
	
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		RestTemplate restTemplate = new RestTemplate();
		Transaction savedTransaction = restTemplate.postForObject(TRANSACTION_REST_URL, transaction, Transaction.class);
		return savedTransaction;
	}
	
}
