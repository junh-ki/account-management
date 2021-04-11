package com.jun.cashtransaction.integration.dto;

public class Transaction {

	private Long id;
	private Double sendAmount;
	private Double receiveAmount;
	private String sendCurrency;
	private String receiveCurrency;
	private Long senderAccountId;
	private Long recipientAccountId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSendAmount() {
		return sendAmount;
	}

	public void setSendAmount(Double sendAmount) {
		this.sendAmount = sendAmount;
	}

	public Double getReceiveAmount() {
		return receiveAmount;
	}

	public void setReceiveAmount(Double receiveAmount) {
		this.receiveAmount = receiveAmount;
	}

	public String getSendCurrency() {
		return sendCurrency;
	}

	public void setSendCurrency(String sendCurrency) {
		this.sendCurrency = sendCurrency;
	}

	public String getReceiveCurrency() {
		return receiveCurrency;
	}

	public void setReceiveCurrency(String receiveCurrency) {
		this.receiveCurrency = receiveCurrency;
	}

	public Long getSenderAccountId() {
		return senderAccountId;
	}

	public void setSenderAccountId(Long senderAccountId) {
		this.senderAccountId = senderAccountId;
	}

	public Long getRecipientAccountId() {
		return recipientAccountId;
	}

	public void setRecipientAccountId(Long recipientAccountId) {
		this.recipientAccountId = recipientAccountId;
	}
	
}
