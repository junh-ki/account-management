package com.jun.cashdeposit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jun.cashdeposit.entities.Transaction;
import com.jun.cashdeposit.services.TransactionService;

@RestController
@CrossOrigin
public class TransactionRestController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions/{id}")
	public Transaction findTransactionById(@PathVariable("id") Long id) {
		return transactionService.getTransactionById(id);
	}
	
	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		List<Transaction> transactions = transactionService.getAllTransactions();
		return transactions;
	}
	
	@PostMapping("/transactions")
	public Transaction saveTransaction(@RequestBody Transaction transaction) {
		return transactionService.saveTransaction(transaction);
	}
	
}
