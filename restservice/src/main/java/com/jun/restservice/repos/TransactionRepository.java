package com.jun.restservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.restservice.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
}
