package com.jun.cashtransaction.integration;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeRateRestClientImpl implements ExchangeRateRestClient {

	@Autowired
	private RestServiceUrl restServiceUrl;
	
	public JSONObject getEuroBasedExchangeRates() {
		RestTemplate restTemplate = new RestTemplate();
		String exchangeRates = restTemplate.getForObject(restServiceUrl.getExchangeApiUrl(), String.class);
		JSONObject jsonObject = new JSONObject(exchangeRates);
		JSONObject rates = jsonObject.getJSONObject("rates");
		return rates;
	}
	
	public Double getEuroBasedUsdExchangeRate() {
		JSONObject rates = getEuroBasedExchangeRates();
		Double usdRate = Double.valueOf(rates.get("USD").toString());
		return usdRate;
	}
	
}
