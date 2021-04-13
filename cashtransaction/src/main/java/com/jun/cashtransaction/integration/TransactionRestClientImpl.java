package com.jun.cashtransaction.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashtransaction.integration.dto.Transaction;
import com.jun.cashtransaction.properties.MyConfigs;

@Component
public class TransactionRestClientImpl implements TransactionRestClient {
	
	@Autowired
	private MyConfigs myConfigs;
	private static final String TRANSACTION_REST_URL = "http://localhost:8080/restservice/transactions/";
	
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		RestTemplate restTemplate = new RestTemplate();
		Transaction savedTransaction;
		if (myConfigs.getREST_URL_TRANSACTION() != null) {
			savedTransaction = restTemplate.postForObject(myConfigs.getREST_URL_TRANSACTION(), transaction, Transaction.class);
		} else {
			savedTransaction = restTemplate.postForObject(TRANSACTION_REST_URL, transaction, Transaction.class);
		}
		return savedTransaction;
	}
	
}
