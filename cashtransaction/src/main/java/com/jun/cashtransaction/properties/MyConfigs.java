package com.jun.cashtransaction.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class MyConfigs {

	private String REST_URL_ACCOUNT;
	private String REST_URL_USER;
	private String REST_URL_TRANSACTION;
	private String REST_URL_EXCHANGE_RATE;

	public String getREST_URL_ACCOUNT() {
		return REST_URL_ACCOUNT;
	}

	public void setREST_URL_ACCOUNT(String rEST_URL_ACCOUNT) {
		REST_URL_ACCOUNT = rEST_URL_ACCOUNT;
	}

	public String getREST_URL_USER() {
		return REST_URL_USER;
	}

	public void setREST_URL_USER(String rEST_URL_USER) {
		REST_URL_USER = rEST_URL_USER;
	}
	
	public String getREST_URL_TRANSACTION() {
		return REST_URL_TRANSACTION;
	}

	public void setREST_URL_TRANSACTION(String rEST_URL_TRANSACTION) {
		REST_URL_TRANSACTION = rEST_URL_TRANSACTION;
	}

	public String getREST_URL_EXCHANGE_RATE() {
		return REST_URL_EXCHANGE_RATE;
	}

	public void setREST_URL_EXCHANGE_RATE(String rEST_URL_EXCHANGE_RATE) {
		REST_URL_EXCHANGE_RATE = rEST_URL_EXCHANGE_RATE;
	}

}
