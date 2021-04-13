package com.jun.cashdeposit.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.jun.cashdeposit.integration.dto.Deposit;
import com.jun.cashdeposit.properties.MyConfigs;

@Component
public class DepositRestClientImpl implements DepositRestClient {
	
	@Autowired
	private MyConfigs myConfigs;
	private static final String DEPOSIT_REST_URL = "http://localhost:8080/restservice/deposits/";
	
	@Override
	public Deposit saveDeposit(Deposit deposit) {
		RestTemplate restTemplate = new RestTemplate();
		Deposit savedDeposit;
		if (myConfigs.getREST_URL_DEPOSIT() != null) {
			savedDeposit = restTemplate.postForObject(myConfigs.getREST_URL_DEPOSIT(), deposit, Deposit.class);
		} else {
			savedDeposit = restTemplate.postForObject(DEPOSIT_REST_URL, deposit, Deposit.class);
		}
		return savedDeposit;
	}

}
