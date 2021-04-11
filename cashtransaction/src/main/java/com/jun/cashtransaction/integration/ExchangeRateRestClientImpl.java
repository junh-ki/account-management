package com.jun.cashtransaction.integration;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeRateRestClientImpl implements ExchangeRateRestClient {

	private static final String EURO_BASED_EXCHANGE_RATE_URL = "http://api.exchangeratesapi.io/v1/latest?access_key=35bbcdd96e0d471a96ab0a75f554cbf9";
	
	public JSONObject getEuroBasedExchangeRates() {
		RestTemplate restTemplate = new RestTemplate();
		String exchangeRates = restTemplate.getForObject(EURO_BASED_EXCHANGE_RATE_URL, String.class);
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
