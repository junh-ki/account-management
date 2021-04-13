package com.jun.cashtransaction.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashtransaction.integration.dto.Transaction;

@Component
public class TransactionRestClientImpl implements TransactionRestClient {
	
	@Autowired
	private RestServiceUrl restServiceUrl;
	
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		String TRANSACTION_REST_URL = restServiceUrl.getRestServiceUrl() + "transactions/";
		RestTemplate restTemplate = new RestTemplate();
		Transaction savedTransaction = restTemplate.postForObject(TRANSACTION_REST_URL, transaction, Transaction.class);
		return savedTransaction;
	}
	
}
