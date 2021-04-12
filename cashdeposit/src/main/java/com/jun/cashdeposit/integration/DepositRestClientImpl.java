package com.jun.cashdeposit.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashdeposit.integration.dto.Deposit;

@Component
public class DepositRestClientImpl implements DepositRestClient {
	
	private static final String ACCOUNT_REST_URL = "http://localhost:8080/restservice/deposits/";
	
	@Override
	public Deposit saveDeposit(Deposit deposit) {
		RestTemplate restTemplate = new RestTemplate();
		Deposit savedDeposit = restTemplate.postForObject(ACCOUNT_REST_URL, deposit, Deposit.class);
		return savedDeposit;
	}

}
