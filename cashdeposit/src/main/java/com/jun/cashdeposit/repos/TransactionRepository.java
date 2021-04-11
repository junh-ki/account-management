package com.jun.cashdeposit.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.cashdeposit.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}
