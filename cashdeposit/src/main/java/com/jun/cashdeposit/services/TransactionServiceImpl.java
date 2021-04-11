package com.jun.cashdeposit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.cashdeposit.entities.Transaction;
import com.jun.cashdeposit.repos.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Transaction getTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId).get();
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

}
