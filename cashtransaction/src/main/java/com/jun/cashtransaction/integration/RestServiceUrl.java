package com.jun.cashtransaction.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestServiceUrl {
	
	@Value(value = "${rest.url:http://localhost:8080/restservice/}")
	private String restServiceUrl;

	@Value(value = "${exchange.url:http://api.exchangeratesapi.io/v1/latest?access_key=35bbcdd96e0d471a96ab0a75f554cbf9}")
	private String exchangeApiUrl;
	
	public String getRestServiceUrl() {
		return restServiceUrl;
	}

	public void setRestServiceUrl(String restServiceUrl) {
		this.restServiceUrl = restServiceUrl;
	}

	public String getExchangeApiUrl() {
		return exchangeApiUrl;
	}

	public void setExchangeApiUrl(String exchangeApiUrl) {
		this.exchangeApiUrl = exchangeApiUrl;
	}
	
}
