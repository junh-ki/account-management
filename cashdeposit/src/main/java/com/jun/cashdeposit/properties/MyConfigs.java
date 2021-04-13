package com.jun.cashdeposit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class MyConfigs {

	private String REST_URL_ACCOUNT;
	private String REST_URL_USER;
	private String REST_URL_DEPOSIT;

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

	public String getREST_URL_DEPOSIT() {
		return REST_URL_DEPOSIT;
	}

	public void setREST_URL_DEPOSIT(String rEST_URL_DEPOSIT) {
		REST_URL_DEPOSIT = rEST_URL_DEPOSIT;
	}

}
