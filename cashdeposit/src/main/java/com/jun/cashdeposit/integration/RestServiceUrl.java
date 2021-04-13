package com.jun.cashdeposit.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestServiceUrl {
	
	@Value(value = "${rest.url:http://localhost:8080/restservice/}")
	private String restServiceUrl;

	public String getRestServiceUrl() {
		return restServiceUrl;
	}

	public void setRestServiceUrl(String restServiceUrl) {
		this.restServiceUrl = restServiceUrl;
	}
	
}
