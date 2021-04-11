package com.jun.cashdeposit.services;

import java.util.List;

import com.jun.cashdeposit.entities.Transaction;

public interface TransactionService {
	
	public Transaction getTransactionById(Long transactionId);
	public List<Transaction> getAllTransactions();
	public Transaction saveTransaction(Transaction transaction);
	
}
