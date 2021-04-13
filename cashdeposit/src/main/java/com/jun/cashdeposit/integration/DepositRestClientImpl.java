package com.jun.cashdeposit.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashdeposit.integration.dto.Deposit;

@Component
public class DepositRestClientImpl implements DepositRestClient {
	
	@Autowired
	private RestServiceUrl restServiceUrl;
	
	@Override
	public Deposit saveDeposit(Deposit deposit) {
		String DEPOSIT_REST_URL = restServiceUrl.getRestServiceUrl() + "deposits/";
		RestTemplate restTemplate = new RestTemplate();
		Deposit savedDeposit = restTemplate.postForObject(DEPOSIT_REST_URL, deposit, Deposit.class);
		return savedDeposit;
	}

}
