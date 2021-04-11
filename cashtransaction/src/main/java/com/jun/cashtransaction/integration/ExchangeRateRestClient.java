package com.jun.cashtransaction.integration;

import org.json.JSONObject;

public interface ExchangeRateRestClient {

	public JSONObject getEuroBasedExchangeRates();
	public Double getEuroBasedUsdExchangeRate();
	
}
