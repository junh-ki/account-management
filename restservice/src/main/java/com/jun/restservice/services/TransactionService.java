package com.jun.restservice.services;

import java.util.List;

import com.jun.restservice.entities.Transaction;

public interface TransactionService {
	
	public Transaction getTransactionById(Long transactionId);
	public List<Transaction> getAllTransactions();
	public Transaction saveTransaction(Transaction transaction);
	
}
